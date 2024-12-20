package com.epam.training.student_dmitriy_plaksin.Final_task.test;
import com.epam.training.student_dmitriy_plaksin.Final_task.dataModel.DataTransferObjectMaker;
import com.epam.training.student_dmitriy_plaksin.Final_task.dataModel.DataTransferObject_model;
import com.epam.training.student_dmitriy_plaksin.Final_task.page.PageInventory;
import com.epam.training.student_dmitriy_plaksin.Final_task.page.PageLogin;
import org.openqa.selenium.TimeoutException;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class PageLoginSaucedemoTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("testInfoProvider")
    @Execution(ExecutionMode.CONCURRENT)
    void validatePageLoginErrorMessage(DataTransferObject_model dto) {
        log.info("Trying to LogIn using login: {}, pass: {}",
                "'" + dto.getLogin_username() + "'", "'" + dto.getLogin_password() + "'");

        PageLogin pageLogin = new PageLogin(driver);
        PageInventory pageInventory = pageLogin.navigate_to()
                .enterLoginCredentials(dto.getLogin_username(),dto.getLogin_password())
                .clearInputsIntendedToBeEmpty(dto.getLogin_username(),dto.getLogin_password())
                .click_buttonLogin();

        String errorMessage = "";
        try {
            errorMessage = pageLogin.getText_errorMessage();
            assertThat(errorMessage,containsString(dto.getMessage_text()) );
        }catch (TimeoutException e) {/*e.printStackTrace();*/}
                
       if (!errorMessage.contains(dto.getMessage_text()) ) {
           assertTrue(pageInventory.wasOpened());
           String titlePageInventory = pageInventory.get_page_title();
           assertThat(titlePageInventory,containsString(dto.getPage_title()) );
       }
        log.info("Login attempt successful for login: {}, pass: {}",
                dto.getLogin_username(), dto.getLogin_password());
    }

    static Object[] testInfoProvider() {
        return new Object[]{
                DataTransferObjectMaker.getTestData(1),
                DataTransferObjectMaker.getTestData(2),
                DataTransferObjectMaker.getTestData(3)
        };
    }


}