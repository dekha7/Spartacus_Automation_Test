package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.CureUser_CancelRequestPage;

public class TC_CureUser_Cancel_Request_07 extends BaseClass{
	// Verify the Cancel request for the Cure User
	@Test
	public void cancelRequest() throws InterruptedException, Exception {
	TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
	lp.loginPage();
	log.info("Application got login successfully");
	CureUser_CancelRequestPage cure = new CureUser_CancelRequestPage(driver);
	log.info("Calling Cure User to cancel the requet");
	cure.cancelRequest();
	//Assert.assertTrue("Partial Exchange Request against this partNo is already exists to RecoveryAdmin!", true);
    log.info("Cure user is successfully abled to cancelled the request");
	}
	
}
