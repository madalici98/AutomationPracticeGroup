package pageObject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

public class ItemDetailsPage extends BasePage{

    private static ItemDetailsPage itemDetailsPage = null;

    public By addToCartButtonLocator = By.xpath("//button/span[text()='Add to cart']");
    public By itemModelLocator = By.xpath("//p[@id = 'product_reference']/span");
    public By quantitySelectorLocator = By.id("quantity_wanted");
    public By sizeSelectorLocator = By.xpath("//select[@id='group_1']");
    public By selectedSizeLocator = By.xpath("//select[@id='group_1']/option[@selected = 'selected']");
    public By unselectedColorsLocator = By.xpath("//ul[@id='color_to_pick_list']//a[@class != 'color_pick selected']/parent::li");

    private ItemDetailsPage() {}

    public static ItemDetailsPage getInstance() {

        if (itemDetailsPage == null) {
            itemDetailsPage = new ItemDetailsPage();
        }

        return itemDetailsPage;
    }

    public void waitForThePageToLoad() {
        driver.waitForElementToLoad(addToCartButtonLocator, "The page did not load");
    }

    public void addItemToCart() {
        driver.waitForElementToLoad(addToCartButtonLocator);
        driver.webDriver.findElement(addToCartButtonLocator).click();
    }

    public void changeQuantity(int quantity) {

        driver.waitForElementToLoad(quantitySelectorLocator);
        WebElement quantitySelector = driver.webDriver.findElement(quantitySelectorLocator);
        quantitySelector.clear();
        quantitySelector.sendKeys(Integer.toString(quantity));
    }

    public void changeSize(String size) {

        Select sizeSelector = new Select(driver.webDriver.findElement(sizeSelectorLocator));

        try {
            sizeSelector.selectByVisibleText(size);
        } catch (NoSuchElementException e) {
            System.out.println("The required size does not exist. The default size will remain selected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // if there is no argument passed, the first unselected color will be picked
    public void changeColor (String... color) {

        List<WebElement> selectedColor = driver.webDriver.findElements(unselectedColorsLocator);

        if (selectedColor.isEmpty()) {
            return;
        }

        if (color.length == 0) {
            selectedColor.get(0).click();
            return;
        }

        Optional<WebElement> colorOption = selectedColor.stream().map(x -> x.findElement(By.tagName("a")))
                .filter(x -> x.getAttribute("name").equals(color[0])).findFirst();

        colorOption.ifPresent(WebElement::click);

    }

    public String getItemModel() {
        return driver.webDriver.findElement(itemModelLocator).getText();
    }

    public String getItemSize() {
        return driver.webDriver.findElement(selectedSizeLocator).getText();
    }
}
