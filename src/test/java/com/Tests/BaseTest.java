package com.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setDriver() throws MalformedURLException {
        System.out.println("Started");
        String host="localhost";
        DesiredCapabilities dc;
        if(System.getProperty("BROWSER").equals("FireFox")){
            System.out.println("FF1 Started");
            FirefoxOptions options=new FirefoxOptions();
            System.out.println("FF2 Started");
            options.setBinary("C:\\Program Files\\Nightly\\firefox.exe");
            options.addArguments("--headless");
            dc=new DesiredCapabilities(options);
            dc.setCapability("marionette", true);
            System.out.println("Firefox Headless Browser Invoked");
            System.out.println("FF3 Started");
        }else {
            System.out.println("Chrome Entered");
            ChromeOptions options = new ChromeOptions();
            dc=new DesiredCapabilities(options);
            System.out.println("Chrome Started");
        }
        if (System.getProperty("HUB_HOST")!=null){
            host=System.getProperty("HUB_HOST");
        }
        String completeURL="http://"+host+":4444/wd/hub";
        System.out.println("Hub URL Started");
        driver=new RemoteWebDriver(new URL(completeURL),dc);
        System.out.println("DOne");
    }

    @AfterTest
    public void closeBrow(){
        driver.quit();
    }
}
