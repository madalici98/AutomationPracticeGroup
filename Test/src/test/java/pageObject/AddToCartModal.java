package pageObject;

import utils.Driver;
import org.openqa.selenium.By;

public class AddToCartModal extends BasePage{

    public static AddToCartModal addToCartModal = null;

    public By addToCartSuccessMessageLocator = By.xpath("//h2/i[@class = 'icon-ok']");
    public By proceedToCheckoutButtonLocator = By.xpath("//span[contains(text(), 'checkout')]");

    private AddToCartModal() {}

    public static AddToCartModal getInstance() {

        if (addToCartModal == null) {
            addToCartModal = new AddToCartModal();
        }

        return  addToCartModal;
    }

    @Override
    public void waitForThePageToLoad() {
        driver.waitForElementToLoad(addToCartSuccessMessageLocator, "The modal did not load");
    }

    public void proceedToCheckout() {

        driver.waitForElementToLoad(proceedToCheckoutButtonLocator);
        driver.webDriver.findElement(proceedToCheckoutButtonLocator).click();
    }
}
