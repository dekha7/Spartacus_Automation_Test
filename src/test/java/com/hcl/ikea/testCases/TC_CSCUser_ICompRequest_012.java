package com.hcl.ikea.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.CSCUser_ICompRequestPage;
//import com.hcl.ikea.pageObjects.CureUser_HandoutRequestPage;

public class TC_CSCUser_ICompRequest_012 extends BaseClass{
	@Test
	public void cscICompRequest() throws InterruptedException, Exception {
	TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
	lp.loginPage();
	log.info("Application got login successfully");
	CSCUser_ICompRequestPage cure = new CSCUser_ICompRequestPage(driver);
	log.info("Calling CSC User IComp Request function");
	cure.cscICompRequest();
	Assert.assertTrue("Are You Sure You want to perform this action ?", true);
    log.info("CSC user is successfully abled to place iComp request");
	}
	
}


