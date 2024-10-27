package com.epam.training.student_dmitriy_plaksin.Final_task.page;

import com.epam.training.student_dmitriy_plaksin.practice1_Framework.page.cloud.google.com.CalculatorPage;
import com.epam.training.student_dmitriy_plaksin.practice1_Framework.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin extends AbstractPage{

    private final String URL_OF_PAGE = "https://www.saucedemo.com/";

    @FindBy(xpath = "//input[@data-test='username']") private WebElement input_username;
    @FindBy(xpath = "//input[@data-test='password']") private WebElement input_password;
    @FindBy(xpath = "//input[@data-test='login-button']") private WebElement button_login;
    @FindBy(xpath = "//h3[@data-test='error']") private WebElement text_errorMessage;

    private static final Logger log = LogManager.getLogger(CalculatorPage.class);


    public PageLogin(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PageLogin navigate_to() {
        driver.get(URL_OF_PAGE);
        log.info("login page opened");
        return this;
    }

    public PageLogin perform_login(String usernameString, String passwordString) {
        input_username.sendKeys(usernameString);
         input_password.sendKeys(passwordString);
        click_buttonLogin();
        log.info("Logging in with credentials: "+ usernameString + " and password: " + passwordString);
        return this;
    }

    public PageLogin click_buttonLogin() {
        button_login.click();
        return this;
    }

    public String getErrorMessage() {
        String text_error = Utils.waitForElementPresence(driver,5000,250,text_errorMessage).getText();
        log.info("Got errorMessageText = "+text_errorMessage.getText());
        return text_errorMessage.getText();
    }












}