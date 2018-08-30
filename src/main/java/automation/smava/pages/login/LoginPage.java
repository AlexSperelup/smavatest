package automation.smava.pages.login;

import automation.smava.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final By LOGIN_BUTTON = By.className("Button__button LoginForm__button");
    private static final By EMAIL_INPUT = By.cssSelector("[name=\"email\"]");
    private static final By PASSWORD_INPUT = By.cssSelector("[name=\"password\"]");
    private static final By SUBMIT_LOGIN_FORM_BUTTON = By.cssSelector("[type=\"submit\"]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getUniqueElementLocator() {
        return LOGIN_BUTTON;
    }

    public void login(String email, String password){
        enter(EMAIL_INPUT, email);

        enter(PASSWORD_INPUT, password);

        clickOn(element(SUBMIT_LOGIN_FORM_BUTTON));
    }
}
