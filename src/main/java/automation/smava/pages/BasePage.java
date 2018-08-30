package automation.smava.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

import static java.util.Arrays.*;
import static org.junit.Assert.fail;

public abstract class BasePage extends PageObject {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    protected abstract By getUniqueElementLocator();

    protected final Logger logger = LogManager.getLogger(this.getClass().getName());

    public void isLoaded() throws Error {

        String errorMessage = "Unique element is not displayed for " + this.getClass().getSimpleName();

        try {
            if (!getDriver().findElements(getUniqueElementLocator()).stream().
                    anyMatch(WebElement::isDisplayed)) {
                fail(errorMessage);
            }
        }
        catch (NoSuchElementException | StaleElementReferenceException e) {
            fail(errorMessage);
        }
    }

    protected void enter(By locator, CharSequence... entry) {

        WebElement element = element(locator);
        element.clear();
        element.sendKeys(entry);

        logger.info(stream(entry).
                map(CharSequence::toString).
                collect(Collectors.joining()) + " entered");
    }
}
