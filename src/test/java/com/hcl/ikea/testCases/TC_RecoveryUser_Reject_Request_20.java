package com.hcl.ikea.testCases;

import org.testng.annotations.Test;
import com.hcl.ikea.pageObjects.RecoveryUser_RejectRequestPage;

public class TC_RecoveryUser_Reject_Request_20 extends BaseClass{
	// Verify the Reject request for the Recovery User
	@Test
	public void rejectRequest() throws InterruptedException, Exception {	
	TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
	lp.loginPage();
	log.info("Application got login successfully");
	RecoveryUser_RejectRequestPage recovery = new RecoveryUser_RejectRequestPage(driver);
	log.info("Calling Recovery User to reject the requet");
	recovery.rejectRequest();
	//Assert.assertTrue("Partial Exchange Request against this partNo is already exists to RecoveryAdmin!", true);
    log.info("Recovery user is successfully abled to reject the request");
	}
	
}
