package com.ipmm.mantis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by elijah on 01.05.17.
 */
public class MantisSite {
    public static PageLogin pageLog;
    public static WebDriver driver;
    public static BugReportPage pageBug;

    public static PageMain pageMain;
    public static PageView pageView;
    //public static PageView pageViewer;

    public static void init(WebDriver driver){
        MantisSite.pageLog = PageFactory.initElements(driver, PageLogin.class);
        MantisSite.driver = driver;
        MantisSite.pageBug = PageFactory.initElements(driver, BugReportPage.class);
        MantisSite.pageMain = PageFactory.initElements(driver, PageMain.class);
        MantisSite.pageView = PageFactory.initElements(driver, PageView.class);

    }
    public static void open() {

        driver.navigate().to("http://localhost/mantisbt");
    }
    public static void gotoBugTable() {
        driver.navigate().to("http://localhost/mantisbt/view_all_bug_page.php");
    }
    public static void logout() {
        driver.navigate().to("http://localhost/mantisbt/logout_page.php");
    }

}

