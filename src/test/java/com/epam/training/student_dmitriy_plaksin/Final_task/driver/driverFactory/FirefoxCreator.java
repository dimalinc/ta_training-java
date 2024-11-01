package com.epam.training.student_dmitriy_plaksin.Final_task.driver.driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class FirefoxCreator {

    private FirefoxCreator() {}

    public static WebDriver getFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        return new FirefoxDriver(options);
    }
}
