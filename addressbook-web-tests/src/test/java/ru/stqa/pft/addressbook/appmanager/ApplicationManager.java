package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.fail;

public class ApplicationManager {
    WebDriver wd;
    private SessionHelper sessionHelper;
    private NavigationHepler navigationHepler;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    public StringBuffer verificationErrors = new StringBuffer();
    public boolean acceptNextAlert = true;
    public String baseUrl;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

//Vibor brauzera
    public void init() {
        if (browser.equals (BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals (BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals (BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }
        baseUrl = "http://localhost/addressbook/";
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");

        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        navigationHepler = new NavigationHepler(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }

    public boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public NavigationHepler goTo() {
        return navigationHepler;
    }

}
