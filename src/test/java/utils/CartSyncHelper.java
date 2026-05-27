package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartSyncHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    // LOCATORS (centralized for sync logic)
    private By cartQty = By.cssSelector(".cart-qty");
    private By successBar = By.cssSelector(".bar-notification.success");

    public CartSyncHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // -------------------------------
    // WAIT FOR SUCCESS MESSAGE
    // -------------------------------
    public void waitForAddToCartSuccess() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(successBar));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(successBar));
    }

    // -------------------------------
    // WAIT FOR CART QTY UPDATE
    // -------------------------------
    public void waitForCartQuantity(int expectedQty) {

        String expectedText = "(" + expectedQty + ")";

        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                cartQty,
                expectedText
        ));
    }

    // -------------------------------
    // SAFE GET CART QTY
    // -------------------------------
    public int getCartQuantity() {

        String text = driver.findElement(cartQty).getText();

        return Integer.parseInt(
                text.replace("(", "")
                        .replace(")", "")
                        .trim()
        );
    }
}
