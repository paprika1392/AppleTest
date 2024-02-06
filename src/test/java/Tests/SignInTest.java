package Tests;

import Steps.Steps;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest{

@Test
    public void test() {
    Steps.goToBagAndSignIn();
    Steps.enterPersonalData();
    Steps.checkingErrors();
}


}
