package com.newtous.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="firstName")
    private WebElement firstTxtBox;

    @FindBy(name="lastName")
    private WebElement lastTxtBox;

    @FindBy(name="email")
    private WebElement userNameTxt;

    @FindBy(name="password")
    private WebElement passwordTxt;

    @FindBy(name="confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name="register")
    private WebElement registerBtn;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public void goTo(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        wait.until(ExpectedConditions.visibilityOf(firstTxtBox));
    }

    public void enterUserDetails(String first,String last){
        firstTxtBox.sendKeys(first);
        lastTxtBox.sendKeys(last);
    }

    public void userCredentials(String userName,String password,String confirmPass){
        userNameTxt.sendKeys(userName);
        passwordTxt.sendKeys(password);
        confirmPasswordTxt.sendKeys(confirmPass);
    }

    public void submit(){
        registerBtn.click();
    }
}
