package com.newtous.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationConfirmationPage {
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(name = "submit")
    private WebElement signInLink;

    @FindBy(partialLinkText = "Flight")
    private WebElement flightLink;

    public RegistrationConfirmationPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public void goToFlightDetailsPage(){
        wait.until(ExpectedConditions.visibilityOf(signInLink));
        signInLink.click();
    }

}
