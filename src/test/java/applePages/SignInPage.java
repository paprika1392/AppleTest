package applePages;

import Utils.Browser;
import Utils.MyException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SignInPage extends BasePage {

    private final By accountNameField = By.xpath("//input[@id='account_name_text_field']");
    private final By iFrame = By.xpath("//iframe[@name='aid-auth-widget']");
    private final By continueButton = By.xpath("//button[@id='sign-in']");
    private final By passwordNameField = By.xpath("//input[@type='password']");
    private final By incorrectIdOrPasswordError = By.xpath("//p[@id='errMsg']");
    private final By spinnerContainer = By.xpath("//div[contains(@class, 'show')]");

    public void enterAccountName(String accountName) {
        WebElement element = driver.findElement(iFrame);
        driver.switchTo().frame(element);
        Browser.waitUntilElementIsVisible(accountNameField);;
        driver.findElement(accountNameField).click();
        driver.findElement(accountNameField).sendKeys(accountName);
    }

    public void clickContinueButton() {
        Browser.getWebdriverWait().until(ExpectedConditions.elementToBeClickable(continueButton));
        driver.findElement(continueButton).click();
    }

    public void enterPasswordField(String password) {
        Browser.waitUntilElementIsVisible(passwordNameField);
        driver.findElement(passwordNameField).sendKeys(password);
    }

    public void checkIfErrorWindowAppears() {
        Browser.waitUntilElementIsVisible(spinnerContainer);
        try {
            WebElement element = driver.findElement(incorrectIdOrPasswordError);
            boolean result = element.isDisplayed();

            Assert.assertTrue(result, "Error's window isn't opened ");

        } catch (NoSuchElementException e) {
            throw new MyException("no error message appeared");
        }

    }

    public void checkLoginErrorText(String textOfCurrentError) {
        Browser.waitUntilElementIsVisible(incorrectIdOrPasswordError);
        String actualTextOfError = driver.findElement(incorrectIdOrPasswordError).getText();
        boolean result = actualTextOfError.contains(textOfCurrentError);

        Assert.assertTrue(result, String.format("Text of error is incorrect: '%s'", actualTextOfError));
    }

}
