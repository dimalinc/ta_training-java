package test;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.cloud.google.com.CalculatorPage;
import page.cloud.google.com.CloudMainPage;
import page.cloud.google.com.PageDetailedView;
import util.Utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static util.Utils.*;

public class GoogleCloudTest extends BaseTest {

    private CalculatorPage calculator;
    private PageDetailedView detailedView;
    public static final String EXPECTED_PAGE_NAME = ("Google Cloud Pricing Calculator");
    public static final String CLOUD_URL = ("https://cloud.google.com/?hl=en");
    public static final String CALC_URL = ("https://cloud.google.com/products/calculator?hl=en");
    public static final String SEARCH_PROMPT = ("Google Cloud Platform Pricing Calculator");


    @Test(priority=1)
    public void redirectsToCalculatorPage() {

        CloudMainPage cloudMainPage = new CloudMainPage(driver);

        cloudMainPage = cloudMainPage.open_URL(CLOUD_URL)
                .button_Search_click();

        cloudMainPage = cloudMainPage.
                perform_Search(SEARCH_PROMPT);

    /*    FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofMillis(5000));
        wait.pollingEvery(Duration.ofMillis(250));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@track-type='search-result']") ) );
*/
        Utils.waitForElementPresence
                (driver,5000,250,
                        By.xpath(CloudMainPage.getList_a_searchResults_xpath()));

        CalculatorPage calculatorPage = cloudMainPage.click_Search_result(EXPECTED_PAGE_NAME);

     /*   FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofMillis(15000));
        wait.pollingEvery(Duration.ofMillis(250));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.titleContains(EXPECTED_PAGE_NAME));*/
        Utils.waitUntilTitleContains(driver, 15000,250,
                EXPECTED_PAGE_NAME);
        var actual=calculatorPage.get_page_title();
        assertEquals(EXPECTED_PAGE_NAME, actual);
    }

    @Test(priority=2)
    public void calculatorPageTest() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage = calculatorPage.open_URL(CALC_URL);

       calculatorPage = calculatorPage.compute_engine_click()
               .enter_numberOfInstances(4)
               .selectServerType("n1-standard-8");

    }

   /* @Test
    public void priceIsGettingEstimated() {
        calculator = new CalculatorPage(driver);
        form = FormInitializer.initializeForm();

        var expected = form.getEstimatedCost();
        var actual = calculator.navigateToUrl(CALCULATOR_URL)
                .clickOnComputeEngine()
                .setNumberOfInstances(form.getNumberOfInstances())
                .setMachineType(form.getMachineType())
                .addGpuModel(form.getGpuModel())
                .setLocalSSD(form.getLocalSSD())
                .setLocation(form.getDataCenterLocation())
                .clickOnCommitedUsage()
                .getEstimatedCost();

        assertEquals(expected, actual);
    }

    @Test(dependsOnMethods = "priceIsGettingEstimated")
    public void redirectsToDetailedView() {
        detailedView = calculator
                .clickOnDetailedView()
                .moveToTheTab(TAB_INDEX, TAB_NAME);
        assertEquals(TAB_NAME, detailedView.getPageName());
    }

    @Test(dependsOnMethods = "redirectsToDetailedView")
    public void correctDataProvided() {
        SoftAssert softAssert = new SoftAssert();

        var numberOfInstancesActual = detailedView.getNumberOfInstancesText();
        softAssert.assertEquals(form.getNumberOfInstances(), numberOfInstancesActual);

        String machineTypeActual = detailedView.getMachineTypeText();
        var expectedType = form.getMachineType();
        softAssert.assertTrue(machineTypeActual.contains(expectedType));

        var addedGPUsActual = detailedView.getGpusBoolean();
        softAssert.assertTrue(addedGPUsActual);

        var gpuModelActual = detailedView.getGpuModelText();
        softAssert.assertEquals(form.getGpuModel(), gpuModelActual);

        String localSsdActual = detailedView.getLocalSsdText();
        softAssert.assertEquals(form.getLocalSSD(), localSsdActual);

        var locationActual = detailedView.getRegionText();
        softAssert.assertEquals(form.getDataCenterLocation(), locationActual);

        softAssert.assertAll();
    }*/


}
