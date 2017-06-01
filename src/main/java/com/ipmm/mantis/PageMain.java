package com.ipmm.mantis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.stream.Collectors;

/**
 * Created by elijah on 10.05.17.
 */
public class PageMain {
    @FindBy(xpath = "//a[@href=\"bug_report_page.php\"]")
    WebElement reportIssueBtn;

    @FindBy(id = "buglist")
    WebElement buglist;

    @FindBy(id = "hide_status_filter")
    WebElement hideStatusFilter;

    @FindBy(xpath = "//select[@name=\"hide_status[]\"]")
    WebElement hideStatusSelector;

    @FindBy(xpath = "//input[@name=\"filter\"]")
    WebElement applyFilterBtn;


    public void findCreatedIssue(BugForm bugs, String assigned) {
        Assert.assertTrue(MantisSite.driver.findElements(By.xpath("//*[@id=\"buglist\"]/tbody/tr"))
                .stream().anyMatch(row ->
                        (row.getText().contains(bugs.getSummary()))
                                && (row.getText().contains("block"))
                                && (row.getText().contains(assigned))
                                && (row.getText().contains("General"))));
    }


    public void findCreatedAndOpen(BugForm issue, String assigned) {
        MantisSite.driver.findElements(By.xpath("//*[@id=\"buglist\"]/tbody/tr")).stream()
                .filter(row -> (row.getText().contains(issue.getSummary()))
                        && (row.getText().contains("block"))
                        && (row.getText().contains(assigned))
                        && (row.getText().contains("General")))
                .collect(Collectors.toList()).get(0)
                .findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[4]/a")).click();
    }


    public void openReportBugForm() {
        reportIssueBtn.click();
    }

    public void turnFilterOff() {
        hideStatusFilter.click();
        new Select(hideStatusSelector).selectByVisibleText("[none]");
        applyFilterBtn.click();
    }
}