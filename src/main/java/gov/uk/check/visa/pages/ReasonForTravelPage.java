package gov.uk.check.visa.pages;


import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class ReasonForTravelPage extends Utility {
    public ReasonForTravelPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//div[@class='govuk-radios']//label")
    List<WebElement> reasonForVisitList;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement nextStepButton;

    public void selectReasonForVisit(String reason) {
        Reporter.log("Select reason for visiting " + reason + "to reason field" + reasonForVisitList.toString() + "<br>");
        for (WebElement reasonEl : reasonForVisitList) {
            if (reasonEl.getText().contains(reason))
            {clickOnElement(reasonEl);
                break;}
        }
    }

    public void clickNextStepButton() {
        clickOnElement(nextStepButton);
    }


}
