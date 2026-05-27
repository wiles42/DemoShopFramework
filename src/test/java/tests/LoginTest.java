package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegistrationPage;


public class LoginTest extends BaseTest {

    @Test
    public void LoginHappyPath() {
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        loginPage.setNavLogin();
        loginPage.setEmailInput("wiles@email.com");
        loginPage.setPasswordInput("password123");
        loginPage.clickLoginBtn();

        Assert.assertTrue(registrationPage.accountLinkIsDisplayed());
        Assert.assertEquals(registrationPage.getAccountLinkText(), "wiles@email.com");


    }

    @Test
    public void invalidPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.setNavLogin();
        loginPage.setEmailInput("wiles@email.com");
        loginPage.setPasswordInput("wrongpassword");
        loginPage.clickLoginBtn();

        Assert.assertTrue(loginPage.wrongCredentialDisplayed());

        String actual = loginPage.wrongCredentialText();
        Assert.assertTrue(actual.contains("Login was unsuccessful"), "Missing unsuccessful login message");
        Assert.assertTrue(actual.contains("try again"), "Missing 'try again' text");
        Assert.assertTrue(actual.contains("The credentials provided are incorrect"), "Missing invalid credential message");
    }

    @Test
    public void invalidEmail() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.setNavLogin();
        loginPage.setEmailInput("wiley@email.com");
        loginPage.setPasswordInput("password123");
        loginPage.clickLoginBtn();

        Assert.assertTrue(loginPage.wrongCredentialDisplayed());

        String actual = loginPage.wrongCredentialText();
        Assert.assertTrue(actual.contains("Login was unsuccessful"), "Missing unsuccessful login message");
        Assert.assertTrue(actual.contains("try again"), "Missing 'try again' text");
        Assert.assertTrue(actual.contains("No customer account found"), "Missing invalid account message");


    }

    @Test
    public void noCredentials() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.setNavLogin();
        loginPage.setEmailInput("");
        loginPage.setPasswordInput("");
        loginPage.clickLoginBtn();

        Assert.assertTrue(loginPage.wrongCredentialDisplayed());

        String actual = loginPage.wrongCredentialText();
        Assert.assertTrue(actual.contains("Login was unsuccessful"), "Missing unsuccessful login message");
        Assert.assertTrue(actual.contains("try again"), "Missing 'try again' text");
        Assert.assertTrue(actual.contains("No customer account found"), "Missing invalid account message");

    }
}
