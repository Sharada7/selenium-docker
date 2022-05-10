package com.newtous.tests;

import com.Tests.BaseTest;
import com.newtous.pages.FlightDetailsPage;
import com.newtous.pages.RegistrationConfirmationPage;
import com.newtous.pages.RegistrationPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {

    @Test
    public void registrationPage(){
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("Udemy","Docker");
        registrationPage.userCredentials("udemy","udemy","udemy");
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmation(){
        RegistrationConfirmationPage registrationConfirmationPage=new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmation")
    @Parameters({"noOfPassenger"})
    public void flightDetailsPage(String noOfPassenger){
        FlightDetailsPage flightDetailsPage=new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers(noOfPassenger);
        flightDetailsPage.goToFindFlightPage();
    }

   /* @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage(){
        FindFlightPage findFlightPage=new FindFlightPage(driver);
        findFlightPage.submitFindFlightPage();
        findFlightPage.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightPage")
    public void flightConfPage(){
        FlightCOnfirmationPage flightCOnfirmationPage=new FlightCOnfirmationPage(driver);
        flightCOnfirmationPage.printConfirmation();
    }*/
}
