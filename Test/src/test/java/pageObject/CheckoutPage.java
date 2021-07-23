package pageObject;

import org.openqa.selenium.WebElement;
import utils.Driver;
import org.openqa.selenium.By;

import java.util.List;

public class CheckoutPage extends BasePage{

    public static CheckoutPage checkoutPage = null;

    public By shoppingCartSummaryTitleLocator = By.id("cart_title");
    public By itemNumberLocator = By.id("summary_products_quantity");
    public By cartItemsLocator = By.xpath("//table[@id = 'cart_summary']//tbody//tr");
    public By deteleItemButtonLocator = By.xpath("//td//a[@title = 'Delete']");

    private CheckoutPage() {}

    public static CheckoutPage getInstance() {

        if (checkoutPage == null) {
            checkoutPage = new CheckoutPage();
        }

        return checkoutPage;
    }

    @Override
    public void waitForThePageToLoad() {

        driver.waitForElementToLoad(shoppingCartSummaryTitleLocator, "The checkout page did not load");
    }

    public int getCartItemNumber() {

        String itemNumberString = driver.webDriver.findElement(itemNumberLocator).getText();

        return Character.getNumericValue(itemNumberString.charAt(0));
    }

    // the items added to the cart are added after the last item already there
    public void deleteItemFromCart() {

        driver.waitForElementToLoad(cartItemsLocator);
        List<WebElement> cartItems = driver.webDriver.findElements(cartItemsLocator); // it was supposed to keep the DOM order
        cartItems.get(cartItems.size() - 1).findElement(deteleItemButtonLocator).click();

    }

    public void waitForThePageToRefresh() {
        driver.waitForTheElementToReload(itemNumberLocator);
    }
}
