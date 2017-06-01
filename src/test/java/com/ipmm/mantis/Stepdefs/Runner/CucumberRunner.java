package com.ipmm.mantis.Stepdefs.Runner;

/**
 * Created by elijah on 10.05.17.
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "json:target/reports/mainReport.json"},
        features = {"src/test/resources/features"},
        glue = {"com.ipmm.mantis.Stepdefs"} )
public class CucumberRunner {

}
