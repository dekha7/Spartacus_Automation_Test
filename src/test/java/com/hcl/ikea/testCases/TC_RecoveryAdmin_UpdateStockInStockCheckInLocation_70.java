package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryAdmin_UpdateStockInStockCheckInLocation;

public class TC_RecoveryAdmin_UpdateStockInStockCheckInLocation_70 extends BaseClass{

	@Test
	public void UpdateStockInStockCheckInLocation() throws InterruptedException, Exception{

		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_UpdateStockInStockCheckInLocation ruser= new RecoveryAdmin_UpdateStockInStockCheckInLocation(driver);
		ruser.clickOnTheLocation();
		ruser.verifyStockChkBtnAndUnFlagLocations();
		ruser.verifyUpdateStockFor1stLocation();
	}
}
