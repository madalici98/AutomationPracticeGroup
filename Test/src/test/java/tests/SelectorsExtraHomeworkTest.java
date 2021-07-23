package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import utils.Driver;

import java.util.List;

import static org.testng.Assert.*;

public class SelectorsExtraHomeworkTest {

    public static Driver driver = null;

    @BeforeClass
    public static void init() {
        driver = Driver.getInstance();
        driver.webDriver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.webDriver.quit();
    }

    // i need to configure testng xml to pass a parameter for the test
    @Test
    public static void selectCheckBoxOptionByParameterTest() {

        String url = "https://www.seleniumeasy.com/test/basic-checkbox-demo.html";
        driver.navigate(url);

    }

    // done
    @Test
    public static void selectAllOptionsCheckBoxTest() {

        String url = "https://www.seleniumeasy.com/test/basic-checkbox-demo.html";
        driver.navigate(url);

        //By checkBoxOptionsSelector = By.xpath("//div[contains(text(), 'Multiple')]/following::div[@class='checkbox']");
        By checkAllButtonSelector = By.id("check1");
        By selectionCheckerButtonSelector = By.id("isChkd");

        driver.waitForElementToLoad(checkAllButtonSelector);
        driver.webDriver.findElement(checkAllButtonSelector).click();

        WebElement selectionCheckerButton = driver.webDriver.findElement(selectionCheckerButtonSelector);
        String isSelected = selectionCheckerButton.getAttribute("value");
        assertTrue(isSelected.equals("true"));

    }

    // a little confusing
    @Test
    public static void jQueryDatePickerTest() {

        By fromDatePickerSelector = By.id("from");
        By toDatePickerSelector = By.id("to");

        WebElement fromDatePicker = driver.webDriver.findElement(fromDatePickerSelector);

        fromDatePicker.sendKeys();
    }

    // done
    @Test
    public static void tableDataRowsSelectorTest() {

        By tableDataRowsSelector = By.xpath("//tbody/tr[not(@class)]");

        String url = "https://www.seleniumeasy.com/test/table-search-filter-demo.html";
        driver.navigate(url);

        driver.waitForElementToLoad(tableDataRowsSelector);
        List<WebElement> tableDataRows = driver.webDriver.findElements(tableDataRowsSelector);

        assertEquals(tableDataRows.size(), 12);
    }

    // done
    @Test
    public static void tableFiltersStatusTest() {

        By filterButtonSelector = By.xpath("//button[contains(@class, 'btn-filter')]");
        By tableFiltersSelector = By.xpath("//table[@class = 'table']//input");

        String url = "https://www.seleniumeasy.com/test/table-search-filter-demo.html";
        driver.navigate(url);

        driver.waitForElementToLoad(filterButtonSelector);
        WebElement filterButton = driver.webDriver.findElement(filterButtonSelector);

        List<WebElement> tableFilters = driver.webDriver.findElements(tableFiltersSelector);

        for (WebElement filter : tableFilters) {
            assertFalse(filter.isEnabled());
        }

        filterButton.click();

        for (WebElement filter : tableFilters) {
            assertTrue(filter.isEnabled());
        }

    }

    // done, but I don't understand the "what about present?" question in the exercise
    @Test
    public static void singleModalTest() {

        By singleModalButtonLocator = By.xpath("//div[contains(text(), 'Single Modal Example')]/following::a[@href='#myModal0']");
        By singleModalXClosingButtonLocator = By.xpath("//div[@id = 'myModal0']//button[@data-dismiss='modal']");

        String url = "https://www.seleniumeasy.com/test/bootstrap-modal-demo.html";
        driver.navigate(url);

        driver.waitForElementToLoad(singleModalButtonLocator);

        WebElement singleModalButton = driver.webDriver.findElement(singleModalButtonLocator);
        singleModalButton.click();

        driver.waitForElementToLoad(singleModalXClosingButtonLocator);
        WebElement singleModalXClosingButton = driver.webDriver.findElement(singleModalXClosingButtonLocator);
        singleModalXClosingButton.click();

        assertTrue(singleModalXClosingButton.isDisplayed());
    }

    // done
    @Test
    public static  void jQueryListBoxTest() {

        By dataSelectOptionsLocator = By.xpath("//select[contains(@class,'pickData')]/option[position() <= 2]");
        By addButtonSelector = By.xpath("//button[text() = 'Add']");
        By removeButtonSelector = By.xpath("//button[text() = 'Remove']");
        By selectedOptionsLocator = By.xpath("//select[contains(@class, 'pickListResult')]/option");

        String url = "https://www.seleniumeasy.com/test/jquery-dual-list-box-demo.html";
        driver.navigate(url);

        driver.waitForElementToLoad(dataSelectOptionsLocator);
        List<WebElement> dataSelectOptions = driver.webDriver.findElements(dataSelectOptionsLocator);
        int dataSelectOptionsNumber = dataSelectOptions.size();

        WebElement addButton = driver.webDriver.findElement(addButtonSelector);

        for (WebElement item : dataSelectOptions) {
            item.click();
            addButton.click();
        }

        List<WebElement> selectedOptions = driver.webDriver.findElements(selectedOptionsLocator);
        int selectedOptionsNumber = selectedOptions.size();

        assertEquals(dataSelectOptionsNumber, selectedOptionsNumber);

        selectedOptions.get(0).click();

        WebElement removeButton = driver.webDriver.findElement(removeButtonSelector);

        removeButton.click();

        selectedOptions = driver.webDriver.findElements(selectedOptionsLocator);
        selectedOptionsNumber = selectedOptions.size();

        assertEquals(dataSelectOptionsNumber - 1, selectedOptionsNumber);
    }


}
