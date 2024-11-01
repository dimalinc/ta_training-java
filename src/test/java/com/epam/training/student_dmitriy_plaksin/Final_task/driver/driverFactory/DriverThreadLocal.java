package com.epam.training.student_dmitriy_plaksin.Final_task.driver.driverFactory;

import org.openqa.selenium.WebDriver;
import java.util.Objects;

public final class DriverThreadLocal {
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    private DriverThreadLocal() {}

    public static WebDriver getDriver() {
        if (Objects.isNull(threadLocalDriver.get())) {
            threadLocalDriver.set(DriverFactory.createDriver());
        }
        return threadLocalDriver.get();
    }

    public static void tearDown() {
        if (Objects.nonNull(threadLocalDriver.get())) {
            threadLocalDriver.get().quit();
            threadLocalDriver.remove();
        }
    }
}
