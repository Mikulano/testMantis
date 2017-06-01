package com.ipmm.mantis.Stepdefs;

import com.ipmm.mantis.MantisSite;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by elijah on 02.05.17.
 */
public class Hook {
    public static WebDriver driver;

    @Before
    public void before(Scenario scenario) {

        System.setProperty("webdriver.chrome.driver", "/home/elijah/Programms/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--lang=en-US");
        driver = new ChromeDriver(options);
        MantisSite.init(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void after(Scenario scenario) {
        driver.close();
    }
}
