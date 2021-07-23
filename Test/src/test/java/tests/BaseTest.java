package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static Driver driver = null;

    @BeforeClass
    public void setUp() {
        driver = Driver.getInstance();
        driver.webDriver.manage().window().maximize();
        // wait for the page to load before throwing an error
        driver.webDriver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        // wait after any JS Script that might run on the page to finnish
        driver.webDriver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {

        Thread.sleep(5000); //so the browser does not close immediately (didactic purpose)
        driver.webDriver.quit();
    }
}
