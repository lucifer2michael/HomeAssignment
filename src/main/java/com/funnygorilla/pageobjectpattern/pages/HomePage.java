package com.funnygorilla.pageobjectpattern.pages;

import com.funnygorilla.pageobjectpattern.actions.HomePageActions;

public class HomePage extends BasePage {
	
	protected static String planitURL = "https://jupiter.cloud.planittesting.com/";

    HomePageActions homePageActions;

	public HomePage() {   	
		homePageActions = new HomePageActions();
	    visit(planitURL);
	}
	
	public void navigateToContact() {
		homePageActions.navigateToContact();
	}
	
	public void navigateToShop() {
		homePageActions.navigateToShop();
	}	
}


