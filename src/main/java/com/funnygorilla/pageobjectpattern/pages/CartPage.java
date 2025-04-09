package com.funnygorilla.pageobjectpattern.pages;

import com.funnygorilla.pageobjectpattern.actions.CartPageActions;

public class CartPage extends BasePage {
	
	public static String cartUrl 
        = "https://jupiter.cloud.planittesting.com/#/cart";

	private CartPageActions cartActions;
	
	public CartPage() {   	
		cartActions = new CartPageActions();
		visit(cartUrl);
	}
	
	public String getUnitPriceBear () {
		return cartActions.getPriceBear();
	}

	public String getUnitPriceFrog () {
		return cartActions.getPriceFrog();
	}
	
	public String getUnitPriceBunny () {
		return cartActions.getPriceBunny();
	}
	
	public String getSubTotalBear () {
		return cartActions.getsubTotalBear();
	}

	public String getSubTotalFrog () {
		return cartActions.getsubTotalFrog();
	}
	
	public String getSubTotalBunny () {
		return cartActions.getsubTotalBunny();
	}
	
	public String getTotal () {
		return cartActions.getTotal();
	}

}
