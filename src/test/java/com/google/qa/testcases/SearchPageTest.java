package com.google.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.qa.base.TestBase;
import com.google.qa.pages.FirstPage;
import com.google.qa.util.TestUtil;

public class SearchPageTest extends TestBase {
	
	FirstPage page;
	String sheetname="diffkeyword";
	
	public SearchPageTest() {
		super();
	}
	
	@BeforeMethod
	
	public void setUp() {
		
		initialization();
		page=new FirstPage();
		
	}
	
	
	//Testcases should be separated and independent with each other
	//before each testcase launch the browser and login
	//@test--execute your testcase
	//After each testcase close the browser
	
	@Test(priority=1)
	public void validateHomePageTitleTest() {
		String title=page.validateHomePageTitle();
		Assert.assertEquals(title, "Google");
	}
	
	@DataProvider
	
	public Object[][] getgoogleTestData() {
		Object data[][]=TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=2,dataProvider="getgoogleTestData")
	
	public void firstPageTest(String SearchTitle) {
		
		page.enterText(SearchTitle);
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}
				
	

}
