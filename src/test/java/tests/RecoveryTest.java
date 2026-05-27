package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.RegistrationPage;


public class RecoveryTest extends BaseTest {
    @Test
    public void LoginRecoveryHappyPath(){
        pages.RecoveryPage recoveryPage = new pages.RecoveryPage(driver);
        BasePage basePage = new BasePage(driver);

        recoveryPage.setNavLogin();
        recoveryPage.clickForgotPassword();
        Assert.assertEquals(basePage.getCurrentUrl(),"https://demowebshop.tricentis.com/passwordrecovery");
        Assert.assertTrue(recoveryPage.recoveryPageHeader());
        Assert.assertEquals(recoveryPage.recoveryPageHeaderText(),"Password recovery");
        recoveryPage.setRecoveryEmailInput("email@email.com");
        recoveryPage.clickRecoveryBtn();
        Assert.assertTrue(recoveryPage.recoveryMsgDisplayed());
        Assert.assertEquals(recoveryPage.recoveryMsgText(),"Email with instructions has been sent to you.");

    }
}
