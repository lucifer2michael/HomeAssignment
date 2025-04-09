package com.funnygorilla.pageobjectpattern.actions;

import org.openqa.selenium.support.PageFactory;
import com.funnygorilla.pageobjectpattern.pages.SeleniumSupport;
//import com.funnygorilla.pageobjectpattern.locators.ContactPageLocator;
import com.funnygorilla.pageobjectpattern.locators.*;

public class ContactPageActions {
	
	
	private ContactPageLocator locators; 
	
    public ContactPageActions() {
    	
    	this.locators = new ContactPageLocator();
        /*
         * Class used to initialize all the previously declared web elements with @FindBy/@FindAll).
         */
        PageFactory.initElements(SeleniumSupport.getInstance().getDriver(), this.locators);
    }

    public void submit() {
    	if (SeleniumSupport.getInstance().isDisplayed(locators.submit))
    	    SeleniumSupport.getInstance().click(locators.submit);
    }

    public void fillName(String name) {
    	if (SeleniumSupport.getInstance().isDisplayed(locators.foreName))
    		SeleniumSupport.getInstance().type(locators.foreName, name);
    	
    	//SeleniumSupport.getInstance().type(locators.foreName, name);
    }

    public void fillEmail(String mail) {
    	if (SeleniumSupport.getInstance().isDisplayed(locators.email))
    	    SeleniumSupport.getInstance().type(locators.email, mail);
    }

    public void fillMessage(String message) {
    	if (SeleniumSupport.getInstance().isDisplayed(locators.message))
    	    SeleniumSupport.getInstance().type(locators.message, message);
    }
    
    public String getNameError() {
    	String nameError = null;
    	if (SeleniumSupport.getInstance().isDisplayed(locators.resultName))
    		nameError = SeleniumSupport.getInstance().getText(locators.resultName);
    	return nameError;
    }

    public String getEmailError() {
    	String mailError = null;
    	if (SeleniumSupport.getInstance().isDisplayed(locators.resultEmail))
    		mailError = SeleniumSupport.getInstance().getText(locators.resultEmail);    	
    	return mailError;
    }

    public String getMessageError() {
    	String messageError = null;
    	if (SeleniumSupport.getInstance().isDisplayed(locators.resultMessage))
    		messageError = SeleniumSupport.getInstance().getText(locators.resultMessage);    	
    	
    	return messageError;
    }
    
    public String getSuccessMessage () {
    	String messageSuccess = null;
    	if (SeleniumSupport.getInstance().isDisplayed(locators.successMessage))
    		messageSuccess = SeleniumSupport.getInstance().getText(locators.successMessage);    	    	
    	
    	System.out.println("***************** >>> " + messageSuccess);
    	return messageSuccess;
    	
    }
}
