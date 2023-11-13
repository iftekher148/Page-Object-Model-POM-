package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utilities.DriverSetUp;

public class TestRegistration extends DriverSetUp {

    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    public void testUserRegistration(){
        getDriver().get(registrationPage.registrationUrl);
        //This can easily done by making a method on Registration page and called it on test page. See example....

//        registrationPage.clickOnElement(registrationPage.gender_male);
//        registrationPage.writeOnElement(registrationPage.first_Name,"MD");
//        registrationPage.writeOnElement(registrationPage.last_Name,"Karim");
//        registrationPage.selectWithVisibleText(registrationPage.DateOfBirthDay,"4");
//        registrationPage.selectWithVisibleText(registrationPage.DateOfBirthMonth,"April");
//        registrationPage.selectWithVisibleText(registrationPage.DateOfBirthYear,"2002");
//        registrationPage.writeOnElement(registrationPage.email_button,"test@gmail.com");
//        registrationPage.writeOnElement(registrationPage.company_Name,"XYZ");
//        registrationPage.writeOnElement(registrationPage.password,"abc1234");
//        registrationPage.writeOnElement(registrationPage.confirm_Password,"abc1234");
//        registrationPage.clickOnElement(registrationPage.registration_Button);

        registrationPage.registerUser();

        Assert.assertTrue(registrationPage.isElementVisible(registrationPage.registration_confirm_msg));
        Assert.assertEquals(registrationPage.getElementText(registrationPage.registration_confirm_msg),registrationPage.registration_confirm_text);

    }
}
