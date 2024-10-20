package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.cloud.google.com.CloudMainPage;

public abstract class AbstractPage
{
    protected WebDriver driver;

    protected final int WAIT_TIMEOUT_SECONDS = 10;

    private static  Logger log = null;


    protected AbstractPage(WebDriver driver)
    {
        this.driver = driver;
        log= LogManager.getLogger(this.getClass());
    }

    public void sendKeys(WebElement element, String keys) {
        element.sendKeys(keys);
        log.info("Sent chars to element {}",keys);
    }

    public String get_page_title() {
        return driver.getTitle();
    }
}
