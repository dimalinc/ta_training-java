package com.epam.training.student_dmitriy_plaksin.Final_task.util;
import com.epam.training.student_dmitriy_plaksin.practice1_Framework.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private static final Logger log = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess()");
    }


    @Override
    public void onTestFailure(ITestResult result){
        try {
            takeScreenshot();
            System.out.println("Screenshot done");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void takeScreenshot() throws IOException {
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                            + getCurrentTimeAsString() +
                            ".png"));
        } catch (IOException e) {
            log.error("Couldn't make a screenshot(((:{}", e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "uuuu-MM-dd_HH-mm-ss" );
        return ZonedDateTime.now().format(formatter);
    }
}
