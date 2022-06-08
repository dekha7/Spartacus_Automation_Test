package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.CureUser_IcompRequestPage;

public class TC_CureUser_IcompRequest_02 extends BaseClass{
	// Verify the Icomp request for the Cure User
	@Test
	public void iCompRequest() throws InterruptedException, Exception {
	TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
	lp.loginPage();
	log.info("Application got login successfully");
	CureUser_IcompRequestPage cure = new CureUser_IcompRequestPage(driver);
	log.info("Calling Cure User iComp Request function");
	cure.iCompRequest();
	//Assert.assertTrue("Spare part requested successfully! Print request?", true);
    log.info("Cure user is successfully able to placed iComp request");
	}
	
}
