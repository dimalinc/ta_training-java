package com.epam.training.student_dmitriy_plaksin.Final_task.test;

import com.epam.training.student_dmitriy_plaksin.Final_task.driver.driverFactory.DriverThreadLocal;
import com.epam.training.student_dmitriy_plaksin.Final_task.util.TestListener_junit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;


@ExtendWith(TestListener_junit.class)
public class BaseTest {

    protected WebDriver driver;

   @BeforeEach
    public void setUp() {
        driver = DriverThreadLocal.getDriver();
    }


 @AfterEach
 public void stopBrowser() {DriverThreadLocal.tearDown();}

}
