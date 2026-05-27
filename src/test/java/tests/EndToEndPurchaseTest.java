package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import utils.CartSyncHelper;
import utils.UrlValidator;

/**
 * @author wiles42
 */
public class EndToEndPurchaseTest extends BaseTest {
    @Test
    public void registeredUserCheckoutFlow(){
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        CartSyncHelper cartSyncHelper = new CartSyncHelper(driver);

        loginPage.setNavLogin();
        loginPage.setEmailInput("testing101@email.com");
        loginPage.setPasswordInput("password123");
        loginPage.clickLoginBtn();

        cartPage.navElectronics();
        cartPage.navCellPhones();
        cartPage.addSmartPhoneCart();

        cartSyncHelper.waitForAddToCartSuccess();
        cartSyncHelper.waitForCartQuantity(1);
        cartPage.navToCart();
        Assert.assertTrue(cartPage.productDisplayed());
        Assert.assertEquals(cartPage.correctSubTotal(), "100.00");

        cartPage.acceptTermsAndConditions();
        cartPage.setCheckOutBtn();

        checkoutPage.setSelectCountry("United States");
        checkoutPage.waitForStateToBeAvailable("New Jersey");
        checkoutPage.setSelectState("New Jersey");
        checkoutPage.setCity("Maplewood");
        checkoutPage.setEnterAddress("123 Main St");
        checkoutPage.setEnterZipCode("12345");
        checkoutPage.setEnterPhoneNumber("555-5555");
        checkoutPage.setContinueToShipBtn();
        checkoutPage.setContinueToMethodBtn();
        checkoutPage.setNextDayAirRadio();
        checkoutPage.setContinueToPaymentBtn();
        checkoutPage.setContinueToPayInfo();
        checkoutPage.setContinueToConfirmationBtn();

        Assert.assertTrue(checkoutPage.verifyConfirmOrderTotal());
        Assert.assertEquals(checkoutPage.verifyConfirmOrderTotalValue(),"107.00");

        checkoutPage.setConfirmOrderBtn();

        Assert.assertTrue(checkoutPage.verifyOrderConfirmationMessage());

        accountPage.clickAccountLink();
        accountPage.clickAddressesLink();
        accountPage.clickDeleteAddressBtn(); //The site take a long time to delete the address
        accountPage.clickLogOutLink();
        UrlValidator.assertCurrentUrl(driver,"https://demowebshop.tricentis.com/");





    }
}
