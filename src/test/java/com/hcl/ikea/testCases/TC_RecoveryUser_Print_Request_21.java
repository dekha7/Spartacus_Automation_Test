package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryUser_PrintRequestPage;

public class TC_RecoveryUser_Print_Request_21 extends BaseClass{
	// Verify the print request for the Recovery User
	@Test
	public void printRequest() throws InterruptedException, Exception {
	TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
	lp.loginPage();
	log.info("Application got login successfully");
	RecoveryUser_PrintRequestPage recovery = new RecoveryUser_PrintRequestPage(driver);
	log.info("Calling Recovery User to print the requet");
	recovery.printRequest();
	//Assert.assertTrue("Partial Exchange Request against this partNo is already exists to RecoveryAdmin!", true);
    log.info("Recovery user is successfully able to print the request");

	}
	
}
