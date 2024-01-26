package applePages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By searchButton = By.xpath("//li[@data-topnav-flyout-label='Search apple.com']");
    private final By searchField = By.xpath("//input[@class='globalnav-searchfield-input']");
    private final By searchProductButton = By.xpath("//button[@class='globalnav-searchfield-submit']");
    private final By bagButton = By.cssSelector(".globalnav-bag-wrapper");
    private final By signInButton = By.xpath("//span[text()= 'Sign in']");


     public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void writeNameOfProduct(String productName) {
        driver.findElement(searchField).sendKeys(productName);
    }

    public void clickSearchProduct() {
        driver.findElement(searchProductButton).click();
    }

    public void clickBagButton() {
         driver.findElement(bagButton).click();
    }

    public void clickSignInButton() {
         driver.findElement(signInButton).click();
    }



}
