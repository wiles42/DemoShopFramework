package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    By searchInput = By.cssSelector(".search-box-text");
    By searchBtn = By.cssSelector(".search-box-button");
    By searchResultComputing = By.xpath("(//h2[@class='product-title'])[1]");
    By searchSuggestions = By.xpath("//a[contains(@class,'ui-corner-all')]");
    By searchResultInvalid = By.cssSelector(".search-results");

    public void enterSearch(String search) {
        findElement(searchInput).sendKeys(search);
    }

    public void clickSearch() {
        findElement(searchBtn).click();
    }

    public boolean computingResult() {
        return findElement(searchResultComputing).isDisplayed();
    }

    public String computingResultText() {
        return findElement(searchResultComputing).getText();
    }

    public List<WebElement> getSearchSuggestion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchSuggestions));
        return driver.findElements(searchSuggestions);
    }

    public boolean invalidResult() {
        return findElement(searchResultInvalid).isDisplayed();
    }

    public String invalidResultText() {
        return findElement(searchResultInvalid).getText();
    }

    public String getSearchAlertText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String text = driver.switchTo().alert().getText();
        return text;
    }
    public void acceptSearchAlert(){
        driver.switchTo().alert().accept();
    }
}


