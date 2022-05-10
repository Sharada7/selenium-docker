package com.newtous.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="passCount")
    private WebElement passengers;

    @FindBy(xpath = "//a[text()='Flights']")
    private WebElement Flights;

    @FindBy(name="findFlights")
    private WebElement submitBtn;

    public FlightDetailsPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public void selectPassengers(String noOfPassengers){
        wait.until(ExpectedConditions.visibilityOf(Flights));
        Flights.click();
        wait.until(ExpectedConditions.elementToBeClickable(passengers));
        Select select=new Select(passengers);
        select.selectByValue(noOfPassengers);
    }

    public void goToFindFlightPage(){
        submitBtn.click();
        driver.quit();
    }
}
