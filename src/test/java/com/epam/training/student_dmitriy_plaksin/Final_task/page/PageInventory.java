package com.epam.training.student_dmitriy_plaksin.Final_task.page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageInventory extends AbstractPage {
    @FindBy(xpath = "//div[@class='app_logo']") private WebElement text_title;
    @FindBy(xpath = "//button[text()='Open Menu']") private WebElement button_open_menu;

    public PageInventory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);    }

    public boolean wasOpened() {
        if ( button_open_menu.isDisplayed() )
        return true;
        else return false;
    }
}
