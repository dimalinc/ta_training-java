package com.epam.training.student_dmitriy_plaksin.Final_task.test;

import com.epam.training.student_dmitriy_plaksin.practice1_Framework.driver.DriverSingleton;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import com.epam.training.student_dmitriy_plaksin.practice1_Framework.util.TestListener;


//@ExtendWith(TestListener.class)
@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }

}
