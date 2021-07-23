package pageObject;

import utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    private static HomePage homePage = null;

    public By searchBoxLocator = By.id("search_query_top");

    private HomePage() {}

    public static HomePage getInstance() {

        if (homePage == null) {
            homePage = new HomePage();
        }

        return homePage;
    }

    public void searchForItem(String itemName) {
        WebElement searchBox = driver.webDriver.findElement(searchBoxLocator);
        searchBox.sendKeys(itemName);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void waitForThePageToLoad() {
        driver.waitForElementToLoad(searchBoxLocator, "The page did not load");
    }
}
