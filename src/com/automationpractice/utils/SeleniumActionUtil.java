package com.automationpractice.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Muthuvenkatram on 27/03/2018.
 */
public class SeleniumActionUtil {

    WebDriver driver;

    public SeleniumActionUtil(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnElement(By element) {
        try {
            //waitForElementToBeClickable(element);
            driver.findElement(element).click();
        } catch (NoSuchElementException var3) {
            System.out.println("[Error] " + element.toString() + " Not found");
        }
    }


    public void sendValue(By element, String value) {
        try {
            this.waitForElementVisible(element);
            driver.findElement(element).sendKeys(new CharSequence[]{value});
        } catch (NoSuchElementException var4) {
            System.out.println("[sendvalue] " + element.toString() + " Not found ");
        }

    }

    public void waitForElementVisible(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        }
        catch (NoSuchElementException var4) {
            System.out.println("[Wait]"+var4.getMessage());
        }
    }

    public void waitForElementToBeClickable(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (NoSuchElementException var4) {
            System.out.println("[Wait]"+var4.getMessage());
        }
    }

    public void click(By element) {
        try {
            driver.findElement(element).click();
        } catch (NoSuchElementException var3) {
            System.out.println("[Error] " + element.toString() + " Not found");
        }
    }

    public boolean isElementVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 15L);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            return true;
        } catch (NoSuchElementException var4) {
            throw new NoSuchElementException(var4.getMessage());
        } catch (TimeoutException var5) {
            throw new TimeoutException(var5.getMessage());
        }
    }

}