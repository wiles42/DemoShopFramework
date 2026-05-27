package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.bidi.Command;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver){
        super(driver);
    }

    By electronicsLink = By.xpath("(//a[@href='/electronics'])[1]");
    By cellPhoneLink = By.xpath("(//a[@href='/cell-phones'])[4]");
    By smartPhoneAdd = By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[1]");
    By goToCartLink = By.xpath("(//a[@href='/cart'])[2]");
    By productName = By.xpath("(//a[@href='/smartphone'])[3]");
    By productSubTotal = By.cssSelector(".product-subtotal");
    By continueShopping = By.cssSelector(".continue-shopping-button");
    By updateQuantity = By.cssSelector(".qty-input");
    By termsLabel = By.xpath("//input[@name='termsofservice']");
    By checkOutBtn = By.cssSelector(".checkout-button");
    By removeFromCart = By.xpath("//input[@name='termsofservice']");
    By emptyCartTitle = By.cssSelector(".page-title");


    public void navElectronics(){
        findElement(electronicsLink).click();
    }
    public void navCellPhones(){
        findElement(cellPhoneLink).click();
    }
    public void addSmartPhoneCart(){
        findElement(smartPhoneAdd).click();
    }
    public void navToCart(){
        findElement(goToCartLink).click();
    }
    public boolean productDisplayed(){
        return findElement(productName).isDisplayed();
    }
    public String correctSubTotal(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(productSubTotal));
        return findElement(productSubTotal).getText();
    }
    public void setContinueShopping(){
        findElement(continueShopping).click();
    }
    public void setUpdateCart(String quantity){
        WebElement quantityUpdate = findElement(updateQuantity);
        quantityUpdate.click();
        quantityUpdate.sendKeys(Keys.COMMAND,"a");
        quantityUpdate.sendKeys(Keys.BACK_SPACE);
        quantityUpdate.sendKeys(quantity);
        quantityUpdate.sendKeys(Keys.ENTER);

    }
    public boolean emptyCartTitleDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartTitle));
        return findElement(emptyCartTitle).isDisplayed();
    }
    public void acceptTermsAndConditions(){

        WebElement label =
                findElement(termsLabel);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", label);

        label.click();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(driver ->
                findElement(By.id("termsofservice")).isSelected()
        );
    }
    public void setCheckOutBtn(){
        findElement(checkOutBtn).click();
    }



}
