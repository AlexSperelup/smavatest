package automation.smava.tests.login;

import automation.smava.models.User;
import automation.smava.steps.LoginSteps;
import automation.smava.tests.BaseTest;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class LoginTests extends BaseTest {

    @Steps
    LoginSteps loginSteps;

    @Test
    public void incorrectLoginTest(){

        User nonExistingUser = new User().
                username("user@test.test").
                password("password");

        loginSteps.loginAsUser(nonExistingUser);

        loginSteps.verifyThatSignOnPageIsOpened();
    }

}