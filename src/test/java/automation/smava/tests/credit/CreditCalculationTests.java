package automation.smava.tests.credit;

import automation.smava.models.Credit;
import automation.smava.steps.LandingPageSteps;
import automation.smava.tests.BaseTest;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import static automation.smava.pages.landing.LandingPage.CreditType.*;

@RunWith(SerenityRunner.class)
public class CreditCalculationTests extends BaseTest {

    @Steps
    LandingPageSteps landingPageSteps;

    @Test
    public void calculateCreditTest(){

        Credit credit = new Credit().
                creditType(LIVING).
                onAmount(2750).
                forMonths(24);

        landingPageSteps.enterCreditFormValues(credit);

        landingPageSteps.verifyThatInterestCorrespondsToExpected("0,69");

        landingPageSteps.verifyThatMonthlyPaymentValueCorrespondsToExpected("115,41");
    }
}
