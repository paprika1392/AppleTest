package applePages;

import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static Utils.Constants.Constants.APPLE_SEARCHING_PRODUCT_NAME;

public class ProductPage extends BasePage{

    public final By currentProducts = By.cssSelector(".rf-serp-productname-link");

    public void findAvailableProducts() {

        List<WebElement> elements = driver.findElements(currentProducts);

        for (WebElement element : elements) {
            String actualText = element.getText();
            boolean actualResult = actualText.contains(APPLE_SEARCHING_PRODUCT_NAME);

            Assert.assertTrue(actualResult, "There is the same with searching product - " + APPLE_SEARCHING_PRODUCT_NAME);


//            if (actualText.contains(APPLE_SEARCHING_PRODUCT_NAME)) {
//                System.out.println("Result contain content : " + actualText);
//            } else {
//                System.out.println("Results not contain content");
//            }
        }

    }

}