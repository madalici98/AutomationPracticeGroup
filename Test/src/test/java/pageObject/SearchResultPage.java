package pageObject;

import utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchResultPage extends BasePage{

    private static SearchResultPage searchResultPage = null;

    public By foundItemsListElementsLocator = By.xpath("//ul[@class='product_list grid row']/li");

    private SearchResultPage() {}

    public static SearchResultPage getInstance() {

        if (searchResultPage == null) {
            searchResultPage = new SearchResultPage();
        }

        return searchResultPage;
    }

    public void waitForThePageToLoad() {
        driver.waitForElementToLoad(foundItemsListElementsLocator, "The page did not load");
    }

    public void clickOnNthSearchResultItem(int position) {

        List<WebElement> foundItemsList = driver.webDriver.findElements(foundItemsListElementsLocator);
        try {
            foundItemsList.get(position - 1).click();
        } catch (IndexOutOfBoundsException e) {
            Assert.assertTrue(1 == 2, "The item with the specified index does not exist");
        }
    }

}
