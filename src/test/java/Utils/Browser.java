package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    private static WebDriver driver; //singlton

    private Browser() {   //singlton
    }

    public static WebDriver getDriver() { //singlton
        if (driver == null) {
            WebDriverManager.chromedriver().setup(); //automatic driver download
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void webDriverStartWork() {
        getDriver();
    }

    public static void customizeBrowserWindow() {
        driver.manage().window().maximize();

    }

    public static void setUrl(String url) {
        driver.get(url);
    }


}
