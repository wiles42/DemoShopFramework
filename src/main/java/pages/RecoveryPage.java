package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPage extends BasePage{
    public RecoveryPage(WebDriver driver){
        super(driver);
    }
    By navLogin = By.cssSelector(".ico-login");
    By forgotPassword = By.cssSelector("a[href='/passwordrecovery']");
    By recoveryEmailInput = By.id("Email");
    By recoveryBtn = By.cssSelector(".password-recovery-button");
    By recoveryMsg = By.xpath("//div[@class='result']");
    By recoveryPageTitle = By.cssSelector(".page-title");

    public void setNavLogin(){
        findElement(navLogin).click();
    }
    public void clickForgotPassword(){
        findElement(forgotPassword).click();
    }
    public void setRecoveryEmailInput(String email){
        findElement(recoveryEmailInput).sendKeys(email);
    }
    public void clickRecoveryBtn(){
        findElement(recoveryBtn).click();
    }
    public boolean recoveryPageHeader(){
        return findElement(recoveryPageTitle).isDisplayed();
    }
    public String recoveryPageHeaderText(){
        return findElement(recoveryPageTitle).getText();
    }
    public boolean recoveryMsgDisplayed(){
        return findElement(recoveryMsg).isDisplayed();
    }
    public String recoveryMsgText(){
        return findElement(recoveryMsg).getText();
    }
}
