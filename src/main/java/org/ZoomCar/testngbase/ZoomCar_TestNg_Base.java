package org.Amazon.testngbase;

import org.Amazon.seleniumbase.Amazon_SeleniumBase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.Amazon_DataInputProvider;

public class Amazon_TestNg_Base extends Amazon_SeleniumBase {
	
	protected JavascriptExecutor js = (JavascriptExecutor) driver;
	public String excelFileName;
  
    @BeforeMethod
    @Parameters({"Amazon"})
    public void beforeMethod(String Amazon) {
        invokeApp("chrome", Amazon);
    }
    
   @AfterMethod
    public void afterMethod() {
            closeApp();
         }

    @DataProvider(name="fetchData")
    public String[][] sendData(){
    	return Amazon_DataInputProvider.getSheet(excelFileName);
}
}

