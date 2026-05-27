package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver){
        super(driver);
    }
    By navRegLink = By.cssSelector(".ico-register");
    By genderMale = By.id("gender-male");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By emailInput = By.id("Email");
    By passwordInput = By.id("Password");
    By confirmPassword = By.id("ConfirmPassword");
    By registerBtn = By.id("register-button");
    By resultMsg = By.xpath("//div[@class='result']");
    By continueBtn = By.xpath("//input[@class='button-1 register-continue-button']");
    By verifyAccount = By.xpath("(//a[@class='account'])[1]");
    By errorMsgFirstName = By.cssSelector("span[data-valmsg-for='FirstName']");
    By errorMsgLastName = By.cssSelector("span[data-valmsg-for='LastName']");
    By errorMsgEmail = By.cssSelector("span[data-valmsg-for='Email']");
    By errorPassword= By.cssSelector("span[data-valmsg-for='Password']");
    By errorConfirmPassword= By.cssSelector("span[data-valmsg-for='ConfirmPassword']");




    public void setNavRegLink(){
        findElement(navRegLink).click();
    }
    public void setGenderMale(){
        findElement(genderMale).click();
    }
    public void setFirstName(String name1){
        findElement(firstName).sendKeys(name1);
    }
    public void setLastName(String name2){
        findElement(lastName).sendKeys(name2);
    }
    public void setEmailInput(String email){
        findElement(emailInput).sendKeys(email);
    }
    public void setPasswordInput(String password){
        findElement(passwordInput).sendKeys(password);
    }
    public void clearPasswordInput(String password){
        WebElement passwordField = findElement(passwordInput);
        passwordField.clear();
        passwordField.sendKeys("you");

    }
    public void setConfirmPasswordPasswordInput(String passwordVer){
        findElement(confirmPassword).sendKeys(passwordVer);
    }
    public void clickRegisterBtn (){
        findElement(registerBtn).click();
    }
    public boolean registrationSuccessMsgDisplayed(){
        return findElement(resultMsg).isDisplayed();
    }
    public String getRegistrationSuccessMsg(){
        return findElement(resultMsg).getText();
    }
    public void clickContinueBtn(){
        findElement(continueBtn).click();
    }
    public boolean accountLinkIsDisplayed (){
        return findElement(verifyAccount).isDisplayed();
    }
    public String getAccountLinkText(){
        return findElement(verifyAccount).getText();
    }
    public boolean firstNameErrorDisplayed(){
        return findElement(errorMsgFirstName).isDisplayed();
    }
    public String firstNameErrorMsg(){
        return findElement(errorMsgFirstName).getText();
    }
    public boolean lastNameErrorDisplayed(){
        return findElement(errorMsgLastName).isDisplayed();
    }
    public String lastNameErrorMsg(){
        return findElement(errorMsgLastName).getText();
    }
    public boolean emailErrorDisplayed(){
        return findElement(errorMsgEmail).isDisplayed();
    }
    public String emailErrorMsg(){
        return findElement(errorMsgEmail).getText();
    }
    public boolean passwordErrorDisplayed(){
        return findElement(errorPassword).isDisplayed();
    }
    public String passwordErrorMsg(){
        return findElement(errorPassword).getText();
    }
    public boolean confirmPasswordErrorDisplayed(){
        return findElement(errorConfirmPassword).isDisplayed();
    }
    public String confirmPasswordErrorMsg(){
        return findElement(errorConfirmPassword).getText();
    }












}
