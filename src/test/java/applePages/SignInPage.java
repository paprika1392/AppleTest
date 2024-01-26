package applePages;

import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends BasePage {

    private final By accountNameField = By.xpath("//div[@class='account-name     ']");

    public void enterAccName() {
        Browser.getWebdriverWait().until(ExpectedConditions.visibilityOfElementLocated(accountNameField));
        driver.findElement(accountNameField).sendKeys("blablabla");
    }
}
