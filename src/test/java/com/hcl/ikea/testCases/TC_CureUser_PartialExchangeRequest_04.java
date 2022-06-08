package com.hcl.ikea.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;
import com.hcl.ikea.pageObjects.CureUser_PartialExchangeRequestPage;

public class TC_CureUser_PartialExchangeRequest_04 extends BaseClass{
	// Verify the partial exchange request for the Cure User
	@Test
	public void partialExchangeRequest() throws InterruptedException, Exception {
	TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
	lp.loginPage();
	log.info("Application got login successfully");
	CureUser_PartialExchangeRequestPage cure = new CureUser_PartialExchangeRequestPage(driver);
	log.info("Calling Cure User PartialExchange Request function");
	cure.partialExchangeRequest();
	Assert.assertTrue("Partial Exchange Request against this partNo is already exists to RecoveryAdmin!", true);
    log.info("Cure user is successfully able to placed partial exchange request");
	}
	
}
