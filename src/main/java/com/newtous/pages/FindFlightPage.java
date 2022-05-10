package com.newtous.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindFlightPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "reverseFlights")
    private WebElement firstSubmitBtn;

    @FindBy(name = "buyFlights")
    private WebElement secondSubmitBtn;

    public FindFlightPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public void submitFindFlightPage(){
        wait.until(ExpectedConditions.elementToBeClickable(firstSubmitBtn));
        firstSubmitBtn.click();
    }

    public void goToFlightConfirmationPage(){
        wait.until(ExpectedConditions.elementToBeClickable(secondSubmitBtn));
        firstSubmitBtn.click();
    }
}
