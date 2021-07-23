package pageObject;

import utils.Driver;

public abstract class BasePage {

    public static Driver driver = Driver.getInstance();

    public BasePage() {}

    public abstract void waitForThePageToLoad();



}
