package Tests;

import Steps.Steps;
import org.testng.annotations.Test;

import static Utils.Constants.Constants.APPLE_SEARCHING_PRODUCT_NAME;

public class AppleTest extends BaseTest {

    @Test
    public void test() {
        Steps.enterProductName(APPLE_SEARCHING_PRODUCT_NAME);
        Steps.findAndEqualsProducts(APPLE_SEARCHING_PRODUCT_NAME);
    }
}
