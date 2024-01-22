package applePages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HomePage extends BasePage {

    public final By searchButton = By.xpath("//li[@data-topnav-flyout-label='Search apple.com']");
    public final By searchField = By.xpath("//input[@class='globalnav-searchfield-input']");


    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void writeProduct() {
        driver.findElement(searchField).sendKeys("iPhone 15");
    }
}
