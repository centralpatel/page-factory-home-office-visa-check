package gov.uk.check.visa.pages;


import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ResultPage extends Utility {

    public ResultPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@class='gem-c-heading gem-c-heading--font-size-27 govuk-!-margin-bottom-6']")
    WebElement resultMessage;

    public String getResultMessage() {
        Reporter.log("verify result" + "get text" + resultMessage.getText() + "<br>");
        return getTextFromElement(resultMessage);
    }
//    public void confirmResultMessage(String expectedMessage){
//        Assert.assertTrue(true, expectedMessage);
//        getTextFromElement(resultMessage);
//    }
}
