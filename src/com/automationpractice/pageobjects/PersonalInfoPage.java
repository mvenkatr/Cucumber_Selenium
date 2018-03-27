package com.automationpractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.automationpractice.utils.*;

/**
 * Created by Muthuvenkatram on 27/03/2018.
 */

    public class PersonalInfoPage {

        WebDriver driver;
        SeleniumActionUtil seleniumActionUtil;
        PropertyUtil propertyUtil;

        public PersonalInfoPage(WebDriver driver) {
            this.driver = driver;
            seleniumActionUtil = new SeleniumActionUtil(driver);
            propertyUtil = new PropertyUtil();
        }

    By personalInformationButton=By.xpath(".//*[@title='Information']")   ;

    By firstNameTextbox =By.id("firstname");

    By lastNameTextbox =By.id("lastname");

    By currentPasswordTextbox=By.id("old_passwd");

    By saveInformationButton=By.name("submitIdentity")  ;

    @FindBy(how=How.XPATH, using=".//*[@id='center_column']/div/p") WebElement successMessageForDetailsUpdate1;

    By successMessageForDetailsUpdate=By.cssSelector(".alert.alert-success");

    public void clickOnPersonalInformationButton(){
        seleniumActionUtil.clickOnElement(personalInformationButton);
    }

    public void enterAccountDetails(){
        clickOnPersonalInformationButton();
        seleniumActionUtil.sendValue(firstNameTextbox, PropertyUtil.getStringPropValue("firtName_append"));
        seleniumActionUtil.sendValue(currentPasswordTextbox, PropertyUtil.getStringPropValue("password"));
        clickSaveInformationButton();
    }

    public void getSuccessMessageForUpdatingDetails(){
        getSuccessMessage();

    }

    public void getSuccessMessage() {

        String message = successMessageForDetailsUpdate1.getText();
        System.out.println(message);
    }

    public void setFirstName(String strFirstName){
    	seleniumActionUtil.sendValue(firstNameTextbox,strFirstName);
    }

    public void setLastName(String strLastName){
    	seleniumActionUtil.sendValue(lastNameTextbox,strLastName);
    }

    public void setCurrentPassword(String strPassword){
    	seleniumActionUtil.sendValue(currentPasswordTextbox,strPassword);
    }

    public void clickSaveInformationButton(){
    	seleniumActionUtil.clickOnElement(saveInformationButton);
    }

    public boolean validateAccountDetailsPage() {
        return seleniumActionUtil.isElementVisible(successMessageForDetailsUpdate);
    }

    public boolean validateSuccessMessage() {
        return seleniumActionUtil.isElementVisible(successMessageForDetailsUpdate);
    }
}
