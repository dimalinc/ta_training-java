package com.epam.training.student_dmitriy_plaksin.Final_task.driver.driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class EdgeCreator {

    private EdgeCreator() {}

    public static WebDriver getEdgeDriver() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        return new EdgeDriver(options);
    }
}