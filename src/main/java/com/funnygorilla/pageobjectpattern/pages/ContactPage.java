package com.funnygorilla.pageobjectpattern.pages;

import com.funnygorilla.pageobjectpattern.actions.*;

public class ContactPage extends BasePage{
	
	public static String contactUrl 
	    = "https://jupiter.cloud.planittesting.com/#/contact"; 
	
    private ContactPageActions contactActions;

    public ContactPage() {   	
    	contactActions = new ContactPageActions();
    	visit(contactUrl);
    }

	public void fillMessage(String message) {
		contactActions.fillMessage(message);
	}
	
	public void fillMail (String mail) {
		contactActions.fillEmail(mail);
	}
	
	public void fillName (String name) {
		contactActions.fillName(name);
	}
	
	public void submit () {
		System.out.print("-----------------------");
		contactActions.submit();
	}
	
	public String getNameError() {
		return contactActions.getNameError();
	}
	
	public String getMailError() {
		return contactActions.getEmailError();
	}
	
	public String getMessageError() {
		return contactActions.getMessageError();
	}
	
	public String getSuccessMessage() {
		return contactActions.getSuccessMessage();
	}
}
