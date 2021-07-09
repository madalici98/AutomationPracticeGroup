package tests;

import com.softvision.automationPractice.pageObject.HomePage;
import com.softvision.automationPractice.pageObject.ItemDetailsPage;
import com.softvision.automationPractice.pageObject.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.softvision.automationPractice.utils.Driver;

import java.util.List;

public class OnlineShopTest extends TestBase {

    protected HomePage homePage;
    protected SearchResultPage searchResultPage;
    protected ItemDetailsPage itemDetailsPage;

    /* What I found dificult/confusing:
        - XPaths for selecting the item in the search result page
     */

    // I misunderstood the exercise and I did this too
    @Test
    public void addToCartFromSearchPageTest() {

        String url = "http://automationpractice.com";
        By searchBoxLocator = By.id("search_query_top");
        By foundItemsListLocator = By.xpath("//ul[@class='product_list grid row']");
        By proceedToCheckoutButtonLocator = By.xpath("//div[@id='layer_cart']//span[contains(text(),'Proceed to checkout')]");

        driver = Driver.getInstance();
        driver.webDriver.manage().window().maximize();
        driver.navigate(url);

        driver.waitForElement(searchBoxLocator);
        WebElement searchBox = driver.webDriver.findElement(searchBoxLocator);
        searchBox.sendKeys("dress");
        searchBox.sendKeys(Keys.ENTER);

        driver.waitForElement(foundItemsListLocator);
        WebElement foundItemsList = driver.webDriver.findElement(foundItemsListLocator);
        WebElement firstItemFound = foundItemsList.findElement(By.tagName("li"));
        Actions actions = new Actions(driver.webDriver);
        actions.moveToElement(firstItemFound);
        actions.build().perform();
        WebElement addToCartButton = firstItemFound.findElement(By.xpath("//a//span[text()='Add to cart']"));
        addToCartButton.click();
        driver.waitForElement(proceedToCheckoutButtonLocator);
        WebElement proceedToCheckoutButton = driver.webDriver.findElement(proceedToCheckoutButtonLocator);
        proceedToCheckoutButton.click();

    }

    @Test
    public void addToCartFromQuickViewTest() {

        String url = "http://automationpractice.com";
        By searchBoxLocator = By.id("search_query_top");
        By foundItemsListElementsLocator = By.xpath("//ul[@class='product_list grid row']/li");
        By addToCartConfirmationPageIdentifierLocator = By.xpath("//h2/i[@class='icon-ok']");
        By addToCartButtonLocator = By.xpath("//span[text()='Add to cart']");

        // initializing & navigating to the page
        driver = Driver.getInstance();
        driver.webDriver.manage().window().maximize();
        driver.navigate(url);

        // search for "dress" in the searchbox at the top of the page
        driver.waitForElement(searchBoxLocator);
        WebElement searchBox = driver.webDriver.findElement(searchBoxLocator);
        searchBox.sendKeys("dress");
        searchBox.sendKeys(Keys.ENTER);

        // clicking the first item retrieved by the search
        driver.waitForElement(foundItemsListElementsLocator);
        // I could also use here "findElemenT", as it would have retrieved only the first found
        List<WebElement> foundItemsList = driver.webDriver.findElements(foundItemsListElementsLocator);
        foundItemsList.get(0).click();

        // adding the item to the shopping cart
        driver.waitForElement(addToCartButtonLocator);
        WebElement addToCartButton = driver.webDriver.findElement(addToCartButtonLocator);

    }

    @Test
    public void addToCartFromItemPageTest() {

        String url = "http://automationpractice.com";
        By searchBoxLocator = By.id("search_query_top");
        By foundItemsListElementsLocator = By.xpath("//ul[@class='product_list grid row']/li");
        By addToCartButtonLocator = By.xpath("//button/span[text()='Add to cart']");
        By proceedToCheckoutButtonLocator = By.xpath("//span[contains(text(), 'checkout')]");

        // initializing & navigating to the page
        driver = Driver.getInstance();
        driver.webDriver.manage().window().maximize();
        driver.navigate(url);

        // search for "dress" in the searchbox at the top of the page
        driver.waitForElement(searchBoxLocator);
        WebElement searchBox = driver.webDriver.findElement(searchBoxLocator);
        searchBox.sendKeys("dress");
        searchBox.sendKeys(Keys.ENTER);

        // clicking the first item retrieved by the search
        driver.waitForElement(foundItemsListElementsLocator);
        // I could also use here "findElemenT", as it would have retrieved only the first found
        List<WebElement> foundItemsList = driver.webDriver.findElements(foundItemsListElementsLocator);
        foundItemsList.get(0).findElement(By.xpath("//a[@class='product-name']")).click();

        // adding the item to the shopping cart
        driver.waitForElement(addToCartButtonLocator);
        WebElement addToCartButton = driver.webDriver.findElement(addToCartButtonLocator);
        addToCartButton.click();
        driver.waitForElement(proceedToCheckoutButtonLocator);

    }

    @Test
    public void addToCartFromItemPagePOMTest() {

        String url = "http://automationpractice.com";
        driver.navigate(url);

        homePage = new HomePage(driver);
        driver.waitForElement(homePage.searchBoxLocator);

        homePage.searchForItem("dress");

        searchResultPage = new SearchResultPage(driver);
        searchResultPage.waitForThePageToLoad(searchResultPage.foundItemsListElementsLocator);

        searchResultPage.clickOnNthSearchResultItem(1);

        itemDetailsPage = new ItemDetailsPage(driver);
        itemDetailsPage.waitForThePageToLoad(itemDetailsPage.addToCartButtonLocator);
        itemDetailsPage.addItemToCart();
        driver.waitForElement(itemDetailsPage.proceedToCheckoutButtonLocator, "The item could not be " +
                "added to cart");
    }

    @Test
    public void changeSizeAndColorTest() {

        String url = "http://automationpractice.com";
        By searchBoxLocator = By.id("search_query_top");
        By foundItemsListElementsLocator = By.xpath("//ul[@class='product_list grid row']/li");
        By addToCartButtonLocator = By.xpath("//button/span[text()='Add to cart']");
        By sizeSelectorLocator = By.xpath("//select[@id='group_1']");
        By colorSelectorLocator = By.xpath("//ul[@id='color_to_pick_list']");
        By proceedToCheckoutButtonLocator = By.xpath("//span[contains(text(), 'checkout')]");

        // initializing & navigating to the page
        driver = Driver.getInstance();
        driver.webDriver.manage().window().maximize();
        driver.navigate(url);

        // search for "dress" in the searchbox at the top of the page
        driver.waitForElement(searchBoxLocator);
        WebElement searchBox = driver.webDriver.findElement(searchBoxLocator);
        searchBox.sendKeys("dress");
        searchBox.sendKeys(Keys.ENTER);

        // clicking the first item retrieved by the search
        driver.waitForElement(foundItemsListElementsLocator);
        // I could also use here "findElemenT", as it would have retrieved only the first found
        List<WebElement> foundItemsList = driver.webDriver.findElements(foundItemsListElementsLocator);
        // the exercise demands working with the second item
        // it does not select the second item counting by rows, but rather the 4th (3rd index). why?
        foundItemsList.get(1).findElement(By.xpath("//a[@class='product-name']")).click();

        driver.waitForElement(sizeSelectorLocator);

        Select sizeSelector = new Select(driver.webDriver.findElement(sizeSelectorLocator));
        sizeSelector.selectByVisibleText("L");

        WebElement colorSelector = driver.webDriver.findElement(colorSelectorLocator);
        WebElement selectedColor = colorSelector.findElement(By.xpath("//li[@class != 'selected']/a"));
        selectedColor.click();

        driver.waitForElement(addToCartButtonLocator);
        WebElement addToCartButton = driver.webDriver.findElement(addToCartButtonLocator);
        addToCartButton.click();
        driver.waitForElement(proceedToCheckoutButtonLocator);

    }


}
