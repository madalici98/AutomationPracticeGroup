package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static Driver driver = null;
    public RemoteWebDriver webDriver;
    private WebDriverWait wait;

    private Driver() {

        setNewDriver();
        wait = new WebDriverWait(webDriver, 40);
    }

    public static  Driver getInstance(){
        if(driver == null){
            driver = new Driver();
        }
        return driver;
    }

    public void setNewDriver(){
        try{
            if(webDriver!= null){
                webDriver.close();
                webDriver.quit();
            }
        }
        catch (Exception e){

        }
        finally {

            System.setProperty("webdriver.chrome.driver","/Users/madalina.pietreanu/IdeaProjects/AutomationPracticeGroup/Test/src/chromedriver");
            webDriver = new ChromeDriver();
            // webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public void exit() {
        try {
            if (webDriver != null) {
                webDriver.close();
                webDriver.quit();
            }
        } catch (Exception e) {

        } finally {
            webDriver = null;
            driver = null;
        }
    }

    public void navigate(String url) {
        webDriver.get(url);
    }

    public void waitForElementToLoad(By webElementLocator, String... message) {

        String messageToDisplay;

        if (message.length > 0) {
            messageToDisplay = Arrays.stream(message).toList().get(0);
        } else {
            messageToDisplay = "The element does not exist";
        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(webElementLocator));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(1 == 2, messageToDisplay);
        }

    }

    public void waitForElementToBecomeClickable(By webElementLocator, String... message) {

        String messageToDisplay;

        if (message.length > 0) {
            messageToDisplay = Arrays.stream(message).toList().get(0);
        } else {
            messageToDisplay = "The element is not clickable";
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElementLocator));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(1 == 2, messageToDisplay);
        }
    }

//    public void waitForTheElementToReload(WebElement webElement) {
//
//        try {
//            wait.until(ExpectedConditions.stalenessOf(webElement));
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            Assert.assertTrue(1 == 2, "Something went wrong");
//        }
//    }


    public void waitForTheElementToReload (By webElementLocator) {

        try {
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(webElementLocator)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(1 == 2, "Something went wrong");
        }
    }

}