package automation.smava.tests;

import net.thucydides.core.annotations.Managed;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    public static String GECKO_DRIVER_PATH = "D:\\Projects\\geckodriver.exe";
    public static String BASE_URL = "https://www.smava.de/";

    @Managed
    protected WebDriver driver;

    @Before
    public void initialize(){

        System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);

        driver.get(BASE_URL);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("return window.stop");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}