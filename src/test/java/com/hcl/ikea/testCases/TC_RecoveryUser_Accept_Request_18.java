package com.hcl.ikea.testCases;

import org.testng.annotations.Test;
import com.hcl.ikea.pageObjects.RecoveryUser_AcceptRequestPage;

public class TC_RecoveryUser_Accept_Request_18 extends BaseClass{
	// Verify the accept request for the Recovery User
	@Test
	public void recoveryUserAcceptRequest() throws InterruptedException, Exception {
	TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
	lp.loginPage();
	log.info("Application got login successfully");
	RecoveryUser_AcceptRequestPage cure = new RecoveryUser_AcceptRequestPage(driver);
	log.info("Calling Recovery User to accept the requet");
	cure.acceptRequest();
	//Assert.assertTrue("Partial Exchange Request against this partNo is already exists to RecoveryAdmin!", true);
    log.info("Recovery user is successfully able to accept the request");
	}
	
}
