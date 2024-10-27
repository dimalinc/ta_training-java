package com.epam.training.student_dmitriy_plaksin.Final_task.test;
import com.epam.training.student_dmitriy_plaksin.Final_task.dataModel.DataTransferObjectMaker;
import com.epam.training.student_dmitriy_plaksin.Final_task.dataModel.DataTransferObject_model;
import com.epam.training.student_dmitriy_plaksin.Final_task.page.PageLogin;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PageLoginSaucedemoTest extends BaseTest {

    @Test(dataProvider = "provider")
   // @MethodSource("provider")
    void validatePageLoginErrorMessage(DataTransferObject_model dto) {
        PageLogin pageLogin = new PageLogin(driver);
        String errorMessage= pageLogin.navigate_to()
                .perform_login(dto.getLogin_username(),dto.getLogin_password())
                .getErrorMessage();

      //  System.out.println("errorMessage = " + errorMessage);
    }

    @DataProvider(name = "provider")
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
