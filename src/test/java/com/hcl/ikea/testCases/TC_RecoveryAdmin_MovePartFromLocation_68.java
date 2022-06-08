package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryAdmin_MoveCompFromLocation;

public class TC_RecoveryAdmin_MovePartFromLocation_68 extends BaseClass{
	@Test
	public void movePartFromLocation() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_MoveCompFromLocation rm= new RecoveryAdmin_MoveCompFromLocation(driver);
		rm.clickOnTheLocation();	
		rm.VerifyStoreNumbersINLocation();	
		rm.verifyMoveFirstComp();
	}
}
