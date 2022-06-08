package com.hcl.ikea.testCases;


import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.CSCUser_SearchOrderRequest;

public class TC_CSCUser_SearchOrderRequest_014 extends BaseClass{
	// Verify the track order request for the Cure User
	@Test
	public void trackOrder() throws InterruptedException, Exception {
	TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
	lp.loginPage();
	log.info("Application got login successfully");
	CSCUser_SearchOrderRequest cure = new CSCUser_SearchOrderRequest(driver);
	log.info("Calling CSC User Search Order Request function");
	cure.searchOrderRequest("1360620");
	//Assert.assertTrue("Partial Exchange Request against this partNo is already exists to RecoveryAdmin!", true);
    log.info("CSC user is successfully able to search order request");
	}
	
}
