package com.funnygorilla.pageobjectpattern.actions;

import org.openqa.selenium.support.PageFactory;
import com.funnygorilla.pageobjectpattern.pages.SeleniumSupport;
//import com.funnygorilla.pageobjectpattern.locators.ContactPageLocator;
import com.funnygorilla.pageobjectpattern.locators.*;

public class CartPageActions {
	
	
	private CartPageLocator locators; 
	
    public CartPageActions() {
    	
    	this.locators = new CartPageLocator();
        /*
         * Class used to initialize all the previously declared web elements with @FindBy/@FindAll).
         */
        PageFactory.initElements(SeleniumSupport.getInstance().getDriver(), this.locators);
    }
    
    public String getPriceFrog () {
    	String priceFrog = null;
    	if (SeleniumSupport.getInstance().isDisplayed(locators.priceFrog))
    		priceFrog = SeleniumSupport.getInstance().getText(locators.priceFrog);    	    	
    	
    	return priceFrog;    	
    }

    public String getPriceBunny () {
    	String priceBunny = null;
    	if (SeleniumSupport.getInstance().isDisplayed(locators.priceBunny))
    		priceBunny = SeleniumSupport.getInstance().getText(locators.priceBunny);    	    	
    	
    	return priceBunny;    	
    }

    public String getPriceBear () {
    	String priceBear = null;
    	if (SeleniumSupport.getInstance().isDisplayed(locators.priceBear))
    		priceBear = SeleniumSupport.getInstance().getText(locators.priceBear);    	    	
    	
    	return priceBear;    	
    }

    public String getsubTotalFrog () {
    	String priceFrog = null;
    	if (SeleniumSupport.getInstance().isDisplayed(locators.subtotalFrog))
    		priceFrog = SeleniumSupport.getInstance().getText(locators.subtotalFrog);    	    	
    	
    	return priceFrog;    	
    }

    public String getsubTotalBunny () {
    	String priceBunny = null;
    	if (SeleniumSupport.getInstance().isDisplayed(locators.subtotalBunny))
    		priceBunny = SeleniumSupport.getInstance().getText(locators.subtotalBunny);    	    	
    	
    	return priceBunny;    	
    }

    public String getsubTotalBear () {
    	String priceBear = null;
    	if (SeleniumSupport.getInstance().isDisplayed(locators.subtotalBear))
    		priceBear = SeleniumSupport.getInstance().getText(locators.subtotalBear);    	    	
    	
    	return priceBear;    	
    }
    
    public String getTotal () {
    	String total = null;
    	if (SeleniumSupport.getInstance().isDisplayed(locators.total))
    		total = SeleniumSupport.getInstance().getText(locators.total);    	    	
    	
    	return total;    	
    }
    
    
    
    
}
