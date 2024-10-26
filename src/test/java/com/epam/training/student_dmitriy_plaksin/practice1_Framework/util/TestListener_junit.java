package com.epam.training.student_dmitriy_plaksin.practice1_Framework.util;

import com.epam.training.student_dmitriy_plaksin.practice1_Framework.driver.DriverSingleton;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class TestListener_junit implements TestWatcher/*, BeforeTestExecutionCallback, TestExecutionExceptionHandler  */{

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("testSuccessful()");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("testFailed()");
        screenshot_make();
    }

    private void screenshot_make(){
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



   /* @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {
        screenshot_make();
        log.error("TestExecutionException in testCase: {}", extensionContext.getDisplayName());
        throw throwable;
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        log.info("Starting testCase {}", context.getDisplayName());
    }*/


   /* @Override
    public boolean isEnabled() {
        return ITestListener.super.isEnabled();
    }*/
}
