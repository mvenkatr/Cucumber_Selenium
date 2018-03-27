package com.automationpractice.utils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.pageobjects.*;
import com.automationpractice.stepdefinition.PageObjectReference;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BrowserInitialize{
    
	public static WebDriver driver;
    public PropertyUtil propertyUtil = new PropertyUtil();
    
    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() throws MalformedURLException {
    	initializeBrowser();
    	driver.manage().deleteAllCookies();
    	driver.manage().window().maximize();
        driver.get(propertyUtil.getStringPropValue("URL"));
        setPageObjects();
    }

    private void initializeBrowser() {
        String browser = propertyUtil.getStringPropValue("browser");
        switch (browser){
            case "Chrome":
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
        }
    }

    private void setPageObjects(){
        PageObjectReference.homePage= PageFactory.initElements(driver, HomePage.class);
        PageObjectReference.orderDetailsPage= PageFactory.initElements(driver, OrderDetailsPage.class);
        PageObjectReference.personalInfoPage= PageFactory.initElements(driver, PersonalInfoPage.class);
    }
     
    @After
    public void closeBrowser(Scenario scenario) {
       
    	if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "report/.png");
           }
           driver.close();
           driver.quit();        
    }
    
    
}