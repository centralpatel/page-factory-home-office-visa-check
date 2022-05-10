package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VisaConfirmationTest extends TestBase {
    StartPage startPage;
    WorkTypePage workTypePage;
    SelectNationalityPage selectNationalityPage;
    ReasonForTravelPage reasonForTravelPage;
    ResultPage resultPage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;
    DurationOfStayPage durationOfStayPage;

    @BeforeMethod (alwaysRun = true)
    public void inIt() {
        startPage = new StartPage();
        workTypePage = new WorkTypePage();
        selectNationalityPage = new SelectNationalityPage();
        reasonForTravelPage = new ReasonForTravelPage();
        resultPage = new ResultPage();
        familyImmigrationStatusPage = new FamilyImmigrationStatusPage();
        durationOfStayPage = new DurationOfStayPage();
    }

    @Test (priority = 1, groups = {"sanity", "regression", "smoke"})
    public void anAustralianComingToUKForTourism() {

        //Click on start button
        startPage.clickStartNow();
        //Select a Nationality 'Australia'
        selectNationalityPage.selectNationality("Australia");
        //Click on Continue button
        selectNationalityPage.clickNextStepButton();
        //Select reason 'Tourism'
        reasonForTravelPage.selectReasonForVisit("Tourism or visiting family and friends");
        //Click on Continue button
        reasonForTravelPage.clickNextStepButton();
        //verify result 'You will not need a visa to come to the UK'
        String expectedResult = "You will not need a visa to come to the UK";
        String actualResult = resultPage.getResultMessage();
        Assert.assertEquals(actualResult, expectedResult, "Invalid Message");
    }

    @Test(priority = 2, groups = {"smoke", "regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths() {
        //Click on start button
        startPage.clickStartNow();
        //Select a Nationality 'Chile'
        selectNationalityPage.selectNationality("Chile");
        //Click on Continue button
        selectNationalityPage.clickNextStepButton();
        //Select reason 'Work, academic visit or business'
        reasonForTravelPage.selectReasonForVisit("Work, academic visit or business");
        //Click on Continue button
        reasonForTravelPage.clickNextStepButton();
        //Select intendent to stay for 'longer than 6 months'
        durationOfStayPage.selectLengthOfStay("longer than 6 months");
        //Click on Continue button
        durationOfStayPage.clickNextStepButton();
        //Select have planning to work for 'Health and care professional'
        workTypePage.selectJobType("Health and care professional");
        //Click on Continue button
        workTypePage.clickNextStepButton();
        String expectedResult = "You need a visa to work in health and care";
        String actualResult = resultPage.getResultMessage();
        Assert.assertEquals(actualResult, expectedResult, "Invalid Message");
    }

    @Test(priority = 3, groups = {"regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card() {
        //Click on start button
        startPage.clickStartNow();
        //Select a Nationality 'Colombia'
        selectNationalityPage.selectNationality("Colombia");
        //Click on Continue button
        selectNationalityPage.clickNextStepButton();
        //Select reason 'Join partner or family for a long stay'
        reasonForTravelPage.selectReasonForVisit("Join partner or family for a long stay");
        //Click on Continue button
        reasonForTravelPage.clickNextStepButton();
        //Select state My partner of family member have uk immigration status 'yes'
        familyImmigrationStatusPage.selectImmigrationStatus("Yes");
        //Click on Continue button
        durationOfStayPage.clickNextStepButton();
        //verify result 'You’ll need a visa to join your family or partner in the UK
        String expectedResult = "You’ll need a visa to join your family or partner in the UK";
        String actualResult = resultPage.getResultMessage();
        Assert.assertEquals(actualResult, expectedResult, "Invalid Message");
    }
}
