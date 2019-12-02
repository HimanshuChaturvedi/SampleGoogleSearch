package com.google.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.qa.base.TestBase;

public class FirstPage extends TestBase {
	
	// Object Repository
	@FindBy(name="q")
	WebElement search;
	
	@FindBy(name="btnK")
	WebElement searchbutton;
	
	//Initializing page Objects
    
	public FirstPage() {
		PageFactory.initElements(driver, this);
		
		
	}
	
	//Actions
    
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public void enterText(String txt) {
		search.sendKeys(txt);
		searchbutton.click();
	}
}
