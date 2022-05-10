package gov.uk.check.visa.pages;


import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class WorkTypePage extends Utility {
    public WorkTypePage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//div[@class='govuk-radios']//div//label")
    List<WebElement> selectJobTypeList;

    @FindBy (xpath = "//button[normalize-space()='Continue']")
    WebElement nextStepButton;

    public void selectJobType(String job) {
        Reporter.log("select job list" + job + "to job field" + selectJobTypeList);
        for (WebElement jobList : selectJobTypeList) {
            if (jobList.getText().contains(job))
                clickOnElement(jobList);
            break;
        }
    }
    public void clickNextStepButton(){
        clickOnElement(nextStepButton);
    }


}
