package com.epam.training.student_dmitriy_plaksin.Final_task.driver.driverFactory;

import org.openqa.selenium.WebDriver;
import com.epam.training.student_dmitriy_plaksin.Final_task.driver.driverFactory.EdgeCreator;
import com.epam.training.student_dmitriy_plaksin.Final_task.driver.driverFactory.FirefoxCreator;
import java.time.Duration;

public final class DriverFactory {

    private DriverFactory() {}

    public static WebDriver createDriver() {
        var browserType = System.getProperty("browser", "firefox");
        WebDriver driver;
        if (browserType.equalsIgnoreCase("edge")) {
            driver = EdgeCreator.getEdgeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            driver = FirefoxCreator.getFirefoxDriver();
        } else {
            throw new RuntimeException("Invalid name of the browser");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();
        return driver;
    }
}
