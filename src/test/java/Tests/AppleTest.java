package Tests;

import Steps.Steps;
import org.testng.annotations.Test;

public class AppleTest extends BaseTest {

    @Test
    public void test() {
        Steps.enterProductName("iPhone 15");
        Steps.FindAndEqualsProducts("iPhone 15");
    }
}
