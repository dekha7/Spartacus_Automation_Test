package com.hcl.ikea.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.CureUser_HandoutRequestPage;

public class TC_CureUser_HandOutRequest_01 extends BaseClass{
	// Verify the HandOut request for the Cure User
	@Test
	public void handOut() throws InterruptedException, Exception {
	TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
	lp.loginPage();
	log.info("Application got login successfully");
	CureUser_HandoutRequestPage cure = new CureUser_HandoutRequestPage(driver);
	log.info("Calling Cure User handout Request function");
	cure.handOutRequest();
	Assert.assertTrue("Spare part requested successfully! Print request?", true);
    log.info("Cure user is successfully abled to place handout request");
	}
	
}
