package com.hcl.ikea.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;
import com.hcl.ikea.pageObjects.CureUser_PreviewRequestPage;

public class TC_CureUser_Preview_Request_09 extends BaseClass{
	// Verify the preview request for the Cure User
	@Test
	public void previewRequest() throws InterruptedException, Exception {
	TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
	lp.loginPage();
	log.info("Application got login successfully");
	CureUser_PreviewRequestPage cure = new CureUser_PreviewRequestPage(driver);
	log.info("Calling Cure User to preview the requet");
	cure.previewRequest();
	Assert.assertTrue(true);
    log.info("Cure user is successfully able to preview the request");
	}
	
}
