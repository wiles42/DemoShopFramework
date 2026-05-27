package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class UrlValidator {

    public static void assertCurrentUrl(WebDriver driver, String expectedUrl) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        Assert.assertEquals(
                driver.getCurrentUrl(),
                expectedUrl
        );
    }

}