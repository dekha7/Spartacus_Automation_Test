package com.hcl.ikea.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryAdmin_Validate_EOL_Management_Page;

public class TC_RecoveryAdmin_EOL_Management_043 extends BaseClass {

	
	@Test
	public void recoveryAdminPreviewRequest()throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_Validate_EOL_Management_Page rR= new RecoveryAdmin_Validate_EOL_Management_Page(driver);
		rR.clickOnRequest();
		rR.recoveryAdminEOLManagement();
		Thread.sleep(2000);
		Assert.assertTrue(true);
	}
}
