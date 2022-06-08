package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryAdmin_RemoveCompFromLocation;

public class TC_RecoveryAdmin_RemoveCompFromLocation_69 extends BaseClass{

	@Test
	public void RemoveCompFromLocation() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_RemoveCompFromLocation rm= new RecoveryAdmin_RemoveCompFromLocation(driver);
		rm.clickOnTheLocation();	
		rm.VerifyStoreNumbersINLocation();
		rm.VerifyRemoveFirstComp();
		
	}
}
