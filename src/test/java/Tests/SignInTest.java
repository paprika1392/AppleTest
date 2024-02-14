package Tests;

import Steps.Steps;
import org.testng.annotations.Test;

import static Utils.Constants.Constants.*;

public class SignInTest extends BaseTest{

@Test
    public void testForIncorrectLogin() {
    Steps.goToBagAndSignIn();
    Steps.enterPersonalData(INCORRECT_NAME, INCORRECT_PASSWORD);
    Steps.checkingErrors(INCORRECT_ID_OR_NAME_ERROR);
}


}
