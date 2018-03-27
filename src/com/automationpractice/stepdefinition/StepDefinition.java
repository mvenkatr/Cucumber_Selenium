package com.automationpractice.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automationpractice.utils.*;



public class StepDefinition extends PageObjectReference {
    public WebDriver driver;
    
  
    public StepDefinition()
    {
//    	driver = BrowserInitialize.driver;
    	driver = new ChromeDriver();
    	
    	
    }
@Test
    @Given("^user logs in to the application$")
    public void userIsOnLoginPage() {
        homePage.login();
        Assert.assertTrue(homePage.validateSignIn());
    }


    @When("^user orders a tshirt$")
    public void userOrdersATeshirt() throws InterruptedException {
        homePage.clickOnTshirtMenuButton();
        orderDetailsPage.orderTShirt();
        Assert.assertTrue(homePage.validateOrderHistory());
    }

    @When("^user edits user account details$")
    public void userAccountDetails() {
        personalInfoPage.enterAccountDetails();
        Assert.assertTrue(personalInfoPage.validateSuccessMessage());
    }


    @Then("^orderId is displayed in order history$")
    public void orderidIsDisplayedInOrderHistory(){
        orderDetailsPage.getOrderIdFromOrderHistory();
        Assert.assertTrue(orderDetailsPage.matchOrderId());
    }

    @Then("^user details are updated$")
    public void updatedDetails(){
        personalInfoPage.getSuccessMessageForUpdatingDetails();
        Assert.assertTrue(personalInfoPage.validateSuccessMessage());
    }




}