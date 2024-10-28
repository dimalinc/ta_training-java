package com.epam.training.student_dmitriy_plaksin.Final_task.test;
import com.epam.training.student_dmitriy_plaksin.Final_task.dataModel.DataTransferObjectMaker;
import com.epam.training.student_dmitriy_plaksin.Final_task.dataModel.DataTransferObject_model;
import com.epam.training.student_dmitriy_plaksin.Final_task.page.PageInventory;
import com.epam.training.student_dmitriy_plaksin.Final_task.page.PageLogin;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@Slf4j
@Execution(ExecutionMode.CONCURRENT)
public class PageLoginSaucedemoTest extends BaseTest {

   // @Test(dataProvider = "provider")
    @ParameterizedTest
    @MethodSource("testInfoProvider")
    void validatePageLoginErrorMessage(DataTransferObject_model dto) {
        SoftAssert softAssert = new SoftAssert();
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin= pageLogin.navigate_to()
                .perform_login(dto.getLogin_username(),dto.getLogin_password());

        String errorMessage = "";
        try {
            errorMessage = pageLogin.getErrorMessage();
            softAssert.assertTrue(errorMessage.contains(dto.getMessage_text()));
        }catch (TimeoutException e) {/*e.printStackTrace();*/}
                
       if (!errorMessage.contains(dto.getMessage_text()) ) {
           PageInventory pageInventory = new PageInventory(driver);
           softAssert.assertTrue(pageInventory.wasOpened());
           String titlePageInventory = pageInventory.get_page_title();
           softAssert.assertTrue(titlePageInventory.contains(dto.getPage_title()));
       }

        softAssert.assertAll();



      //  System.out.println("errorMessage = " + errorMessage);
    }

 //   @DataProvider(name = "provider")
    static Object[] testInfoProvider() {
        return new Object[]{
               /* DataTransferObjectMaker.getTestData_1(),
                DataTransferObjectMaker.getTestData_2(),
                DataTransferObjectMaker.getTestData_3(),*/
                DataTransferObjectMaker.getTestData(1),
                DataTransferObjectMaker.getTestData(2),
                DataTransferObjectMaker.getTestData(3)
        };
    }
}