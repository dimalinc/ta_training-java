package page.cloud.google.com;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import page.AbstractPage;
import java.util.List;

public class CloudMainPage extends AbstractPage {
    private final WebDriver driver;
    private static final Logger log = LogManager.getLogger(CloudMainPage.class);
    public FluentWait fluentWaitSearchResults;


    @FindBy(xpath = "//div[@class='YSM5S']")
    private WebElement button_Search;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement input_Search;

    @FindBy(xpath = "//a[@track-type='search-result']")
    private List<WebElement> list_a_searchResults;
    private static final String list_a_searchResults_xpath="//a[@track-type='search-result']";
    public static String getList_a_searchResults_xpath() {
        return list_a_searchResults_xpath;
    }


    public CloudMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CloudMainPage open_URL(String url) {
        driver.get(url);
        log.info("Navigating to URL: {}", url);
        return this;
    }

    public CloudMainPage button_Search_click() {
        button_Search.click();
        return this;
    }

    public CloudMainPage perform_Search(String searchString) {
        log.info("Performing search...");
        sendKeys(input_Search,searchString);
        input_Search.submit();
        return this;
    }

    public CalculatorPage click_Search_result(String searchedText) {
       /* System.out.println("list_a_searchResults size = "+list_a_searchResults.size());
        for (WebElement element: list_a_searchResults) {System.out.println(element.getText());}*/

        list_a_searchResults.stream().
                filter((element) -> element.getText().equals(searchedText)).
                        findAny().ifPresent(WebElement::click);
        log.info("Moving to calculator page by search result clicking");
        return new CalculatorPage(driver);
    }






    // search icon //div[@class="YSM5S"]

    // //input[@jsname="YPqjbf"]
    // or //input
    // or   //input[@id=i4]


    //a[contains(text(),'Google Cloud Pricing Calculator')]
    ////a[text()='Google Cloud Pricing Calculator']

}
