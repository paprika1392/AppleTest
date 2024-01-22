package applePages;

import Utils.Browser;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HomePage extends BasePage {

    public final By searchButton = By.xpath("//li[@data-topnav-flyout-label='Search apple.com']");
    public final By searchField = By.xpath("//input[@class='globalnav-searchfield-input']");
    public final By searchProductButton = By.xpath("//button[@class='globalnav-searchfield-submit']");


    public void clickSearchButton() {
        Browser.getWebdriverWait();
        driver.findElement(searchButton).click();
    }

    public void writeNameOfProduct(String productName) {
        Browser.getWebdriverWait();
        driver.findElement(searchField).sendKeys(productName);

    }

    public void clickSearchProduct() {
        driver.findElement(searchProductButton).click();
    }


}
