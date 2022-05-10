package com.newtous.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightCOnfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(),''Flight Confirmation)]")
    private WebElement flightConfirmation;

    @FindBy(linkText = "SIGN-OFF")
    private WebElement signOffLink;

    public FlightCOnfirmationPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public void printConfirmation(){
        wait.until(ExpectedConditions.visibilityOf(flightConfirmation));
        System.out.println("Confirmation: "+flightConfirmation.getText());
        signOffLink.click();
    }

}
