package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitClick = $("#submit"),
            formWrapper = $(".practice-form-wrapper"),
            tableResponsive = $(".table-responsive");


    CalendarComponent calendarComponent = new CalendarComponent();
    StateAndCityComponent stateAndCity = new StateAndCityComponent();

    @Step("Открытие страницы")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        formWrapper.shouldHave(text("Student Registration Form"));
        return this;
    }

    @Step("Ввод имени {value}")
    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Ввод фамилии {value}")
    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Ввод email {value}")
    public RegistrationPage setUserEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Выбор пола {value}")
    public RegistrationPage setGender(String value){
        genderWrapperInput.$(byText(value)).click();
        return this;
    }

    @Step("Ввод телефона {value}")
    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Ввод даты рождения {day}.{month}.{year}")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Выбор предмета {value}")
    public RegistrationPage setSubjects(String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбор хобби {value}")
    public RegistrationPage setHobbies(String value){
        hobbiesWrapperInput.$(byText(value)).click();
        return this;
    }

    @Step("Добавление картинки")
    public RegistrationPage uploadPicture(String value){
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    @Step("Ввод адреса {value}")
    public RegistrationPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }

    @Step("Выбор штата {value}")
    public RegistrationPage setState(String value){
        stateInput.click();
        stateAndCity.setState(value);
        return this;
    }

    @Step("Выбор города {value}")
    public RegistrationPage setCity(String value){
        cityInput.click();
        stateAndCity.setCity(value);
        return this;
    }

    @Step("Нажатие на кнопку Submit")
    public RegistrationPage submitClick(){
        submitClick.click();
        return this;
    }

    @Step("Проверка полей результирующей страницы - {key} : {value}")
    public RegistrationPage checkResult(String key, String value) {
        tableResponsive.$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }

    @Step("Проверка названия формы")
    public void checkFormControl(){
        formWrapper.shouldHave(text("Student Registration Form"));
    }
}