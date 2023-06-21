package org.Amazon.testcases;

import org.Amazon.pages.Amazon_HomeWindow;
import org.Amazon.testngbase.Amazon_TestNg_Base;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazon_TestCase01 extends Amazon_TestNg_Base{
	@BeforeTest
	public void setValues() {
		excelFileName = "AmazonData";
		testCaseName = "Amazon_TestCase01";
        testDescription = "Mobile testCase ";
        nodes = "Add to Cart Module";
        authors = "Manojkumar";
        category = "Smoke";
	}

	@Test(dataProvider="fetchData")
	public void loginToUIPath(String userName, String password) throws InterruptedException {
		
		new Amazon_HomeWindow(driver)
	
			.enterMobileName()
			.pressEnterKey()
			.clickFirstMobileImage();

         
}
	}
