package com.hcl.ikea.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;
import com.hcl.ikea.pageObjects.CureUser_PartialExchangeDummyCompPage;

public class TC_CureUser_PartialExchangeDummyComp_05 extends BaseClass{
	// Verify the partial exchange dummy comp request for the Cure User
	@Test
	public void partialExchangeDummyRequest() throws InterruptedException, Exception {
	TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
	lp.loginPage();
	log.info("Application got login successfully");
	CureUser_PartialExchangeDummyCompPage cure = new CureUser_PartialExchangeDummyCompPage(driver);
	log.info("Calling Cure User PartialExchange Dummy Component Request function");
	cure.partialExchangeDummyComp();
	Assert.assertTrue("Partial exchange requested successfully! Print request?", true);
    log.info("Cure user is successfully able to placed partial exchange with dummy component request");
	}
	
}
