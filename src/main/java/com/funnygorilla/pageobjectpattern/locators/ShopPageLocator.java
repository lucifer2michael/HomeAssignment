package com.funnygorilla.pageobjectpattern.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShopPageLocator {
	
    @FindBy(xpath = "//li[@id='product-2']//a")
    @CacheLookup
    public WebElement frog;  
    
    @FindBy(xpath = "//li[@id='product-4']//a")
    @CacheLookup
    public WebElement bunny;  
    
    @FindBy(xpath = "//li[@id='product-7']//a")
    @CacheLookup
    public WebElement bear;   

    @FindBy(xpath = "//a[@href='#/cart']")
    @CacheLookup
    public WebElement navegateToCart;      

}
