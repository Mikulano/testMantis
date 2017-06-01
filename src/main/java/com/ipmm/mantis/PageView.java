package com.ipmm.mantis;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * Created by elijah on 01.06.17.
 */
public class PageView {

    @FindBy(xpath = "//select[@name=\"new_status\"]")
    WebElement changeStatus;

    @FindBy(xpath = "//input[@value=\"Change Status To:\"]")
    WebElement changeStatusBtn;

    @FindBy(xpath = "//input[@value=\"Resolve Issue\"]")
    WebElement resolveBtn;

    @FindBy(xpath = "//input[@value=\"Close Issue\"]")
    WebElement CloseBtn;

    @FindBy(xpath = "//td[@class=\"bug-assigned-to\"]")
    WebElement bugAssigned;

    @FindBy(xpath = "//td[@class=\"bug-category\"]")
    WebElement bugCategory;

    @FindBy(xpath = "//td[@class=\"bug-severity\"]")
    WebElement bugSeverity;

    @FindBy(xpath = "//td[@class=\"bug-priority\"]")
    WebElement bugPriority;

    @FindBy(xpath = "//td[@class=\"bug-status\"]")
    WebElement bugStatus;

    @FindBy(xpath = "//td[@class=\"bug-platform\"]")
    WebElement bugPlatform;

    @FindBy(xpath = "//td[@class=\"bug-os\"]")
    WebElement bugOs;

    @FindBy(xpath = "//td[@class=\"bug-os-version\"]")
    WebElement bugOsVersion;

    @FindBy(xpath = "//td[@class=\"bug-summary\"]")
    WebElement bugSummary;

    @FindBy(xpath = "//td[@class=\"bug-description\"]")
    WebElement bugDescription;

    @FindBy(xpath = "//td[@class=\"bug-steps-to-reproduce\"]")
    WebElement bugStepsToReproduce;

    @FindBy(xpath = "//td[@class=\"bug-additional-information\"]")
    WebElement bugAdditionalInformation;

    @FindBy(xpath = "//select[@name=\"handler_id\"]")
    WebElement handlerSelector;

    @FindBy(xpath = "//input[@value=\"Assign To:\"]")
    WebElement handlerBtn;

    public void checkFields(BugForm bugForm, String status) {
        Assert.assertTrue(
                bugAssigned.getText().contains(bugForm.getAssign_to())
                        && bugCategory.getText().contains(bugForm.getCategory())
                        && bugSeverity.getText().contains(bugForm.getSeverity())
                        && bugPriority.getText().contains(bugForm.getPriority())
                        && bugStatus.getText().contains(status)
                        && bugPlatform.getText().contains(bugForm.getPlatform())
                        && bugOs.getText().contains(bugForm.getOs())
                        && bugOsVersion.getText().contains(bugForm.getOsVersion())
                        && bugSummary.getText().contains(bugForm.getSummary())
                        && bugDescription.getText().contains(bugForm.getDescription())
                        && bugStepsToReproduce.getText().contains(bugForm.getSteps_to_reproduce())
                        && bugAdditionalInformation.getText().contains(bugForm.getAdditional_info())
        );
    }

    public void resolveIssue(String status){
        Select selector = new Select(changeStatus);
        selector.selectByVisibleText(status);
        changeStatusBtn.click();
        resolveBtn.click();
    }

    public void closeIssue(String status) {

        new Select(handlerSelector).selectByVisibleText("lead1");
        handlerBtn.click();
        Select selector = new Select(changeStatus);
        selector.selectByVisibleText(status);
        changeStatusBtn.click();
        CloseBtn.click();
    }
}

