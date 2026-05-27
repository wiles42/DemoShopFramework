package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By navLogin = By.cssSelector(".ico-login");
    By emailInput = By.id("Email");
    By passwordInput = By.id("Password");
    By loginBtn = By.cssSelector(".login-button");
    By wrongCredentialError = By.cssSelector(".validation-summary-errors");

    public void setNavLogin(){
        findElement(navLogin).click();
    }
    public void setEmailInput(String email){
        findElement(emailInput).sendKeys(email);
    }
    public void setPasswordInput(String password){
        findElement(passwordInput).sendKeys(password);
    }
    public void clickLoginBtn(){
        findElement(loginBtn).click();
    }
    public boolean wrongCredentialDisplayed(){
        return findElement(wrongCredentialError).isDisplayed();

    }
    public String wrongCredentialText(){
        return findElement(wrongCredentialError).getText();
    }
}
