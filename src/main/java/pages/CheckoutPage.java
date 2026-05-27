package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver){
        super(driver);
    }
    By selectCountry = By.id("BillingNewAddress_CountryId");
    By selectState = By.id("BillingNewAddress_StateProvinceId");
    By selectCity = By.id("BillingNewAddress_City");
    By enterAddress = By.id("BillingNewAddress_Address1");
    By enterZipCode = By.id("BillingNewAddress_ZipPostalCode");
    By enterPhoneNumber = By.id("BillingNewAddress_PhoneNumber");
    By continueToShipBtn = By.cssSelector("input[onclick='Billing.save()']");
    By continueToMethodBtn = By.cssSelector("input[onclick='Shipping.save()']");
    By nextDayAirRadio = By.id("shippingoption_1");
    By continueToPaymentBtn = By.cssSelector("input[onclick='ShippingMethod.save()']");
    By creditCardPaymentRadio = By.id("paymentmethod_2");
    By continueToPayInfo = By.cssSelector("input[onclick='PaymentMethod.save()']");
    By continueToConfirmationBtn = By.cssSelector("input[onclick='PaymentInfo.save()']");
    By confirmOrderTotal = By.cssSelector(".order-total");
    By confirmOrderBtn = By.cssSelector("input[onclick='ConfirmOrder.save()']");
    By orderConfirmMessage = By.cssSelector(".title");

public void setSelectCountry(String country){
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(selectCountry));
    Select select = new Select(findElement(selectCountry));
    select.selectByVisibleText(country);
}
    public void waitForStateToBeAvailable(String stateName){

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(driver -> {

            Select select =
                    new Select(findElement(selectState));

            return select.getOptions()
                    .stream()
                    .anyMatch(option ->
                            option.getText().equals(stateName));
        });
    }
public void setSelectState(String state){
    Select select = new Select(findElement(selectState));
    select.selectByVisibleText(state);
}
public void setCity(String city){
    findElement(selectCity).sendKeys(city);

}
public void setEnterAddress(String address){
    findElement(enterAddress).sendKeys(address);
}
public void setEnterZipCode(String zipCode){
    findElement(enterZipCode).sendKeys(zipCode);
}
public void setEnterPhoneNumber(String phoneNumber){
    findElement(enterPhoneNumber).sendKeys(phoneNumber);
}
public void setContinueToShipBtn(){
    findElement(continueToShipBtn).click();
    waitForElementToBeClickable(continueToMethodBtn);
}
public void setContinueToMethodBtn(){
    findElement(continueToMethodBtn).click();
    waitForElementToBeClickable(nextDayAirRadio);
}
public void setNextDayAirRadio(){

    findElement(nextDayAirRadio).click();
}
public void setContinueToPaymentBtn(){
    findElement(continueToPaymentBtn).click();
    waitForElementToBeClickable(continueToPayInfo);
}
public void setContinueToPayInfo(){
    waitForElementToBeClickable(continueToPayInfo);
    findElement(continueToPayInfo).click();
    waitForElementToBeClickable(continueToConfirmationBtn);
}
public void setContinueToConfirmationBtn(){
    findElement(continueToConfirmationBtn).click();
}
public boolean verifyConfirmOrderTotal(){
    return findElement(confirmOrderTotal).isDisplayed();
}
public String verifyConfirmOrderTotalValue(){
    return findElement(confirmOrderTotal).getText();
}
public void setConfirmOrderBtn(){
    findElement(confirmOrderBtn).click();
}
public boolean verifyOrderConfirmationMessage(){
    return findElement(orderConfirmMessage).isDisplayed();
}









}
