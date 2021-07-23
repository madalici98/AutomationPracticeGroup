package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import pageObject.*;

import java.util.List;

public class OnlineShopTest extends BaseTest {

    protected HomePage homePage;
    protected SearchResultPage searchResultPage;
    protected ItemDetailsPage itemDetailsPage;
    protected AddToCartModal addToCartModal;
    protected CheckoutPage checkoutPage;

    // I misunderstood the exercise and I did this too
    /*@Test
    public void addToCartFromSearchPageTest() {

        String url = "http://automationpractice.com";
        By searchBoxLocator = By.id("search_query_top");
        By foundItemsListLocator = By.xpath("//ul[@class='product_list grid row']");
        By proceedToCheckoutButtonLocator = By.xpath("//div[@id='layer_cart']//span[contains(text(),'Proceed to checkout')]");

        driver = Driver.getInstance();
        driver.webDriver.manage().window().maximize();
        driver.navigate(url);

        driver.waitForElementToLoad(searchBoxLocator);
        WebElement searchBox = driver.webDriver.findElement(searchBoxLocator);
        searchBox.sendKeys("dress");
        searchBox.sendKeys(Keys.ENTER);

        driver.waitForElementToLoad(foundItemsListLocator);
        WebElement foundItemsList = driver.webDriver.findElement(foundItemsListLocator);
        WebElement firstItemFound = foundItemsList.findElement(By.tagName("li"));
        Actions actions = new Actions(driver.webDriver);
        actions.moveToElement(firstItemFound);
        actions.build().perform();
        WebElement addToCartButton = firstItemFound.findElement(By.xpath("//a//span[text()='Add to cart']"));
        addToCartButton.click();
        driver.waitForElementToLoad(proceedToCheckoutButtonLocator);
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
        driver.waitForElementToLoad(searchBoxLocator);
        WebElement searchBox = driver.webDriver.findElement(searchBoxLocator);
        searchBox.sendKeys("dress");
        searchBox.sendKeys(Keys.ENTER);

        // clicking the first item retrieved by the search
        driver.waitForElementToLoad(foundItemsListElementsLocator);
        // I could also use here "findElemenT", as it would have retrieved only the first found
        List<WebElement> foundItemsList = driver.webDriver.findElements(foundItemsListElementsLocator);
        foundItemsList.get(0).click();

        // adding the item to the shopping cart
        driver.waitForElementToLoad(addToCartButtonLocator);
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
        driver.waitForElementToLoad(searchBoxLocator);
        WebElement searchBox = driver.webDriver.findElement(searchBoxLocator);
        searchBox.sendKeys("dress");
        searchBox.sendKeys(Keys.ENTER);

        // clicking the first item retrieved by the search
        driver.waitForElementToLoad(foundItemsListElementsLocator);
        // I could also use here "findElemenT", as it would have retrieved only the first found
        List<WebElement> foundItemsList = driver.webDriver.findElements(foundItemsListElementsLocator);
        foundItemsList.get(0).findElement(By.xpath("//a[@class='product-name']")).click();

        // adding the item to the shopping cart
        driver.waitForElementToLoad(addToCartButtonLocator);
        WebElement addToCartButton = driver.webDriver.findElement(addToCartButtonLocator);
        addToCartButton.click();
        driver.waitForElementToLoad(proceedToCheckoutButtonLocator);

    }*/

    // the first exercise
    @Test
    public void addToCartFromItemPagePOMTest() {

        String url = "http://automationpractice.com";
        driver.navigate(url);

        homePage = HomePage.getInstance();
        homePage.waitForThePageToLoad();

        homePage.searchForItem("dress");

        searchResultPage = SearchResultPage.getInstance();
        searchResultPage.waitForThePageToLoad();

        searchResultPage.clickOnNthSearchResultItem(1);

        itemDetailsPage = ItemDetailsPage.getInstance();
        itemDetailsPage.waitForThePageToLoad();
        itemDetailsPage.addItemToCart();

        addToCartModal = AddToCartModal.getInstance();
        addToCartModal.waitForThePageToLoad();
    }

    // second exercise
    @Test
    public void changeSizeAndColorTest() {

        String url = "http://automationpractice.com";
        driver.navigate(url);

        homePage = HomePage.getInstance();
        homePage.waitForThePageToLoad();

        homePage.searchForItem("dress");

        searchResultPage = SearchResultPage.getInstance();
        searchResultPage.waitForThePageToLoad();

        searchResultPage.clickOnNthSearchResultItem(1);

        itemDetailsPage = ItemDetailsPage.getInstance();
        itemDetailsPage.waitForThePageToLoad();
        itemDetailsPage.changeSize("XL");
        itemDetailsPage.changeColor("Orange");
        itemDetailsPage.addItemToCart();

        addToCartModal = AddToCartModal.getInstance();
        addToCartModal.waitForThePageToLoad();
    }

    // third exercise
    @Test
    public void proceedToCheckoutAndDeleteItemTest() {

        int quantity = 3;
        int productsBeforeDelete, productsAfterDelete;

        String url = "http://automationpractice.com";
        driver.navigate(url);

        homePage = HomePage.getInstance();
        homePage.waitForThePageToLoad();
        homePage.searchForItem("dress");

        searchResultPage = SearchResultPage.getInstance();
        searchResultPage.waitForThePageToLoad();
        searchResultPage.clickOnNthSearchResultItem(5);

        itemDetailsPage = ItemDetailsPage.getInstance();
        itemDetailsPage.waitForThePageToLoad();
        itemDetailsPage.changeColor();
        itemDetailsPage.changeSize("S");
        itemDetailsPage.changeQuantity(quantity);
        itemDetailsPage.addItemToCart();

        addToCartModal = AddToCartModal.getInstance();
        addToCartModal.waitForThePageToLoad();
        addToCartModal.proceedToCheckout();

        checkoutPage = CheckoutPage.getInstance();
        checkoutPage.waitForThePageToLoad();
        productsBeforeDelete = checkoutPage.getCartItemNumber();
        checkoutPage.deleteItemFromCart();
        // I don't know how to make the webdriver wait for the element to refresh; it fails the test before
        // the text changes
        checkoutPage.waitForThePageToRefresh();
        productsAfterDelete = checkoutPage.getCartItemNumber();

        Assert.assertEquals(productsAfterDelete, productsBeforeDelete - quantity);
    }


}
