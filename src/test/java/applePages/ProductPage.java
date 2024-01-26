package applePages;

import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static Utils.Constants.Constants.APPLE_SEARCHING_PRODUCT_NAME;

public class ProductPage extends BasePage {

    private final By currentProducts = By.cssSelector(".rf-serp-productname-link");

    public void waitUntilElemWillBeVisible() {
        Browser.getWebdriverWait().until(ExpectedConditions.visibilityOfElementLocated(currentProducts));

    }

    public void findAvailableProducts() {
        List<WebElement> elements = driver.findElements(currentProducts);

        for (WebElement element : elements) {
            String actualText = element.getText();
            boolean actualResult = actualText.contains(APPLE_SEARCHING_PRODUCT_NAME);

            Assert.assertTrue(actualResult, "There is NOT the same with searching product - " + APPLE_SEARCHING_PRODUCT_NAME);


//            if (actualText.contains(APPLE_SEARCHING_PRODUCT_NAME)) {
//                System.out.println("Result contain content : " + actualText);
//            } else {
//                System.out.println("Results not contain content");
//            }
        }

    }

}