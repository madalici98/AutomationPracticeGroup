package com.softvision.automationPractice.pageObject;

import com.softvision.automationPractice.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public By searchBoxLocator = By.id("search_query_top");

    public HomePage(Driver driver) {
        super(driver);
    }

    public void searchForItem(String itemName) {
        WebElement searchBox = driver.webDriver.findElement(searchBoxLocator);
        searchBox.sendKeys(itemName);
        searchBox.sendKeys(Keys.ENTER);
    }
}
