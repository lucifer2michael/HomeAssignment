package com.funnygorilla.pageobjectpattern.actions;

import org.openqa.selenium.support.PageFactory;
import com.funnygorilla.pageobjectpattern.pages.SeleniumSupport;
import com.funnygorilla.pageobjectpattern.locators.*;

public class ShopPageActions {
	
	
	private ShopPageLocator locators; 
	
    public ShopPageActions() {
    	
    	this.locators = new ShopPageLocator();
        /*
         * Class used to initialize all the previously declared web elements with @FindBy/@FindAll).
         */
        PageFactory.initElements(SeleniumSupport.getInstance().getDriver(), this.locators);
    }

    public void selectFrog() {
    	if (SeleniumSupport.getInstance().isDisplayed(locators.frog))
    	    SeleniumSupport.getInstance().click(locators.frog);
    }

    public void selectBunny() {
    	if (SeleniumSupport.getInstance().isDisplayed(locators.bunny))
    	    SeleniumSupport.getInstance().click(locators.bunny);
    }
    
    public void selectBear() {
    	if (SeleniumSupport.getInstance().isDisplayed(locators.bear))
    	    SeleniumSupport.getInstance().click(locators.bear);
    }
    
    public void navigateToCart() {
    	SeleniumSupport.getInstance().click(locators.navegateToCart);
    }


}
