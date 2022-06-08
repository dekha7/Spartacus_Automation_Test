package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryUser_CancelRequestPage;

public class TC_RecoveryUser_Cancel_Request_19 extends BaseClass{
	// Verify the cancel request for the Recovery User
	@Test
	public void cancelRequest() throws InterruptedException, Exception {
	TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
	lp.loginPage();
	log.info("Application got login successfully");
	RecoveryUser_CancelRequestPage cure = new RecoveryUser_CancelRequestPage(driver);
	log.info("Calling Recovery User to cancel the requet");
	cure.cancelRequest();
	//Assert.assertTrue("Partial Exchange Request against this partNo is already exists to RecoveryAdmin!", true);
    log.info("Recovery user is successfully able to cancel the request");
	}
	
}
