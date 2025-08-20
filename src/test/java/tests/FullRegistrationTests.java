package tests;

import data.DataGeneration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

@Tag("form")
@DisplayName("Тесты для формы https://demoqa.com/automation-practice-form")
public class FullRegistrationTests extends TestBase {
    RegistrationPage steps = new RegistrationPage();
    DataGeneration data = new DataGeneration();

    @DisplayName("Полное заполнение формы")
    @Test
    void fullRegistration() {

        steps.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setUserEmail(data.userMail)
                .setGender(data.userGender)
                .setUserNumber(data.userPhone)
                .setDateOfBirth(data.calendarDay, data.calendarMoth, data.calendarYear)
                .setSubjects(data.userSubjects)
                .setHobbies(data.userHobbies)
                .uploadPicture(data.img)
                .setCurrentAddress(data.userCurrentAddres)
                .setState(data.userState)
                .setCity(data.userCity)
                .submitClick()
                .checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Student Email", data.userMail)
                .checkResult("Gender", data.userGender)
                .checkResult("Mobile", data.userPhone)
                .checkResult("Date of Birth", data.calendarDay + " "
                        + data.calendarMoth + ','
                        + data.calendarYear)
                .checkResult("Subjects", data.userSubjects)
                .checkResult("Hobbies", data.userHobbies)
                .checkResult("Picture", data.img)
                .checkResult("Address", data.userCurrentAddres)
                .checkResult("State and City", data.userState + " " + data.userCity);
    }

    @DisplayName("Минимальное заполнение формы")
    @Test
    void partialRegistration() {
        steps.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.userGender)
                .setUserNumber(data.userPhone)
                .submitClick()
                .checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Gender", data.userGender)
                .checkResult("Mobile", data.userPhone)
                .checkFormControl();
    }
}