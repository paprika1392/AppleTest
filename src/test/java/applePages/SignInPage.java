package applePages;

import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static Utils.Constants.Constants.*;

public class SignInPage extends BasePage {

    private final By accountNameField = By.xpath("//input[@id='account_name_text_field']");
    private final By iFrame = By.xpath("//iframe[@name='aid-auth-widget']");
    private final By continueButton = By.xpath("//button[@id='sign-in']");
    private final By passwordNameField = By.xpath("//input[@type='password']");
    private final By incorrectIdOrPasswordError = By.xpath("//p[@id='errMsg']");
    private final By spinnerContainer = By.xpath("//div[contains(@class, 'show ')]");

    public void enterAccName() {
        WebElement element = driver.findElement(iFrame);
      driver.switchTo().frame(element);
        Browser.getWebdriverWait().until(ExpectedConditions.visibilityOfElementLocated(accountNameField));
        driver.findElement(accountNameField).click();
        driver.findElement(accountNameField).sendKeys(INCORRECT_NAME);
    }

    public void clickContinueButton() {
        Browser.getWebdriverWait().until(ExpectedConditions.elementToBeClickable(continueButton));
        driver.findElement(continueButton).click();
    }

    public void enterPassWordField() {
        Browser.getWebdriverWait().until(ExpectedConditions.visibilityOfElementLocated(passwordNameField));
        driver.findElement(passwordNameField).sendKeys(INCORRECT_ID);
    }

    public void checkingError() {
        Browser.getWebdriverWait().until(ExpectedConditions.invisibilityOfElementLocated(spinnerContainer));
        WebElement element = driver.findElement(incorrectIdOrPasswordError);
        Boolean result = element.isDisplayed();

        Assert.assertTrue(result,  "Error's window isn't opened ");

    }
    public void checkingIdAndPasswordError() {
        Browser.getWebdriverWait().until(ExpectedConditions.visibilityOfElementLocated(incorrectIdOrPasswordError));
        String actualTextOfError = driver.findElement(incorrectIdOrPasswordError).getText();
        Boolean result = actualTextOfError.contains(INCORRECT_ID_OR_NAME_ERROR);

        Assert.assertTrue(result, String.format("Text of error is incorrect: '%s'", actualTextOfError));
    }

}
