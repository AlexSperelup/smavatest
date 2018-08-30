package automation.smava.steps;

import automation.smava.models.Credit;
import automation.smava.pages.landing.LandingPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LandingPageSteps {

    private LandingPage landingPage;

    @Step
    public void enterCreditFormValues(Credit credit){
        landingPage.selectCreditType(credit.getCreditType());
        landingPage.selectAmount(credit.getOnAmount());
        landingPage.selectPeriod(credit.getForMonths());
    }

    @Step
    public void verifyThatInterestCorrespondsToExpected(String expectedInterest){
        assertThat(expectedInterest, is(equalTo(landingPage.getInterestValue())));
    }

    @Step
    public void verifyThatMonthlyPaymentValueCorrespondsToExpected(String monthlyPayment){
        assertThat(monthlyPayment, is(equalTo(landingPage.getMonthlyPaymentValue())));
    }

}
