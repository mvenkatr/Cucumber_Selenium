package com.automationpractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.automationpractice.utils.*;


/**
 * Created by Muthuvenkatram on 27/03/2018.
 */

    public class HomePage {

        WebDriver driver;
        SeleniumActionUtil seleniumActionUtil;
        PropertyUtil propertyUtil;



        public HomePage(WebDriver driver) {
            this.driver = driver;
            seleniumActionUtil = new SeleniumActionUtil(driver);
            propertyUtil = new PropertyUtil();
        }


        //Web Element Locators

        By signinButton =By.className("login");

        By emailTextBox = By.name("email");

        By passwordTextBox = By.name("passwd");

        By loginButton = By.id("SubmitLogin");

    
        By tshirtMenuButton = By.xpath(".//*[@id='block_top_menu']/ul/li[3]/a");//By.cssSelector("a[title='T-shirts']");//By.cssSelector(".sfHoverForce>a")


        By signOutButton = By.className("logout");


        By orderCompleteConfirmationLabel=By.className("dark");








    public void clickOnSignInButton() {
        seleniumActionUtil.clickOnElement(signinButton);
        }


        // This method is to set UserName in text box
        public void setEmail(String strUser) {
        	seleniumActionUtil.clickOnElement(emailTextBox);
        	seleniumActionUtil.sendValue(emailTextBox, strUser);
        }

        // This method is to set Password in the password text box
        public void setPassword(String strPassword) {
        	seleniumActionUtil.clickOnElement(passwordTextBox);
        	seleniumActionUtil.sendValue(passwordTextBox, strPassword);
        }

        public void clickOnLoginButton() {
        	seleniumActionUtil.clickOnElement(loginButton);
        }

        public void clickOnTshirtMenuButton() {
        	seleniumActionUtil.clickOnElement(tshirtMenuButton);
        }

    public boolean validateSignIn() {
            return seleniumActionUtil.isElementVisible(signOutButton);
        }

    public boolean validateConfirmationPage() {
        return seleniumActionUtil.isElementVisible(orderCompleteConfirmationLabel);
    }

    public boolean validateOrderHistory() {
        return seleniumActionUtil.isElementVisible(signOutButton);
    }



    public void login() {
        
        clickOnSignInButton();
        seleniumActionUtil.sendValue(emailTextBox, PropertyUtil.getStringPropValue("emailID"));
        seleniumActionUtil.sendValue(passwordTextBox, PropertyUtil.getStringPropValue("password"));
        clickOnLoginButton();
        
    }

}