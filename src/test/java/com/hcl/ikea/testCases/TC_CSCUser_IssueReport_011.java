package com.hcl.ikea.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.CSCUser_IssueReport;

public class TC_CSCUser_IssueReport_011 extends BaseClass {
	@Test
	public void cscIssueReport() throws InterruptedException, Exception {
	TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
	lp.loginPage();
	log.info("Application got login successfully");
	CSCUser_IssueReport cscIssue = new CSCUser_IssueReport(driver);
	log.info("Calling Cure User issue Report function");
	cscIssue.cscIssueReport();
	Assert.assertTrue("Are You Sure You want to perform this action ?", true);
    log.info("CSC user is successfully abled to place issue report");
    
 }
}
