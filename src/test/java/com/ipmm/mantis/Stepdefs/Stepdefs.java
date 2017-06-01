package com.ipmm.mantis.Stepdefs;

import com.ipmm.mantis.*;
import com.ipmm.mantis.Stepdefs.Helper.ResourceLoader;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Random;

/**
 * Created by elijah on 01.06.17.
 */



public class Stepdefs {

    private static User user;
    private static BugForm bugForm;

    private void setupIssue(String bugName){
        Random random = new Random();
        bugForm= ResourceLoader.bugForms.get(bugName);
        bugForm.setOs(System.getProperty("os.name"));
        bugForm.setOsVersion(System.getProperty("os.version"));
        bugForm.setPlatform(System.getProperty("os.arch"));

        bugForm.setDescription(bugForm.getDescription() + random.nextInt());
        bugForm.setSummary(bugForm.getSummary() + random.nextInt());
        bugForm.setAdditional_info(bugForm.getAdditional_info() + random.nextInt());
        bugForm.setSteps_to_reproduce(bugForm.getSteps_to_reproduce() + random.nextInt());
    }

    @Given("^User enters as \"([^\"]*)\"$")
    public void userEntersAs(String login) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        MantisSite.open();
        user = ResourceLoader.users.get(login);
        MantisSite.pageLog.fillAndLogin(user);
    }
    @And("^reports an bug$")
    public void reportsAnIssue() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        MantisSite.pageMain.openReportBugForm();
    }

    @When("^user fills the report form with \"([^\"]*)\"$")
    public void userFillsTheIssueWith(String issue_name) throws Throwable{
        // Write code here that turns the phrase above into concrete actions
        setupIssue(issue_name);
        MantisSite.pageBug.fillFields(bugForm);
    }

    @And("^sends bug$")
    public void submitsIssue() throws Throwable {
        MantisSite.pageBug.submitIssue();
    }

    @And("^logs out$")
    public void logouts() throws Throwable {
        MantisSite.logout();
    }

    @Then("^user opens the bug table$")
    public void userOpensTheBugTable() throws Throwable {
        MantisSite.gotoBugTable();
    }

    @When("^user opens the \"([^\"]*)\" issue$")
    public void userOpensTheIssue(String assigned) throws Throwable {
        MantisSite.pageMain.findCreatedAndOpen(bugForm, assigned);
    }

    @And("^checks fields in the issue$")
    public void checksFieldsInTheIssue() throws Throwable {
        MantisSite.pageView.checkFields(bugForm, "assigned");
    }

    @And("^user finds the \"([^\"]*)\" issue$")
    public void userFindsTheIssue(String status) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        MantisSite.pageMain.findCreatedIssue(bugForm, status);
    }

    @And("^user makes the issue closed")
    public void userMakesTheIssue() throws Throwable {
        MantisSite.pageView.closeIssue("closed");
    }


    @And("^user turns off the filters$")
    public void userTurnsOffTheFilters() throws Throwable {
        MantisSite.pageMain.turnFilterOff();
    }

    @And("^user makes the issue resolved$")
    public void userMakesTheIssueResolved() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        MantisSite.pageView.resolveIssue("resolved");
    }
}
