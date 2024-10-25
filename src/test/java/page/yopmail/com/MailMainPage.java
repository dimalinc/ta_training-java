package page.yopmail.com;

import org.openqa.selenium.WebDriver;
import page.AbstractPage;
import page.cloud.google.com.CalculatorPage;

public class MailMainPage extends AbstractPage {
    private final WebDriver driver;

    String generatedEmail;

    public MailMainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public MailMainPage open_page() {
        driver.get("https://yopmail.com/");
        return this;
    }


    public void generateEmail() {}

    public CalculatorPage navigateback_ToCalculatorPage() {
        return new CalculatorPage(driver);
    }

}

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
