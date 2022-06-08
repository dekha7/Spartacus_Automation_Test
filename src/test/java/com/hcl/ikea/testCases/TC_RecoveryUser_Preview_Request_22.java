package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryUser_PreviewRequestPage;

public class TC_RecoveryUser_Preview_Request_22 extends BaseClass{
	// Verify the preview request for the Recovery User
	@Test
	public void previewRequest() throws InterruptedException, Exception {
		TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
	lp.loginPage();
	log.info("Application got login successfully");
	RecoveryUser_PreviewRequestPage recovery = new RecoveryUser_PreviewRequestPage(driver);
	log.info("Calling Recovery User to preview the requet");
	recovery.previewRequest();
    log.info("Recovery user is successfully able to preview the request");
	}
	
}
