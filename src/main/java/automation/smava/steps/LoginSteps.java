package automation.smava.steps;

import automation.smava.models.User;
import automation.smava.pages.landing.LandingPage;
import automation.smava.pages.login.LoginPage;
import automation.smava.pages.login.SignOnPage;
import net.thucydides.core.annotations.Step;

public class LoginSteps {
    private LoginPage loginPage;
    private SignOnPage signOnPage;
    private LandingPage landingPage;

    @Step
    public void loginAsUser(User user){
        landingPage.clickOnLoginButton();

        loginPage.login(user.getUsername(), user.getPassword());
    }

    @Step
    public void verifyThatSignOnPageIsOpened(){
        signOnPage.isLoaded();
    }

}
