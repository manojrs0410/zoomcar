package org.ZoomCar.testngbase;

import org.ZoomCar.seleniumbase.ZoomCar_SeleniumBase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.ZoomCar_DataInputProvider;

public class ZoomCar_TestNg_Base extends ZoomCar_SeleniumBase {
	
	protected JavascriptExecutor js = (JavascriptExecutor) driver;
	public String excelFileName;
  
    @BeforeMethod
    @Parameters({"ZoomCar"})
    public void beforeMethod(String ZoomCar) {
        invokeApp("firefox", ZoomCar);
    }
    
   @AfterMethod
    public void afterMethod() {
            closeApp();
         }

//    @DataProvider(name="fetchData")
//    public String[][] sendData(){
//    	return ZoomCar_DataInputProvider.getSheet(excelFileName);
}


