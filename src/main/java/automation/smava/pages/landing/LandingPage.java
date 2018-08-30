package automation.smava.pages.landing;

import automation.smava.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static automation.smava.pages.landing.LandingPage.CreditFormInput.*;

public class LandingPage extends BasePage {

    private static final By LOGIN_BUTTON = By.className("login-button");
    private static final By CREDIT_FORM_INPUT = By.className("Select-value");
    private static final By SELECT_VALUE_LABEL = By.className("Select-value-label");
    private static final By INTEREST = By.className("interest-rate");
    private static final By MONTHLY_PAYMENT = By.className("monthly-rate");


    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getUniqueElementLocator() {
        return LOGIN_BUTTON;
    }

    public void clickOnLoginButton(){
        clickOn(element(LOGIN_BUTTON));
    }

    public void selectCreditType(CreditType type){

        element(getCreditFormInput(TYPE)).click();

        getSelectValueLabel(type.getType()).click();
    }

    public void selectAmount(Integer amount){

        element(getCreditFormInput(AMOUNT)).click();

        getSelectValueLabel(amount.toString() + " €").click();
    }

    public void selectPeriod(Integer monthNumber){
        element(getCreditFormInput(PERIOD)).click();

        getSelectValueLabel(monthNumber.toString() + " Monate").click();

    }

    public String getInterestValue(){
        return element(INTEREST).getText().
                replaceAll("Effekt. Jahreszins ab ", "").
                replaceAll(" %", "").trim();
    }

    public String getMonthlyPaymentValue(){
        return element(MONTHLY_PAYMENT).getText().
                replaceAll("Monatsrate", "").
                replaceAll(" €", "").trim();
    }

    public enum CreditType{
        REMORTGAGE("Umschuldung"),
        AUTO_MOTO("Auto / Motorrad"),
        LIVING("Wohnen"),
        BUSINESS("Gewerbe"),
        FREE_USE("Freie Verwendung");

        private String type;

        CreditType(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }
    }

    public enum CreditFormInput {
        TYPE,
        AMOUNT,
        PERIOD
    }

    private WebElement getCreditFormInput(CreditFormInput creditFormInput){
        return findAll(CREDIT_FORM_INPUT).
                stream().
                filter(WebElement::isDisplayed).
                collect(Collectors.toList()).
                get(creditFormInput.ordinal());
    }

    private WebElement getSelectValueLabel(String value){
        return findAll(SELECT_VALUE_LABEL).
                stream().
                filter(WebElement::isDisplayed).
                filter(e -> e.getText().contains(value)).
                findFirst().
                orElseThrow(() -> new NoSuchElementException("No label with name " + value));
    }
}
