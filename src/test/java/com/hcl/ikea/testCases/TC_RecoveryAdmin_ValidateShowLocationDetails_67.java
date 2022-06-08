package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryAdmin_ValidateShowLocationDetails;

public class TC_RecoveryAdmin_ValidateShowLocationDetails_67 extends BaseClass {

	@Test
	public void ValidateShowLocationDetails() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_ValidateShowLocationDetails rm= new RecoveryAdmin_ValidateShowLocationDetails(driver);
		rm.clickOnTheLocation();	
		rm.VerifyStoreNumbersINLocation();		
	}
}
