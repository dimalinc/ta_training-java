package com.epam.training.student_dmitriy_plaksin.Final_task.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageInventory extends AbstractPage {
    @FindBy(xpath = "//div[@class='app_logo']") private WebElement text_title;

    public PageInventory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);    }
}
