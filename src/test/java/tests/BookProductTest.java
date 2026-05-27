package tests;


import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookProductPage;
import utils.SortValidator;
import utils.ViewModeValidator;
import java.util.List;

public class BookProductTest extends BaseTest {

    @Test
    public void bookFlowToCart (){
        BookProductPage bookProductPage = new BookProductPage(driver);

        bookProductPage.navBooksPage();
        Assert.assertTrue(bookProductPage.compAndInterPicVisible());
        bookProductPage.clickCompAndInterPicLink();
        Assert.assertTrue(bookProductPage.compAndInterDescriptionVisible());
        Assert.assertEquals(bookProductPage.comAndInterDescriptionText(),"Get to know everything about computing and the internet.");
        bookProductPage.setAddToCartBtn();
        Assert.assertTrue(bookProductPage.setBarNotificationSuccess());
        Assert.assertEquals(bookProductPage.verifyBarNotificationSuccessText(), "  The product has been added to your shopping cart");
    }
    @Test
    public void multipleBookFlowToCart(){
        BookProductPage bookProductPage = new BookProductPage(driver);

        bookProductPage.navBooksPage();
        Assert.assertTrue(bookProductPage.compAndInterPicVisible());
        bookProductPage.clickCompAndInterPicLink();
        Assert.assertTrue(bookProductPage.compAndInterDescriptionVisible());
        Assert.assertEquals(bookProductPage.comAndInterDescriptionText(),"Get to know everything about computing and the internet.");
        bookProductPage.setQuantityInput("3");
        bookProductPage.setAddToCartBtn();
        bookProductPage.waitForCartQuantity(3);
        System.out.println(bookProductPage.getCartQuantity());
        Assert.assertEquals(bookProductPage.getCartQuantity(),3);

    }


    @Test
    public void bookPriceLowToHigh() {
        BookProductPage bookProductPage = new BookProductPage(driver);

        bookProductPage.navBooksPage();
        bookProductPage.selectSortOption("Price: Low to High");
        List<Double> actualPrices = bookProductPage.getDisplayedPrices();

        System.out.println(actualPrices);

        SortValidator.assertSortedLowToHigh(actualPrices);
    }

    @Test
    public void bookPriceHighToLow() {
        BookProductPage bookProductPage = new BookProductPage(driver);

        bookProductPage.navBooksPage();
        bookProductPage.selectSortOption("Price: High to Low");
        List<Double> actualPrices = bookProductPage.getDisplayedPrices();
        SortValidator.assertSortedHighToLow(actualPrices);

    }

    @Test
    public void bookAToZ() {
        BookProductPage bookProductPage = new BookProductPage(driver);

        bookProductPage.navBooksPage();
        bookProductPage.selectSortOption("Name: A to Z");
        List<String> actualnames = bookProductPage.getDisplayedTitles();
        SortValidator.assertSortedAZ(actualnames);
    }
    @Test
    public void bookZToA() {
        BookProductPage bookProductPage = new BookProductPage(driver);

        bookProductPage.navBooksPage();
        bookProductPage.selectSortOption("Name: Z to A");
        List<String> actualnames = bookProductPage.getDisplayedTitles();
        SortValidator.assertSortedZA(actualnames);
    }
    @Test
    public void bookCreatedOnSort() {

        BookProductPage bookProductPage = new BookProductPage(driver);
        bookProductPage.navBooksPage();
        List<String> beforeSort = bookProductPage.getDisplayedTitles();
        bookProductPage.selectSortOption("Created on");
        List<String> afterSort = bookProductPage.getDisplayedTitles();
        Assert.assertNotEquals(afterSort, beforeSort,
                "Sorting by Created on did not change product order");
    }
    @Test
    public void selectGridMode(){
        BookProductPage bookProductPage = new BookProductPage(driver);
        bookProductPage.navBooksPage();
        bookProductPage.selectViewMode("List");
        bookProductPage.selectViewMode("Grid");
        ViewModeValidator.assertGridView(driver);

    }
    @Test
    public void selectListMode(){
        BookProductPage bookProductPage = new BookProductPage(driver);
        bookProductPage.navBooksPage();
        bookProductPage.selectViewMode("List");
        ViewModeValidator.assertListView(driver);
    }
}
