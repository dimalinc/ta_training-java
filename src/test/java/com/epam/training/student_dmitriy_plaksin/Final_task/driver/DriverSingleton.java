package com.epam.training.student_dmitriy_plaksin.Final_task.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if (Objects.isNull(driver)){
            /*switch (System.getProperty("browser")){
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                default: {*/
                    /*WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();*/

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
              /*  }
            }*/
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
