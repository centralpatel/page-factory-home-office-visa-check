package gov.uk.check.visa.pages;


import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends Utility {
    public StartPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//a[normalize-space()='Start now']")
    WebElement startNow;

    public void clickStartNow(){
        clickOnElement(startNow);
    }


}
