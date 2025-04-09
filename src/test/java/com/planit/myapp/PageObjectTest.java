package com.planit.myapp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.funnygorilla.pageobjectpattern.pages.HomePage;
import com.funnygorilla.pageobjectpattern.pages.ContactPage;
import com.funnygorilla.pageobjectpattern.pages.CartPage;
import com.funnygorilla.pageobjectpattern.pages.ShopPage;


public class PageObjectTest {
	
	public static final String FrogUnitPrive = "$10.99";
	public static final String BunnyUnitPrive = "$9.99";
	public static final String BearUnitPrive = "$14.99";
	
	static HomePage homePage;
	static ContactPage contactPage;
	static ShopPage shopPage;
	static CartPage cartPage;
	
    @Test
    public void test01()
    {
    	// navigate to Contact page
    	homePage.navigateToContact();
    	// click submit button
    	contactPage.submit();
    	
    	String errorName = contactPage.getNameError();
    	String errorEmail = contactPage.getMailError();
    	String errorMessage = contactPage.getMessageError();
    	
	    Assertions.assertEquals("Forename is required", errorName);
	    Assertions.assertEquals("Email is required", errorEmail);
	    Assertions.assertEquals("Message is required", errorMessage);      
	    
	    //Populate mandatory fields
	    contactPage.fillName("John");
	    contactPage.fillMail("John.example@planit.net.au");
	    contactPage.fillMessage("They are great!");
	     
	    //Click submit button
	    contactPage.submit();
    }    
       
    @Test
    @RepeatedTest(5)
    public void test02()
    {
    	// navigate to Contact page
    	homePage.navigateToContact();
	    
	    // Populate mandatory fields
	    contactPage.fillName("John");
	    contactPage.fillMail("John.example@planit.net.au");
	    contactPage.fillMessage("They are great!");
	     
	    // Click submit button
	    contactPage.submit();
	    
	    String successMsg = contactPage.getSuccessMessage();
	    Assertions.assertEquals("Thanks John, we appreciate your feedback.", successMsg);      
    }    
	    
    /**
     * 1. Buy 2 Stuffed Frog, 5 Fluffy Bunny, 3 Valentine Bear
     * 2. Go to the cart page
     * 3. Verify the subtotal for each product is correct
     * 4. Verify the price for each product
     * 5. Verify that total = sum(sub totals)
     */
    @Test
    public void test03()
    {
    	int numOfBunny = 5, numOfFrog = 2, numOfBear = 3;
    	String priceFrog = null, priceBunny = null, priceBear = null;
    	String total = null, subTotalFrog = null, subTotalBunny = null, subTotalBear = null;
    	
    	// navigate to Shop page
    	homePage.navigateToShop();

    	// Buy 2 Stuffed Frog, 5 Fluffy Bunny, 3 Valentine Bear
        for (int i = 0; i < numOfBunny; i++) {shopPage.clickBunny();}        
        for (int i = 0; i < numOfFrog; i++) {shopPage.clickFrog();}
        for (int i = 0; i < numOfBear; i++) {shopPage.clickBear();}

    	// navigate to Contact page
    	shopPage.navigateToCart();
    	
    	priceBear = cartPage.getUnitPriceBear();
    	priceBunny = cartPage.getUnitPriceBunny();
    	priceFrog = cartPage.getUnitPriceFrog();
    	
		// Verify the price for each product
		Assertions.assertEquals(FrogUnitPrive, priceFrog);
		Assertions.assertEquals(BunnyUnitPrive, priceBunny);
		Assertions.assertEquals(BearUnitPrive, priceBear);
		
		// Verify the subtotal for each product is correct
		subTotalFrog = cartPage.getSubTotalFrog().trim().substring(1);;
		subTotalBunny = cartPage.getSubTotalBunny().trim().substring(1);;
		subTotalBear = cartPage.getSubTotalBear().trim().substring(1);;
		
    	System.out.println (subTotalFrog + " " + subTotalBunny + " " + subTotalBear );
		
		float subtotalF = Float.parseFloat(subTotalFrog);
		float subtotalB = Float.parseFloat(subTotalBunny);
		float subtotalV = Float.parseFloat(subTotalBear);
       
		// Verify that total = sum(subTotals)
		total = cartPage.getTotal().trim().split(":")[1].trim();		
        float totalF = Float.parseFloat(total);        
		float expectedTotal = subtotalF + subtotalB + subtotalV;
		Assertions.assertEquals(expectedTotal, totalF, 0.01);     

    }    
		
    
    
    
	//-------------------------------------------------------- lifecycle methods
	    
	@BeforeAll
	static void setup(){
	}
	
	@BeforeEach
	void setupThis(){
		System.out.println("@BeforeEach");
		homePage = new HomePage();
		contactPage = new ContactPage();
		shopPage = new ShopPage();
		cartPage = new CartPage();
	}
	
	@AfterEach
	void tearThis(){
		System.out.println("@AfterEach");
	}
	
	@AfterAll
	static void tear(){
		System.out.println("@AfterAll");
		homePage.quit();
		contactPage.quit();
		shopPage.quit();
	}
	
}
