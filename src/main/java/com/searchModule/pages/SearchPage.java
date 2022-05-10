package com.searchModule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(name="q")
    private WebElement searchTxt;

    @FindBy(id="search_button_homepage")
    private WebElement searchBtn;

    @FindBy(linkText="Videos")
    private WebElement videoLink;

    @FindBy(className="tile--vid")
    private List<WebElement> allVideo;

    public SearchPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public void goTo(){
        driver.get("https://duckduckgo.com");
    }

    public void doSearch(String search){
        wait.until(ExpectedConditions.visibilityOf(searchTxt));
        searchTxt.sendKeys(search);
        searchBtn.click();
    }

    public void gotoVideo(){
        wait.until(ExpectedConditions.visibilityOf(videoLink));
        videoLink.click();
    }

    public int printResult(){
        By by= By.className("tile--vid");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,0));
        return allVideo.size();
    }
}
