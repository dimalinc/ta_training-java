package com.epam.training.student_dmitriy_plaksin.practice1_Framework.test_junit;

import com.epam.training.student_dmitriy_plaksin.practice1_Framework.model.CloudServerConfig;
import com.epam.training.student_dmitriy_plaksin.practice1_Framework.model.CloudServerConfigInit;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import com.epam.training.student_dmitriy_plaksin.practice1_Framework.page.cloud.google.com.CalculatorPage;
import com.epam.training.student_dmitriy_plaksin.practice1_Framework.page.cloud.google.com.PageDetailedView;
import com.epam.training.student_dmitriy_plaksin.practice1_Framework.test.BaseTest;
import com.epam.training.student_dmitriy_plaksin.practice1_Framework.util.ResourceBundleReader;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GoogleCloudTest_junit extends BaseTest {

    private CalculatorPage calculator;
    private PageDetailedView detailedView;
    public static final String EXPECTED_PAGE_NAME = ("Google Cloud Pricing Calculator");
    public static final String CLOUD_URL = ("https://cloud.google.com/?hl=en");
    public static final String CALC_URL = ("https://cloud.google.com/products/calculator?hl=en");
    public static final String SEARCH_PROMPT = ("Google Cloud Platform Pricing Calculator");

    public static final String CALCULATOR_URL = ResourceBundleReader.readFromRecourceBundle("page.calculatorUrl");
    public static final String TAB_INDEX = ResourceBundleReader.readFromRecourceBundle("page.tabIndex");
    public static final String TAB_NAME = ResourceBundleReader.readFromRecourceBundle("page.tabInfo");



   /* @Test(priority=1)
    public void redirectsToCalculatorPage() {

        CloudMainPage cloudMainPage = new CloudMainPage(driver);

        cloudMainPage = cloudMainPage.open_URL(CLOUD_URL)
                .button_Search_click();

        cloudMainPage = cloudMainPage.
                perform_Search(SEARCH_PROMPT);

    *//*    FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofMillis(5000));
        wait.pollingEvery(Duration.ofMillis(250));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@track-type='search-result']") ) );
*//*
        Utils.waitForElementPresence
                (driver,5000,250,
                        By.xpath(CloudMainPage.getList_a_searchResults_xpath()));

        CalculatorPage calculatorPage = cloudMainPage.click_Search_result(EXPECTED_PAGE_NAME);

     *//*   FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofMillis(15000));
        wait.pollingEvery(Duration.ofMillis(250));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.titleContains(EXPECTED_PAGE_NAME));*//*
        Utils.waitUntilTitleContains(driver, 15000,250,
                EXPECTED_PAGE_NAME);
        var actual=calculatorPage.get_page_title();
        assertEquals(EXPECTED_PAGE_NAME, actual);
    }*/

/*    @Test(priority=2)
    public void calculatorPageCalculationResultTest() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage = calculatorPage.open_URL(CALC_URL);

       calculatorPage = calculatorPage.compute_engine_click()
               .enter_numberOfInstances(4)
               .selectServerType("n1-standard-8")
               .addAndSelectGpus("V100")
               .select_localSSD("2x375 GB")
               .select_Location("Frankfurt (europe-west3)")
               .commitedUsage_click();

        var expectedCost = "$2,135.59";
        String actualCost = calculatorPage.getEstimatedCost();

        assertEquals(expectedCost, actualCost);

    }*/

    @Test/*(priority=2)*/
    public void priceIsGettingEstimated() {
        CalculatorPage calculator = new CalculatorPage(driver);
        CloudServerConfig cloudServerConfig = CloudServerConfigInit.initializeForm();

        var expected = cloudServerConfig.getEstimatedCost();
        var actual = calculator.open_URL(CALCULATOR_URL)
                .compute_engine_click()
                .enter_numberOfInstances(Integer.parseInt(cloudServerConfig.getNumberOfInstances()))
                .selectServerType(cloudServerConfig.getMachineType())
                .addAndSelectGpus(cloudServerConfig.getGpuModel())
                .select_localSSD(cloudServerConfig.getLocalSSD())
                .select_Location(cloudServerConfig.getDataCenterLocation())
               // .commitedUsage_click()
                .divCalculatingChanges_click()
                .divServiceCostUpdated_click()

                .getEstimatedCost();

        assertEquals(expected, actual);

        PageDetailedView detailedView = new PageDetailedView(driver);

        calculator
                .clickOnDetailedView()
                .moveToTheTab(Integer.parseInt(TAB_INDEX), TAB_NAME);
        assertEquals(TAB_NAME, detailedView.getPageName());

        SoftAssertions softAssert = new SoftAssertions();
        var numberOfInstancesActual = detailedView.getNumberOfInstancesText();
        softAssert.assertThat(numberOfInstancesActual).isEqualTo(cloudServerConfig.getNumberOfInstances());
        String machineTypeActual = detailedView.getText_serverType();
        var expectedType = cloudServerConfig.getMachineType();
        softAssert.assertThat(machineTypeActual).contains(expectedType);
        var addedGPUsActual = detailedView.getGpusBoolean();
        softAssert.assertThat(addedGPUsActual).isTrue();
        var gpuModelActual = detailedView.getGpuModelText();
        softAssert.assertThat(cloudServerConfig.getGpuModel()).isEqualTo(gpuModelActual);
        String localSsdActual = detailedView.getDropdown_ssd();
        softAssert.assertThat(cloudServerConfig.getLocalSSD()).isEqualTo(localSsdActual);
        var locationActual = detailedView.getDropdown_datacentreLocation();
        softAssert.assertThat(cloudServerConfig.getDataCenterLocation()).isEqualTo(locationActual);
        softAssert.assertAll();
    }


}
