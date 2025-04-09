/**
 * 
 */
package com.funnygorilla.pageobjectpattern.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

/**
 * create a base page class that encapsulates the common logic for all the page classes.
 * @author guson
 *
 */
public class BasePage {
	
    public BasePage() {
    }

    public void visit(String url) {  
        SeleniumSupport.getInstance().visit(url);
    }

    public void click(WebElement element) {
    	element.click();
    }

    public void type(WebElement element, String text) {
    	element.sendKeys(text);    	
    }

    public void quit () {
    	SeleniumSupport.getInstance().quit();
    }
    
    public boolean isDisplayed(WebElement element) {  
        try {
        	SeleniumSupport.getInstance().isDisplayed(element);
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }   
}
