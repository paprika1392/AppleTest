package Steps;

import Utils.Browser;
import applePages.HomePage;
import applePages.ProductPage;

import static Utils.Constants.Constants.APPLE_HOME_PAGE_URL;

public class Steps {

    public static HomePage homePage = new HomePage();
    public static ProductPage productPage = new ProductPage();

    public static void openBrowser() {
        Browser.webDriverStartWork();
        Browser.setUrl(APPLE_HOME_PAGE_URL);
        Browser.customizeBrowserWindow();
    }

    public static void clearCookies() {
        Browser.clearCookiesAndLocalStorage();
    }

    public static void enterProductName(String productName) {
        homePage.clickSearchButton();
        homePage.writeNameOfProduct(productName);
        homePage.clickSearchProduct();

    }

    public static void findAndEqualsProducts(String product) {
        productPage.waitUntilElemWillBeVisible();
        productPage.findAvailableProducts();
    }

    public static void closeBrowser() {
        Browser.closeBrowser();
    }
}
