package com.funnygorilla.pageobjectpattern.actions;

import org.openqa.selenium.support.PageFactory;

import com.funnygorilla.pageobjectpattern.pages.SeleniumSupport;
import com.funnygorilla.pageobjectpattern.locators.HomePageLocator;


public class HomePageActions {
	
	
	private HomePageLocator locators; 
	
    public HomePageActions() {
    	
    	this.locators = new HomePageLocator();
        /*
         * Class used to initialize all the previously declared web elements with @FindBy/@FindAll).
         */
        PageFactory.initElements(SeleniumSupport.getInstance().getDriver(), this.locators);
    }

    public void navigateToContact() {
    	
    	if (SeleniumSupport.getInstance().isDisplayed(locators.navegateToContact))
    	    SeleniumSupport.getInstance().click(locators.navegateToContact);
    }
    
    public void navigateToShop() {
    	
    	if (SeleniumSupport.getInstance().isDisplayed(locators.navegateToShop))
    	    SeleniumSupport.getInstance().click(locators.navegateToShop);
    }
   
    
}
