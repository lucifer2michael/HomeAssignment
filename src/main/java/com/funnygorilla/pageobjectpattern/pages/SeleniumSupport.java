package com.funnygorilla.pageobjectpattern.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumSupport {

	private static SeleniumSupport support = null;
	private WebDriver driver;
	private WebDriverWait wait;
    private int timeoutSec = 30; // wait timeout (5 seconds by default)

    
    private SeleniumSupport() {
        /*
         * WebDriverManager is an open-source Java library that carries out the management 
         * (i.e., download, setup, and maintenance) of the drivers required by Selenium WebDriver
         *  WebDriverManager provides other relevant features, 
         *  such as the capability to discover browsers installed in the local system, building WebDriver objects
         */
    	//driver = WebDriverManager.getInstance(browser).create(); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, timeoutSec);  
    }
    
    public static SeleniumSupport getInstance() {
    	if (null == support) {
    		support = new SeleniumSupport();
    	}
    	return support;
    }

    public void setTimeoutSec(int timeoutSec) {  
        this.timeoutSec = timeoutSec;
    }

    public void visit(String url) {  
        driver.get(url);
    }

    public void click(WebElement element) {
    	element.click();
    }

    public void type(WebElement element, String text) {
    	element.sendKeys(text);    	
    }
    
    public String getText(WebElement element) {
    	return element.getText().trim();
    }
    
    public void quit () {
    	driver.quit();
    }
    
    public void close () {
    	driver.close();
    }
    
    public void deleCookies () {
    	driver.manage().deleteAllCookies();
    }
   
    
    public boolean isDisplayed(WebElement element) {  
        try {
        	wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
        
    public WebDriver getDriver() {
    	return driver;
    }

}
