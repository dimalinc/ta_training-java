package com.epam.training.student_dmitriy_plaksin.practice1_Framework.page.cloud.google.com;
import com.epam.training.student_dmitriy_plaksin.practice1_Framework.page.AbstractPage;
import com.epam.training.student_dmitriy_plaksin.practice1_Framework.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageDetailedView extends AbstractPage {
    private final WebDriver driver;

    @FindBy(xpath = "//span[contains(text(), 'n1')]")
    private WebElement text_serverType;

    @FindBy(xpath = "//span[text()='GPU Model']/following-sibling::span")
    private WebElement dropdown_gpu;

    @FindBy(xpath = "//*[text()='Number of Instances']/following-sibling::span")
    private WebElement input_instancesQty;

    @FindBy(xpath = "//*[text()='Add GPUs']/following-sibling::span")
    private WebElement button_addGpu;

    @FindBy(xpath = "//*[text()='Region']/following-sibling::span")
    private WebElement dropdown_datacentreLocation;

    @FindBy(xpath = "//span[text()='Local SSD']/following-sibling::span")
    private WebElement dropdown_ssd;

    private static final Logger log = LogManager.getLogger(PageDetailedView.class);

    public PageDetailedView(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public PageDetailedView moveToTheTab(int tabIndex, String tabInfo) {
        Object [] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[tabIndex]);
        log.info("Switching to a new tab: {}\t index number: {}", tabInfo, tabIndex);
        return this;
    }

    public String getPageName() {
        return driver.getTitle();
    }

    public String getText_serverType() {
        return Utils.waitForElementPresence(driver,5000,250, text_serverType).getText();
    }

    public String getGpuModelText() {
        return Utils.waitForElementPresence(driver,5000,250, dropdown_gpu).getText();
    }

    public String getNumberOfInstancesText() {
        return Utils.waitForElementPresence(driver,5000,250, input_instancesQty).getText();
    }

    public boolean getGpusBoolean() {
        String tagText = Utils.waitForElementPresence(driver,5000,250, button_addGpu).getText();
        return Boolean.parseBoolean(tagText);
    }

    public String getDropdown_datacentreLocation() {
     //   System.out.println("regionText = " + regionText.getText());
        return Utils.waitForElementPresence(driver,5000,250, dropdown_datacentreLocation).getText();
    }

    public String getDropdown_ssd() {
        return Utils.waitForElementPresence(driver,5000,250, dropdown_ssd).getText();
    }
}
