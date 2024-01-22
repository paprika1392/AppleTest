package applePages;

import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage{

    public final By currentProducts = By.cssSelector(".rf-serp-productname-link");

    public WebElement findAvailableProducts() {
        Browser.getWebdriverWait();
        WebElement availableProducts = (WebElement) driver.findElements(currentProducts);
        return availableProducts;
    }

    public void equalsCurrentProducts(String product) {
        findAvailableProducts().equals(product);

    }
}