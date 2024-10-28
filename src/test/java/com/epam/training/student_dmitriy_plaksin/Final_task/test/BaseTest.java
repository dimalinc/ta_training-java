package com.epam.training.student_dmitriy_plaksin.Final_task.test;

import com.epam.training.student_dmitriy_plaksin.Final_task.driver.DriverSingleton;
import com.epam.training.student_dmitriy_plaksin.Final_task.util.TestListener_junit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import com.epam.training.student_dmitriy_plaksin.Final_task.util.TestListener;


@ExtendWith(TestListener_junit.class)
//@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

   // @BeforeMethod
    @BeforeEach
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

  //  @AfterMethod(alwaysRun = true)
    @AfterEach
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }

}
