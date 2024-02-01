package applePages;

import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static Utils.Constants.Constants.INCORRECT_ID_OR_NAME_ERROR;

public class SignInPage extends BasePage {

    private final By accountNameField = By.xpath("//div[@class='account-name     ']");
    private final By continueButton = By.xpath("//span[@class='text feat-split']");
    private final By passwordNameField = By.xpath("//input[@type='password']");
    private final By incorrectIdOrPasswordError = By.xpath("//p[@id='errMsg']");
    private final By spinnerContainer = By.xpath("//div[contains(@class, 'show ')]");

    public void enterAccName() {
        Browser.getWebdriverWait().until(ExpectedConditions.visibilityOfElementLocated(accountNameField));
        driver.findElement(accountNameField).sendKeys("blablabla");
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void enterPassWordField() {
        Browser.getWebdriverWait().until(ExpectedConditions.visibilityOfElementLocated(passwordNameField));
        driver.findElement(passwordNameField).sendKeys("12345");
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

        Assert.assertTrue(result, "There is not the same result with  " + INCORRECT_ID_OR_NAME_ERROR);
    }

}
