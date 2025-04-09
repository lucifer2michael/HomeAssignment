package com.funnygorilla.pageobjectpattern.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ContactPageLocator {
		
    @FindBy(xpath = "//span[@id='forename-err']")
    @CacheLookup
    public WebElement resultName;  
    
    @FindBy(xpath = "//span[@id='email-err']")
    @CacheLookup
    public WebElement resultEmail;

    @FindBy(xpath = "//span[@id='message-err']")
    @CacheLookup
    public WebElement resultMessage;
       
    @FindBy(xpath = "//input[@id='forename']")
    @CacheLookup
    public WebElement foreName;  
    
    @FindBy(xpath = "//input[@id='email']")
    @CacheLookup
    public WebElement email;

    @FindBy(xpath = "//textarea[@id='message']")
    @CacheLookup
    public WebElement message;    
    
    @FindBy(xpath = "//div[@class='form-actions']/a")
    @CacheLookup
    public WebElement submit;  
    
    @FindBy(xpath = "//div[@class='alert alert-success']")
    @CacheLookup
    public WebElement successMessage;      
}
