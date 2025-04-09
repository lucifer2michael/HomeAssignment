package com.funnygorilla.pageobjectpattern.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePageLocator {

    @FindBy(xpath = "//li[@id='nav-contact']/a")
    @CacheLookup
    public WebElement navegateToContact;  
    
    @FindBy(xpath = "//a[@href='#/shop']")
    @CacheLookup
    public WebElement navegateToShop;      
}
