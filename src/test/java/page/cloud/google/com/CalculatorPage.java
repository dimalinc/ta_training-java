package page.cloud.google.com;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;

import java.time.Duration;
import java.util.List;

import static util.Utils.waitForElementTextToBePresent;


public class CalculatorPage extends AbstractPage {

    @FindBy(xpath = "//span[text()='Add to estimate']")
    private WebElement span_addToEstimate;
    @FindBy(xpath = "//h2[text()='Compute Engine']")
    private WebElement h2_computeEngine;
    @FindBy(xpath = "//input[@id='c22']")
    private WebElement input_numberOfInstances;


    @FindBy(xpath = "//ul[@aria-label='Machine type']/../..")
    private WebElement machineTypeDropdown;


    private final String xpathString_serverTypeChosen = "//ul[@aria-label='Machine type']"+"/../..//div/span/following-sibling::span/span";
    @FindBy(xpath = xpathString_serverTypeChosen)
    private WebElement machineTypeTextAfterSelectingPerformed;
    @FindBy(xpath = "//ul[@aria-label='Machine type']/li")
    private List<WebElement> dropdovnList_machineTypes;

    @FindBy(xpath = "    //button[@aria-label='Add GPUs']")
    private WebElement button_addGPUs;
    @FindBy(xpath = "//ul[@aria-label='GPU Model']/../..")
    private WebElement gpuModelDropdown;
    @FindBy(xpath = "//ul[@aria-label='GPU Model']"+"/../..//div/span/following-sibling::span/span")
    private WebElement gpuModelText;
    @FindBy(xpath = "//ul[@aria-label='GPU Model']/li")
    private List<WebElement> gpuModelList;

    @FindBy(xpath = "//ul[@aria-label='Local SSD']/../..")
    private WebElement localSsdDropdownListWebElement;
    @FindBy(xpath = "//ul[@aria-label='Local SSD']/li")
    private List<WebElement> listElements_localSsd;
    @FindBy(xpath = "//ul[@aria-label='Local SSD']" + "/../..//div/span/following-sibling::span/span")
    private WebElement localSSDfield_TextAfterSelected;

    @FindBy(xpath = "//ul[@aria-label='Region']/..//..")
    private WebElement locationDropdown;
    @FindBy(xpath = "//ul[@aria-label='Region']/li")
    private List<WebElement> locationsList;
    @FindBy(xpath = "//ul[@aria-label='Region']" +"/../..//div/span/following-sibling::span/span")
    private WebElement regionTextLocator;

    @FindBy(xpath = "//label[text()='1 year']/..")
    private WebElement label_commitedUsage;

    @FindBy(xpath = "//div[text()='Estimated cost']/following::label")
    private WebElement div_estimatedCost;

    @FindBy(xpath = "//a[@aria-label='Open detailed view']")
    private WebElement a_OpenDetailedView;

    private final WebDriver driver;
    private static final Logger log = LogManager.getLogger(CalculatorPage.class);

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CalculatorPage open_URL(String url) {
        driver.get(url);
        log.info("Navigating to URL: {}", url);
        return this;
    }

    private void dropdownList_performSelection(List<WebElement> dropdownList, String dropdownElementName) {
     //   for(WebElement element : dropdownList) {System.out.println(element.getText());}

        dropdownList.stream()
                .filter((element) -> element.getText().contains(dropdownElementName))
                .findAny()
                .ifPresent(WebElement::click);
        log.info("Choosing an option: {}", dropdownElementName);
    }

    public WebElement waitForElementVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public CalculatorPage compute_engine_click() {
        waitForElementVisible(driver, span_addToEstimate).click();
        waitForElementVisible(driver,h2_computeEngine).click();
        return this;
    }

    public CalculatorPage enter_numberOfInstances(int numberOfInstances) {
        waitForElementVisible(driver,input_numberOfInstances);
        input_numberOfInstances.clear();
        input_numberOfInstances.sendKeys(String.valueOf(numberOfInstances));
        log.info("Entered number of instances: {}", numberOfInstances);
        return this;
    }

    public CalculatorPage selectServerType(String serverType) {
        machineTypeDropdown.click();

        dropdownList_performSelection(dropdovnList_machineTypes,serverType);

        waitForElementTextToBePresent(driver,5000,250,machineTypeTextAfterSelectingPerformed,serverType);

        log.info("Server type set to: {}\n Expected type: {}", machineTypeTextAfterSelectingPerformed.getText(), serverType);
        return this;
    }

    public CalculatorPage addAndSelectGpus(String inputGpuModel) {
        button_addGPUs.click();
        gpuModelDropdown.click();
        dropdownList_performSelection(gpuModelList, inputGpuModel);
        log.info("Selected GPU model is: {}\n Expected GPU model: {}", gpuModelText.getText(), inputGpuModel);
        return this;
    }

    public CalculatorPage select_localSSD(String local_SSD_option_for_selection) {
        localSsdDropdownListWebElement.click();
        dropdownList_performSelection(listElements_localSsd,  local_SSD_option_for_selection);
        log.info("Actual local SSD is: {}\n Expected is: {}", localSSDfield_TextAfterSelected.getText(), local_SSD_option_for_selection);
        return this;
    }

    public CalculatorPage select_Location(String location_for_selection) {
        locationDropdown.click();
        dropdownList_performSelection(locationsList, location_for_selection);
        log.info("Actual location: {}\n Expected is: {}", regionTextLocator.getText(), location_for_selection);
        return this;
    }

    public CalculatorPage commitedUsage_click() {
        label_commitedUsage.click();
        return this;
    }

    public String getEstimatedCost() {
        String priceText = div_estimatedCost.getText();
        log.info("Actual price = {}", priceText);
        return priceText;
    }

    public PageDetailedView clickOnDetailedView() {
        waitForElementVisible(driver,a_OpenDetailedView).click();
        log.info("navigating to DetailedView page");
        return new PageDetailedView(driver);
    }

    //span[text()='Add to estimate']

    //h2[text()='Compute Engine']

    //Number of instances*
    //input[@id="c22"]


    // operating system select
    //span[@id="c33"]/preceding-sibling::*[1]

    // os option
    //li[contains(@data-value,'free')]

    //Provisioning Model
    //label[contains(text(),'Regular')]
    // or  //label[text()='Regular']


    //Machine type*
    //span[@id="c45"]/preceding-sibling::*[1]
    // select option
    //li[@data-value="n1-standard-8"]


    //button[@aria-label="Add GPUs"]
    //or
    //div[text()='Add GPUs']/ancestor::*[1]/ancestor::*[1]/descendant::button[@role='switch']

    // select GPU
    //span[@id="c3447"]/preceding-sibling::*[1]
    //option
    //li[contains(@data-value,'v100')]

    // number of GPUs = 1
    //span[@id="c3451"]/preceding-sibling::*[1]
   // option 1 selected
    //span[@id="c3451"]/ancestor::div[1]/following-sibling::div/ul/li[@data-value="1"]

    // SSD
    //span[@id="c53"]/preceding-sibling::*[1]

    //span[@id="c53"]/preceding-sibling::*[1]/ancestor::div[1]/following-sibling::div/ul/li[@data-value="2"]
    // or //li/span/span[text()="2x375 GB"]

    // location Region
    //span[@id="c57"]/preceding-sibling::*[1]

    //span[@id="c57"]/preceding-sibling::*[1]/ancestor::div[1]/following-sibling::div/ul/li[@data-value="europe-west4"]
    // or //li/span/span[text()="Netherlands (europe-west4)"]


    //label[text()='1 year']
    //or  //input[@value="1-year"]

    //span[text()='Share']

    //button[text()='Copy link']  sent link (saved to variable)


    //https://yopmail.com/
    //input[@placeholder='Enter your inbox here']
    //h3[text()='Random Email generator']
    //span[@class='notmobile'][text()='Copy to clipboard']

    //span[text()='Check Inbox']

    //button[@id='newmail']

    //iframe name="ifmail"
    //input[@id="msgto"']
    //input[@id="msgsubject"]
    //div[@id="msgbody"]
    //span[text()=' Send']

    //button[@id='refresh']
    //button[@class="lm"] ? [1]

    // in frame //div[@id="mail"] - compare with sent link (saved to variable)

}

