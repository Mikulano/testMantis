package com.ipmm.mantis;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by elijah on 10.05.17.
 */
public class BugReportPage {
    @FindBy(id = "category_id")
    WebElement category;

    @FindBy(id = "reproducibility")
    WebElement reproducibility;

    @FindBy(id = "severity")
    WebElement severity;

    @FindBy(id = "priority")
    WebElement priority;

    @FindBy(id = "handler_id")
    WebElement assign_to;

    @FindBy(id = "summary")
    WebElement summary;

    @FindBy(id = "description")
    WebElement description;

    @FindBy(id = "steps_to_reproduce")
    WebElement steps_to_reproduce;

    @FindBy(id = "additional_info")
    WebElement additional_info;

    @FindBy(xpath = "//input[@tabindex=\"18\"]")
    WebElement submitBtn;

    @FindBy(xpath = "//*[@id=\"profile_closed_link\"]/i")
    WebElement open_platform_btn;

    @FindBy(id = "platform")
    WebElement platform;

    @FindBy(id = "os")
    WebElement os_field;

    @FindBy(id = "os_build")
    WebElement os_version_field;


    public void fillFields(BugForm bug) {

        new Select(category).selectByVisibleText(bug.getCategory());
        new Select(reproducibility).selectByVisibleText(bug.getReproducibility());
        new Select(severity).selectByVisibleText(bug.getSeverity());
        new Select(priority).selectByVisibleText(bug.getPriority());
        new Select(assign_to).selectByVisibleText(bug.getAssign_to());

        try {
            open_platform_btn.click(); //throws if not visible
        } catch (ElementNotVisibleException ignored) {}

        platform.sendKeys(bug.getPlatform());
        os_field.sendKeys(bug.getOs());
        os_version_field.sendKeys(bug.getOsVersion());
        summary.sendKeys(bug.getSummary());
        description.sendKeys(bug.getDescription());
        steps_to_reproduce.sendKeys(bug.getSteps_to_reproduce());
        additional_info.sendKeys(bug.getAdditional_info());

    }

    public void submitIssue(){
        submitBtn.click();
    }

}
