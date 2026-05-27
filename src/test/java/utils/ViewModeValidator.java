package utils;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViewModeValidator {

    public static void assertGridView(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("viewmode=grid"));

        Assert.assertTrue(
                driver.getCurrentUrl().contains("viewmode=grid"),
                "Grid view not applied in URL"
        );
    }

    public static void assertListView(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("viewmode=list"));

        Assert.assertTrue(
                driver.getCurrentUrl().contains("viewmode=list"),
                "List view not applied in URL"
        );
    }
}