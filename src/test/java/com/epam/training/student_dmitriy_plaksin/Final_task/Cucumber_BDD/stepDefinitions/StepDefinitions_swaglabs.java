package com.epam.training.student_dmitriy_plaksin.Final_task.Cucumber_BDD.stepDefinitions;


import com.epam.training.student_dmitriy_plaksin.Final_task.page.*;
import com.epam.training.student_dmitriy_plaksin.Final_task.driver.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.*;


public class StepDefinitions_swaglabs {

    WebDriver driver;
    PageLogin page_login;
    PageInventory page_inventory;

    @Before
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @Given("User opens SwagLabs login page")
    public void openLoginPage() {
        page_login = new PageLogin(driver);
        page_login.navigate_to();
    }

    @When("User enter the username {string} and the password {string}")
    public void userEnterUsernameAndPassword(String username, String password) {
        page_inventory = page_login.perform_login(username,password);
    }

    @Then("User should see the expected message {string}")
    public void userShouldSeeExpectedMessage(String expectedMessage) {
        if (expectedMessage.equals("Username is required") || expectedMessage.equals("Password is required")) {
            String actualErrorMessage = page_login.getText_errorMessage();
            assertTrue(actualErrorMessage.contains(expectedMessage));
        } else {
            String actualTitle = page_inventory.get_page_title();
            assertEquals(expectedMessage, actualTitle);
        }
    }

    @After
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }


}