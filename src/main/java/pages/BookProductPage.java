package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BookProductPage extends BasePage {
    public BookProductPage(WebDriver driver) {
        super(driver);
    }

    By selectBooks = By.xpath("(//a[@href='/books'])[3]");
    By prices = By.cssSelector(".price.actual-price");
    By titles = By.cssSelector(".product-title");
    By dropdown = By.id("products-orderby");
    By selectView = By.id("products-viewmode");
    By compAndInterPic = By.cssSelector("img[alt='Picture of Computing and Internet']");
    By compAndInterLink = By.xpath("(//a[@href='/computing-and-internet'])[1]");
    By compAndInterDescription = By.cssSelector(".full-description");
    By addToCartBtn = By.cssSelector(".add-to-cart-button");
    By quantityInput = By.cssSelector(".qty-input");
    By barNotificationSuccess = By.id("bar-notification");
    By quantityAmount = By.cssSelector("span.cart-qty");




    public void navBooksPage() {
        findElement(selectBooks).click();
    }
    public boolean compAndInterPicVisible(){
        return findElement(compAndInterPic).isDisplayed();
    }
    public void clickCompAndInterPicLink(){
        findElement(compAndInterLink).click();
    }
    public boolean compAndInterDescriptionVisible(){
        return findElement(compAndInterDescription).isDisplayed();
    }
    public String comAndInterDescriptionText() {
        return findElement(compAndInterDescription).getText();

    }
    public void setAddToCartBtn(){
        findElement(addToCartBtn).click();
    }
    public void waitForCartQuantity(int expectedQty){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                quantityAmount,
                "(" + expectedQty + ")"
        ));
    }
    public void setQuantityInput(String quantity){
        WebElement qtyInput = findElement(quantityInput);
        qtyInput.click();
        qtyInput.sendKeys(Keys.COMMAND, "a");
        qtyInput.sendKeys(Keys.BACK_SPACE);
        qtyInput.sendKeys(quantity);

    }
    public int getCartQuantity() {

        String text = driver.findElement(quantityAmount).getText();

        return Integer.parseInt(
                text.replace("(", "")
                        .replace(")", "")
                        .trim()
        );
    }
    public boolean setBarNotificationSuccess(){
       return findElement(barNotificationSuccess).isDisplayed();
    }
    public String verifyBarNotificationSuccessText(){
       return findElement(barNotificationSuccess).getText();
    }

    public void selectSortOption(String option) {
        Select select = new Select(findElement(dropdown));
        select.selectByVisibleText(option);

    }

    public List<Double> getDisplayedPrices() {
        List<WebElement> priceElements = driver.findElements(prices);
        List<Double> pricesList = new ArrayList<>();

        for (WebElement price : priceElements) {
            String text = price.getText()
                    .replace("$", "")
                    .replace(",", "")
                    .trim();
            pricesList.add(Double.parseDouble(text));

        }
        return pricesList;
    }

    public List<String> getDisplayedTitles() {
        List<WebElement> titleElements = driver.findElements(titles);
        List<String> titlesList = new ArrayList<>();

        for (WebElement title : titleElements) {
            String text = title.getText().trim();
            titlesList.add(text);

        }
        return titlesList;
    }

    public void selectViewMode(String option){
        Select select = new Select(findElement(selectView));
        select.selectByVisibleText(option);
    }

    }



