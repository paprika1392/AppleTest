package Steps;

import Utils.Browser;
import applePages.HomePage;
import org.testng.annotations.Test;

import static Utils.Constants.Constants.APPLE_HOME_PAGE_URL;

public class Steps {

    public static HomePage homePage = new HomePage();

    public static void openBrowser() {
        Browser.webDriverStartWork();
        Browser.setUrl(APPLE_HOME_PAGE_URL);
        Browser.customizeBrowserWindow();
    }

    public static void clearCookies() {
        Browser.clearCookiesAndLocalStorage();
    }

    public static void enterTheDeviseName(String productName) {
        homePage.clickSearchButton();
        homePage.writeNameOfProduct(productName);
        homePage.clickSearchProduct();

    }

    public static void closeBrowser() {
        Browser.closeBrowser();
    }
}
