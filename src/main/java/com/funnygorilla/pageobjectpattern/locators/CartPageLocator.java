package com.funnygorilla.pageobjectpattern.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CartPageLocator {
			
    @FindBy(xpath = "//img[@src='images/src-embed/frog.jpg']/../following-sibling::td[3]")
    @CacheLookup
    public WebElement subtotalFrog;  

    @FindBy(xpath = "//img[@src='images/src-embed/bunny.jpg']/../following-sibling::td[3]")
    @CacheLookup
    public WebElement subtotalBunny;  
    
    @FindBy(xpath = "//img[@src='images/src-embed/valentine.jpg']/../following-sibling::td[3]")
    @CacheLookup
    public WebElement subtotalBear;   
    
    @FindBy(xpath = "//img[@src='images/src-embed/frog.jpg']/../following-sibling::td[1]")
    @CacheLookup
    public WebElement priceFrog;  

    @FindBy(xpath = "//img[@src='images/src-embed/bunny.jpg']/../following-sibling::td[1]")
    @CacheLookup
    public WebElement priceBunny;  
    
    @FindBy(xpath = "//img[@src='images/src-embed/valentine.jpg']/../following-sibling::td[1]")
    @CacheLookup
    public WebElement priceBear;   
    
    @FindBy(xpath = "//strong[@class='total ng-binding']")
    @CacheLookup
    public WebElement total;  
    
}
