package org.ZoomCar.testcases;

import org.ZoomCar.pages.ZoomCar_HomeWindow;
import org.ZoomCar.testngbase.ZoomCar_TestNg_Base;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ZoomCar_TestCase01 extends ZoomCar_TestNg_Base{
	@BeforeTest
	public void setValues() {
		
		testCaseName = "ZoomCar_TestCase01";
        testDescription = "ZoomCar testCase ";
        nodes = "Car Module";
        authors = "Manojkumar";
        category = "Smoke";
	}

	@Test
	public void ZoomCar_HomeWindow() throws InterruptedException {
	
	new ZoomCar_HomeWindow(driver)
	
			.mouseHoverLocation()
			.clickSecondLocation()
			.clickStartDateOfNextMonth()
			.clickEndDateOfNextMonth()
			.moveStartAndEndSlider()
			.clickSearchButton()
			.clickBestRated()
			.clickFuelTypePetrol()
			.clickFastTag()
			.printNewlyAddedCarNames()
			.selectMaxUserRatingCar()
			.clickImageNavigationButton();

         
}
	}
