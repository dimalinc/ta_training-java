package test;

import driver.DriverSingleton;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.openqa.selenium.WebDriver;

//@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;


    @BeforeMethod()
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
        driver=null;
    }
}
