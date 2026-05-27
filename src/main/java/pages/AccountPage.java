package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author wiles42
 */
public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver){
        super(driver);}
    By accountLink = By.xpath("(//a[@href='/customer/info'])[1]");
    By addressesLink = By.xpath("(//a[@href='/customer/addresses'])[1]");
    By deleteAddressBtn = By.cssSelector(".delete-address-button");
    By logOutLink = By.cssSelector("a.ico-logout");

    public void clickAccountLink(){
        findElement(accountLink).click();
    }
    public void clickAddressesLink(){
        findElement(addressesLink).click();
    }
    public void clickDeleteAddressBtn(){
        findElement(deleteAddressBtn).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
    public void clickLogOutLink(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(logOutLink));
        findElement(logOutLink).click();
        wait.until(ExpectedConditions.urlContains("demowebsho"));
    }


}
