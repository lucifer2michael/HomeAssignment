package com.funnygorilla.pageobjectpattern.pages;

import com.funnygorilla.pageobjectpattern.actions.ShopPageActions;

public class ShopPage extends BasePage {
	
	public static String shopUrl 
        = "https://jupiter.cloud.planittesting.com/#/shop"; 

	private ShopPageActions shopActions;
	
	public ShopPage() {   	
		shopActions = new ShopPageActions();
		visit(shopUrl);
	}
	
	public void clickBunny() {
		shopActions.selectBunny();
	}
	
	public void clickFrog () {
		shopActions.selectFrog();
	}
	
	public void clickBear () {
		shopActions.selectBear();
	}
	
	public void navigateToCart() {
		shopActions.navigateToCart();
	}

}
