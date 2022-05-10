package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class DurationOfStayPage extends Utility {

    public DurationOfStayPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='response-0']")
    WebElement lessThanSixMonths;
    @FindBy(xpath = "(//input[@id='response-1'])[1]")
    WebElement moreThanSixMonths;
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement nextStepButton;

    public void selectLengthOfStay(String moreOrLess) {
        Reporter.log("select length" + moreOrLess + "to length field");
       // + lessThanSixMonths.get(0) + moreThanSixMonths.get(1)
        switch (moreOrLess) {
            case "6 months or less":
                clickOnElement(lessThanSixMonths);
                break;
            case "longer than 6 months":
                clickOnElement(moreThanSixMonths);

                break;
        }
    }

    public void clickNextStepButton() {
        clickOnElement(nextStepButton);
    }

}
