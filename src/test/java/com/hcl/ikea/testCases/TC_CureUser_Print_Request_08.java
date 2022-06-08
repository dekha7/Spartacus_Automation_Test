package com.hcl.ikea.testCases;

import org.testng.annotations.Test;
import com.hcl.ikea.pageObjects.CureUser_PrintRequestPage;

public class TC_CureUser_Print_Request_08 extends BaseClass{
	// Verify the print request for the Cure User
	@Test
	public void printRequest() throws InterruptedException, Exception {
	TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
	lp.loginPage();
	log.info("Application got login successfully");
	CureUser_PrintRequestPage cure = new CureUser_PrintRequestPage(driver);
	log.info("Calling Cure User to print the requet");
	cure.printRequest();
	//Assert.assertTrue("Partial Exchange Request against this partNo is already exists to RecoveryAdmin!", true);
    log.info("Cure user is successfully able to print the request");
	}
	
}
