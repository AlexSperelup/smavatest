package automation.smava.pages.login;

import automation.smava.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignOnPage extends BasePage {

    private static final By SIGN_ON_FORM = By.id("loginform");

    public SignOnPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getUniqueElementLocator() {
        return SIGN_ON_FORM;
    }

}
