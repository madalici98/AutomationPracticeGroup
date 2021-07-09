package com.softvision.automationPractice.pageObject;

import com.softvision.automationPractice.utils.Driver;
import org.openqa.selenium.By;

public class BasePage {

    public static Driver driver;

    public BasePage (Driver driver) {
        this.driver = driver;
    }

    public void waitForThePageToLoad(By pageIdentifiyingElementLocator) {
        driver.waitForElement(pageIdentifiyingElementLocator, "The page did not load");
    }

}
