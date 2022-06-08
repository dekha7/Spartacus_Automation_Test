package com.hcl.ikea.testCases;


import org.testng.annotations.Test;
import com.hcl.ikea.pageObjects.CureUser_SearchOrderRequestPage;

public class TC_CureUser_SearchOrderRequestPage_06 extends BaseClass{
	// Verify the track order request for the Cure User
	@Test
	public void trackOrder() throws InterruptedException, Exception {
	TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
	lp.loginPage();
	log.info("Application got login successfully");
	CureUser_SearchOrderRequestPage cure = new CureUser_SearchOrderRequestPage(driver);
	log.info("Calling Cure User Track Order function");
	cure.trackOrderRequest("1360620");
	//Assert.assertTrue("Partial Exchange Request against this partNo is already exists to RecoveryAdmin!", true);
    log.info("Cure user is successfully able to track order request");
	}
	
}
