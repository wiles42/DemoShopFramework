package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import utils.CartSyncHelper;
import utils.UrlValidator;

public class CartTest extends BaseTest {
    @Test
    public void happyPathCellTest() {
        CartPage cartPage = new CartPage(driver);
        CartSyncHelper cartSyncHelper = new CartSyncHelper(driver);

        cartPage.navElectronics();
        cartPage.navCellPhones();
        cartPage.addSmartPhoneCart();

        cartSyncHelper.waitForAddToCartSuccess();
        cartSyncHelper.waitForCartQuantity(1);
        cartPage.navToCart();
        Assert.assertTrue(cartPage.productDisplayed());
        Assert.assertEquals(cartPage.correctSubTotal(), "100.00");
        cartPage.setContinueShopping();
        UrlValidator.assertCurrentUrl(driver, "https://demowebshop.tricentis.com/cell-phones");


    }

    @Test
    public void updateQuantityCellTest() {
        CartPage cartPage = new CartPage(driver);
        CartSyncHelper cartSyncHelper = new CartSyncHelper(driver);

        cartPage.navElectronics();
        cartPage.navCellPhones();
        cartPage.addSmartPhoneCart();
        cartSyncHelper.waitForAddToCartSuccess();
        cartSyncHelper.waitForCartQuantity(1);
        cartPage.navToCart();
        cartPage.setUpdateCart("5");
        Assert.assertEquals(cartPage.correctSubTotal(), "500.00");

    }

    @Test
    public void invalidQuantityCellTest() {
        CartPage cartPage = new CartPage(driver);
        CartSyncHelper cartSyncHelper = new CartSyncHelper(driver);

        cartPage.navElectronics();
        cartPage.navCellPhones();
        cartPage.addSmartPhoneCart();
        cartSyncHelper.waitForAddToCartSuccess();
        cartSyncHelper.waitForCartQuantity(1);
        cartPage.navToCart();
        cartPage.setUpdateCart("-600");
        Assert.assertTrue(cartPage.emptyCartTitleDisplayed()); //this is a bug
    }
}
