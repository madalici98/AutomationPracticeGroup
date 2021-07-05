package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static Driver driver = null;
    public RemoteWebDriver webDriver;
    private WebDriverWait wait;

    private Driver() {

        setNewDriver();
        wait = new WebDriverWait(webDriver, 10);
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
            webDriver= null;
        }
        System.setProperty("webdriver.chrome.driver","/Users/madalina.pietreanu/IdeaProjects/AutomationPracticeGroup/Test/src/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
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

    public void navigate(){
        webDriver.get("https://www.google.ro/");
    }

    public void navigate(String url) {
        webDriver.get(url);
    }

    public void waitForElement(By webElementLocator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(webElementLocator));
    }

}