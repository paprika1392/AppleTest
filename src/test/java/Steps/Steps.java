package Steps;

import Utils.Browser;
import applePages.HomePage;
import applePages.ProductPage;
import applePages.SignInPage;

import static Utils.Constants.Constants.APPLE_HOME_PAGE_URL;

public class Steps {

    public static HomePage homePage = new HomePage();
    public static ProductPage productPage = new ProductPage();
    public static SignInPage signInPage = new SignInPage();

    //       """ Steps for BaseTest """

    public static void openBrowser() {
        Browser.webDriverStartWork();
        Browser.setUrl(APPLE_HOME_PAGE_URL);
        Browser.customizeBrowserWindow();
    }

    public static void clearCookies() {
        Browser.clearCookiesAndLocalStorage();
    }

    public static void closeBrowser() {
        Browser.closeBrowser();
    }

    //       """ Steps for AppleTest """

    public static void enterProductName(String productName) {
        homePage.clickSearchButton();
        homePage.writeNameOfProduct(productName);
        homePage.clickSearchProduct();

    }

    public static void findAndEqualsProducts(String productName) {
        productPage.waitUntilElemWillBeVisible();
        productPage.findAvailableProducts(productName);
    }


    //     """ Steps for SignInTest """

    public static void goToBagAndSignIn() {
        homePage.clickBagButton();
        homePage.clickSignInButton();
    }

    public static void enterPersonalData(String incorrectAccName, String incorrectPassword) {
        signInPage.enterAccName(incorrectAccName);
        signInPage.clickContinueButton();
        signInPage.enterPassWordField(incorrectPassword);
        signInPage.clickContinueButton();
    }

    public static void checkingErrors(String textOfCurrentError) {
        signInPage.checkingError();
        signInPage.checkingIdAndPasswordError(textOfCurrentError);
    }

}
