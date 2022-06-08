package com.hcl.ikea.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.CSCUser_HandoutRequestPage;
//import com.hcl.ikea.pageObjects.CureUser_HandoutRequestPage;

public class TC_CSCUser_HandOutRequest_010 extends BaseClass{
	// Verify the HandOut request for the Cure User
	@Test
	public void cscUserhandOut() throws InterruptedException, Exception {
	TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
	lp.loginPage();
	log.info("Application got login successfully");
	CSCUser_HandoutRequestPage csc = new CSCUser_HandoutRequestPage(driver);
	log.info("Calling Cure User handout Request function");
	csc.cscUserhandOutRequest();
	Assert.assertTrue("Are You Sure You want to perform this action ?", true);
    log.info("CSC user is successfully abled to place handout request");
	}
	
}
