package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.CartSyncHelper;
import utils.UrlValidator;
import utils.UserNameGenerator;

/**
 * @author wiles42
 */
public class EndToEndPurchaseTest extends BaseTest {
    @Test
    public void registerUserCheckoutFlow(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CartSyncHelper cartSyncHelper = new CartSyncHelper(driver);
        String email = UserNameGenerator.generateEmail();
        String password = UserNameGenerator.generatePassword();

        registrationPage.setNavRegLink();
        registrationPage.setGenderMale();
        registrationPage.setFirstName("Wiley");
        registrationPage.setLastName("Griffin");

        registrationPage.setEmailInput(email);
        registrationPage.setPasswordInput(password);
        registrationPage.setConfirmPasswordPasswordInput(password);
        registrationPage.clickRegisterBtn();
        Assert.assertTrue(registrationPage.registrationSuccessMsgDisplayed());
        Assert.assertEquals(registrationPage.getRegistrationSuccessMsg(),"Your registration completed");


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







    }
}
