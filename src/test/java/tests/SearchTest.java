package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

import java.util.List;


public class SearchTest extends BaseTest {

    @Test
    public void searchHappyPath() {
        SearchPage searchPage = new SearchPage(driver);

        searchPage.enterSearch("Computing and Internet");
        searchPage.clickSearch();
        Assert.assertTrue(searchPage.computingResult());
        Assert.assertEquals(searchPage.computingResultText(), "Computing and Internet");
    }

    @Test
    public void searchAutoComplete() {
        SearchPage searchPage = new SearchPage(driver);

        searchPage.enterSearch("Comp");
        List<WebElement> results = searchPage.getSearchSuggestion();
        Assert.assertFalse(results.isEmpty());
        boolean matchFound = results.stream().anyMatch(result -> result.getText().toLowerCase().contains("computer"));
        Assert.assertTrue(matchFound);
    }

    @Test
    public void searchInvalidItem() {
        SearchPage searchPage = new SearchPage(driver);

        searchPage.enterSearch("Guitar");
        searchPage.clickSearch();
        Assert.assertTrue(searchPage.invalidResult());
        Assert.assertEquals(searchPage.invalidResultText(), "No products were found that matched your criteria.");
    }
    @Test
    public void emptySearch(){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickSearch();
        Assert.assertEquals(searchPage.getSearchAlertText(),"Please enter some search keyword");
        searchPage.acceptSearchAlert();
    }
    @Test
    public void speacialCharactersSearch() {
        SearchPage searchPage = new SearchPage(driver);

        searchPage.enterSearch("!@##$$%");
        searchPage.clickSearch();
        Assert.assertTrue(searchPage.invalidResult());
        Assert.assertEquals(searchPage.invalidResultText(), "No products were found that matched your criteria.");
    }
}
