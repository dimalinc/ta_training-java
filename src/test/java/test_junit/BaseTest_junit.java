package test_junit;

import driver.DriverSingleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import util.TestListener_junit;


@ExtendWith(TestListener_junit.class)
public class BaseTest_junit {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterEach/*(alwaysRun = true)*/
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }




}
