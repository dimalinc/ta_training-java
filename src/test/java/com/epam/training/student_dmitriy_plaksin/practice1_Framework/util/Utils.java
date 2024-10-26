package com.epam.training.student_dmitriy_plaksin.practice1_Framework.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Utils {



    private static FluentWait fluentWaitInit(WebDriver driver,int timeout,int pollingInterval) {
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofMillis(timeout));
        wait.pollingEvery(Duration.ofMillis(pollingInterval));
        wait.ignoring(NoSuchElementException.class);
        return wait;
    }

    public static void waitForElementTextToBePresent(WebDriver driver, int timeout, int pollingInterval, WebElement element, String text)
    {
        FluentWait fluentWait =  fluentWaitInit(driver,timeout,pollingInterval);
        fluentWait.until(ExpectedConditions.textToBePresentInElement(element, text) );
    }

    public static WebElement waitForElementPresence(WebDriver driver, int timeout, int pollingInterval, WebElement  element)
    {
        FluentWait fluentWait =  fluentWaitInit(driver,timeout,pollingInterval);
        fluentWait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static void waitForElementByXpathPresence(WebDriver driver, int timeout, int pollingInterval, By by)
    {
        FluentWait fluentWait =  fluentWaitInit(driver,timeout,pollingInterval);
        fluentWait.until(ExpectedConditions.presenceOfElementLocated(by) );
    }

    public static void waitUntilTitleContains(WebDriver driver,int timeout,int pollingInterval, String expectedTitle)
    {
        FluentWait fluentWait =  fluentWaitInit(driver,timeout,pollingInterval);
        fluentWait.until(ExpectedConditions.titleContains(expectedTitle) );

       // System.out.println("Page title = "+driver.getTitle());
    }

    public static By getByFromElement(WebElement element) {
        By by = null;
        String[] pathVariables = (element.toString().split("->")[1].replaceFirst("(?s)(.*)\\]", "$1" + "")).split(":");

        String selector = pathVariables[0].trim();
        String value = pathVariables[1].trim();

        switch (selector) {
            case "id":
                by = By.id(value);
                break;
            case "className":
                by = By.className(value);
                break;
            case "tagName":
                by = By.tagName(value);
                break;
            case "xpath":
                by = By.xpath(value);
                break;
            case "cssSelector":
                by = By.cssSelector(value);
                break;
            case "linkText":
                by = By.linkText(value);
                break;
            case "name":
                by = By.name(value);
                break;
            case "partialLinkText":
                by = By.partialLinkText(value);
                break;
            default:
                throw new IllegalStateException("locator : " + selector + " not found!!!");
        }

        System.out.println(by);
        return by;
    }

}
