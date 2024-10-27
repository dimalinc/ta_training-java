package com.epam.training.student_dmitriy_plaksin.Final_task.driver.webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractElement {

    public WebElement waitForElementToBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
