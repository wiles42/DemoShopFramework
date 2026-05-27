package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utils.UserNameGenerator;


public class RegistrationTest extends BaseTest {
    @Test
    public void registrationTestHappyPath(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String email = UserNameGenerator.generateEmail();
        String password = UserNameGenerator.generatePassword();

        registrationPage.setNavRegLink();
        registrationPage.setGenderMale();
        registrationPage.setFirstName("Wiley");
        registrationPage.setLastName("Griffin");

        registrationPage.setEmailInput(email);
        registrationPage.setPasswordInput(password);
        registrationPage.setConfirmPasswordPasswordInput(password);
        registrationPage.clickRegisterBtn();

        Assert.assertTrue(registrationPage.registrationSuccessMsgDisplayed());
        Assert.assertEquals(registrationPage.getRegistrationSuccessMsg(),"Your registration completed");

        registrationPage.clickContinueBtn();

        Assert.assertTrue(registrationPage.accountLinkIsDisplayed());
        Assert.assertEquals(registrationPage.getAccountLinkText(), email);

    }
    @Test
    public void NegativeRegistrationTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.setNavRegLink();
        registrationPage.clickRegisterBtn();

        Assert.assertTrue(registrationPage.firstNameErrorDisplayed());
        Assert.assertEquals(registrationPage.firstNameErrorMsg(), "First name is required.");

        Assert.assertTrue(registrationPage.lastNameErrorDisplayed());
        Assert.assertEquals(registrationPage.lastNameErrorMsg(), "Last name is required.");

        Assert.assertTrue(registrationPage.emailErrorDisplayed());
        Assert.assertEquals(registrationPage.emailErrorMsg(), "Email is required.");

        Assert.assertTrue(registrationPage.passwordErrorDisplayed());
        Assert.assertEquals(registrationPage.passwordErrorMsg(), "Password is required.");

        Assert.assertTrue(registrationPage.confirmPasswordErrorDisplayed());
        Assert.assertEquals(registrationPage.confirmPasswordErrorMsg(), "Password is required.");
    }

    @Test
    public void invalidEmailTest () {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.setNavRegLink();
        registrationPage.clickRegisterBtn();
        registrationPage.setEmailInput("wiley");

        Assert.assertTrue(registrationPage.emailErrorDisplayed());
        Assert.assertEquals(registrationPage.emailErrorMsg(), "Wrong email");

    }
    @Test
    public void invalidPasswordTest(){
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.setNavRegLink();
        registrationPage.clickRegisterBtn();
        registrationPage.setPasswordInput("your1234");
        registrationPage.setConfirmPasswordPasswordInput("your");

        Assert.assertTrue(registrationPage.confirmPasswordErrorDisplayed());
        Assert.assertEquals(registrationPage.confirmPasswordErrorMsg(),"The password and confirmation password do not match.");

        registrationPage.clearPasswordInput("you");

        Assert.assertTrue(registrationPage.passwordErrorDisplayed());
        Assert.assertEquals(registrationPage.passwordErrorMsg(), "The password should have at least 6 characters.");




    }

}
