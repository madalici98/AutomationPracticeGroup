package com.softvision.automationPractice.pageObject;

import com.softvision.automationPractice.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ItemDetailsPage extends BasePage{

    public By addToCartButtonLocator = By.xpath("//button/span[text()='Add to cart']");
    public By proceedToCheckoutButtonLocator = By.xpath("//span[contains(text(), 'checkout')]");

    public ItemDetailsPage(Driver driver) {
        super(driver);
    }

    public void addItemToCart() {
        driver.webDriver.findElement(addToCartButtonLocator).click();
    }
}
