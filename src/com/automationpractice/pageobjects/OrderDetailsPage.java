package com.automationpractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.automationpractice.utils.*;

public class OrderDetailsPage {

    WebDriver driver;
    SeleniumActionUtil seleniumActionUtil;
    PropertyUtil propertyUtil;
    
    String orderId2;
    String orderId1;
    boolean id;

    public OrderDetailsPage(WebDriver driver) {
        this.driver = driver;
        seleniumActionUtil = new SeleniumActionUtil(driver);
        propertyUtil = new PropertyUtil();
    }

    
    By productButton=By.xpath("//div[@class='product-container']");
    

    By addToCartButton=By.name("Submit");

    By proceedToCheckoutButton=By.xpath(".//*[@title='Proceed to checkout']");

    
    By proceedToCheckoutSummaryPage= By.xpath(".//*[@id='center_column']/p[2]/a[1]/span");

    By proceedToCheckoutAddressPage=By.name("processAddress");
            

    By proceedToCheckoutShippingPage= By.name("processCarrier");
            

    By iAgreeTermsCheckbox=By.id( "cgv");

    By payByBankWire=By.className( "bankwire");
            

    By confirmOrderButton= By.xpath(".//*[@id='cart_navigation']/button");
            

    By customerAccountButton= By.className("account");
            

    By orderHistoryAndDetailsButton=By.xpath( ".//*[@title='Orders']");
            

    @FindBy(how= How.CLASS_NAME, using="box")
    WebElement tableContent;

    By proceedToCheckoutQuickView= By.xpath("//i[@class='icon-chevron-right right']");

    @FindBy(how=How.CSS, using=".color-myaccount")
    WebElement orderIdInOrderHistory;


    public void clickOnProductButton() {
    	seleniumActionUtil.clickOnElement(productButton);
       
    	seleniumActionUtil.clickOnElement(By.xpath("//span[text()='Add to cart']"));
    }

    public void clickOnAddToCartButton() {
    	seleniumActionUtil.clickOnElement(addToCartButton);
    }

    public void clickOnProceedToCheckoutButton() throws InterruptedException {
    	Thread.sleep(10000);
    	seleniumActionUtil.clickOnElement(proceedToCheckoutButton);
    }

    public void clickOnProceedToCheckoutSummaryPage() {
       
    	seleniumActionUtil.clickOnElement(proceedToCheckoutSummaryPage);
    }

    public void clickOnProceedToCheckoutAddressPage() {
    	seleniumActionUtil.clickOnElement(proceedToCheckoutAddressPage);
    }

    public void clickOnIAgreeTermsCheckbox() {
    	seleniumActionUtil.click(iAgreeTermsCheckbox);
    }

    public void clickOnProceedToCheckoutShippingPage() {
    	seleniumActionUtil.clickOnElement(proceedToCheckoutShippingPage);
    }

    public void clickOnPayByBankWire() {
    	seleniumActionUtil.clickOnElement(payByBankWire);
    }

    public void clickOnConfirmOrderButton() {
    	seleniumActionUtil.clickOnElement(confirmOrderButton);
    }

    public void clickOnCustomerAccountButton() {
    	seleniumActionUtil.clickOnElement(customerAccountButton);
    }

    public void clickOnOrderHistoryAndDetailsButton() {
    	seleniumActionUtil.clickOnElement(orderHistoryAndDetailsButton);
    }

    public void getTableContent() {

        String text = tableContent.getText();
        Pattern p = Pattern.compile("\\b[A-Z]{4,}\\b");
        Matcher m = p.matcher(text);
        while (m.find()) {
            String word = m.group();
            orderId1=word;
            System.out.println(word);
        }
    }

    public boolean matchOrderId(){
        return orderId1.equalsIgnoreCase(orderId2);
    }

    public void getOrderIdFromOrderHistory() {
        clickOnCustomerAccountButton();
        clickOnOrderHistoryAndDetailsButton();
        String orderId = orderIdInOrderHistory.getText();
        orderId2=orderId;
        System.out.println(orderId);
    }

    public void orderTShirt() throws InterruptedException {
        clickOnProductButton();
        clickOnProceedToCheckoutButton();
        clickOnProceedToCheckoutSummaryPage();
        clickOnProceedToCheckoutAddressPage();
        clickOnIAgreeTermsCheckbox();
        clickOnProceedToCheckoutShippingPage();
        clickOnPayByBankWire();
        clickOnConfirmOrderButton();
        getTableContent();
    }
}

