package page.cloud.google.com;

public class CalculatorPage {

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

