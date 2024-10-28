package com.epam.training.student_dmitriy_plaksin.Final_task.test;

import com.epam.training.student_dmitriy_plaksin.Final_task.driver.DriverSingleton;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import com.epam.training.student_dmitriy_plaksin.Final_task.util.TestListener;


//@ExtendWith(TestListener.class)
@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }

}
