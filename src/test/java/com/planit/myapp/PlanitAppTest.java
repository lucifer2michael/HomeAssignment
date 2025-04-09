package com.planit.myapp;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * @author Kenny Yang
 * mvn clean test -Dwebdriver.chrome.driver="../Selenium/chromedriver"
 */
public class PlanitAppTest{
	
	
    //-------------------------------------------------------- private variables
	protected static WebDriver driver;
	protected static String planitURL = "https://jupiter.cloud.planittesting.com/";

	
    //@Test
    public void test01()
    {
        System.out.println("@Test01 ...");
	    //Launch website
	    driver.navigate().to(planitURL);
        driver.manage().window().maximize();

        //Click submit button
        driver.findElement(By.xpath("//li[@id='nav-contact']/a")).click();        
        driver.findElement(By.xpath("//div[@class='form-actions']/a")).click();
         
	    //Get the Text based on its xpath
	    String resultName = driver.findElement(By.xpath("//span[@id='forename-err']")).getText().trim();
	    String resultEmail = driver.findElement(By.xpath("//span[@id='email-err']")).getText().trim();
	    String resultMessage = driver.findElement(By.xpath("//span[@id='message-err']")).getText().trim();
	     
	    //Verify error messages
	    Assertions.assertEquals("Forename is required", resultName);
	    Assertions.assertEquals("Email is required", resultEmail);
	    Assertions.assertEquals("Message is required", resultMessage);
	     
	    //Populate mandatory fields
	    driver.findElement(By.xpath("//input[@id='forename']")).sendKeys("John");
	    driver.findElement(By.xpath("//input[@id='email']")).sendKeys("John.example@planit.net.au");
	    driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("They are great!");
	     
	    //Click submit button
	    driver.findElement(By.xpath("//div[@class='form-actions']/a")).click();
    }    
    
    //@Test
    //@RepeatedTest(2)
    public void test02()
    {
        System.out.println("@Test02 ...");
	    //Launch website
	    driver.navigate().to(planitURL);    
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//li[@id='nav-contact']/a")).click();
        //Input the info
        driver.findElement(By.xpath("//input[@id='forename']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("John.example@planit.net.au");
        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("They are great!");
         
        //Click submit button
        driver.findElement(By.xpath("//div[@class='form-actions']/a")).click();
         
        String greetingInfo = driver.findElement(By.xpath("//div[@class='alert alert-success']/strong[@class='ng-binding']")).getText().trim();
        //Validate successful submission message
        Assertions.assertEquals("Thanks John", greetingInfo);    
    }    
    
    //@Test
    public void test03()
    {
        System.out.println("@Test03 ...");
	    //Launch website
	    driver.navigate().to(planitURL);
     
        //Maximize the browser
        driver.manage().window().maximize();
         
        //navigate to shop page
        driver.findElement(By.xpath("//a[@href='#/shop']")).click();
         
        //Buy 2 Stuffed Frog, 5 Fluffy Bunny, 3 Valentine Bear
        for (int i = 0; i < 2; i++) {
        	 driver.findElement(By.xpath("//li[@id='product-2']//a")).click();
        }
        for (int i = 0; i < 5; i++) {
        	 driver.findElement(By.xpath("//li[@id='product-4']//a")).click();
        }
        for (int i = 0; i < 3; i++) {
        	 driver.findElement(By.xpath("//li[@id='product-7']//a")).click();
        }
         
        // navigate to cart page
        driver.findElement(By.xpath("//a[@href='#/cart']")).click();
         
		// Get the subtotal for each product based on its xpath and split the text to get the number
		String subtotalFrog = driver.findElement(By.xpath("//img[@src='images/src-embed/frog.jpg']/../following-sibling::td[3]")).getText().trim();
		subtotalFrog = subtotalFrog.substring(1);
		 		 
		String subtotalBunny = driver.findElement(By.xpath("//img[@src='images/src-embed/bunny.jpg']/../following-sibling::td[3]")).getText().trim();
		subtotalBunny = subtotalBunny.trim().substring(1);
		 
		String subtotalValentine = driver.findElement(By.xpath("//img[@src='images/src-embed/valentine.jpg']/../following-sibling::td[3]")).getText().trim();
		subtotalValentine = subtotalValentine.substring(1);		 
		 
		// Verify the subtotal for each product
		Assertions.assertEquals("21.98", subtotalFrog);
		Assertions.assertEquals("49.95", subtotalBunny);
		Assertions.assertEquals("44.97", subtotalValentine);
		 
		// Get each product price
		String priceFrog = driver.findElement(By.xpath("//img[@src='images/src-embed/frog.jpg']/../following-sibling::td[1]")).getText().trim();
		String priceBunny = driver.findElement(By.xpath("//img[@src='images/src-embed/bunny.jpg']/../following-sibling::td[1]")).getText().trim();
		String priceValentine = driver.findElement(By.xpath("//img[@src='images/src-embed/valentine.jpg']/../following-sibling::td[1]")).getText().trim();
		
		// Verify the price for each product
		Assertions.assertEquals("$10.99", priceFrog);
		Assertions.assertEquals("$9.99", priceBunny);
		Assertions.assertEquals("$14.99", priceValentine);
		 
		float subtotalF = Float.parseFloat(subtotalFrog);
		float subtotalB = Float.parseFloat(subtotalBunny);
		float subtotalV = Float.parseFloat(subtotalValentine);

		System.out.println ("subtotalFrog: " + subtotalFrog + " subtotalBunny: " + subtotalBunny);
		
		// Verify that total = sum(subTotals)
		float expectedTotal = subtotalF + subtotalB + subtotalV;
		float total = 116.90f;
		Assertions.assertEquals(expectedTotal, total, 0.01);     
    }    
    
	
    //-------------------------------------------------------- lifecycle methods
	@BeforeAll
	static void setup(){
		System.out.println("@BeforeAll");
	    driver = new ChromeDriver();		
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.get(planitURL);
	}

	@BeforeEach
	void setupThis(){
		System.out.println("@BeforeEach");
	}

    @AfterEach
	void tearThis(){
	    driver.manage().deleteAllCookies();
    	System.out.println("@AfterEach");
	}

	@AfterAll
	static void tear(){
		System.out.println("@AfterAll");
	    driver.close();
	}

}
