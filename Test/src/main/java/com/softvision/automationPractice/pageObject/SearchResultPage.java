package com.softvision.automationPractice.pageObject;

import com.softvision.automationPractice.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchResultPage extends BasePage{

    protected By foundItemsListLocator = By.xpath("//ul[@class='product_list grid row']");
    public By foundItemsListElementsLocator = By.xpath("//ul[@class='product_list grid row']/li");
    protected By addToCartConfirmationPageIdentifierLocator = By.xpath("//h2/i[@class='icon-ok']");
    protected By addToCartButtonLocator = By.xpath("//span[text()='Add to cart']");
    protected By proceedToCheckoutButtonLocator = By.xpath("//div[@id='layer_cart']//span[contains(text(),'Proceed to checkout')]");

    public SearchResultPage(Driver driver) {
        super(driver);
    }

    public void clickOnNthSearchResultItem(int position) {

        List<WebElement> foundItemsList = driver.webDriver.findElements(foundItemsListLocator);
        try {
            foundItemsList.get(position - 1).findElement(foundItemsListElementsLocator).click();
        } catch (IndexOutOfBoundsException e) {
            Assert.assertTrue(1 == 2, "The item with the specified index does not exist");
        }
    }

}
