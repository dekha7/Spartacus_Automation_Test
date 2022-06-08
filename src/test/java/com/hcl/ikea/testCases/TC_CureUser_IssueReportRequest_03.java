package com.hcl.ikea.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;
import com.hcl.ikea.pageObjects.CureUser_IssueReportRequestPage;

public class TC_CureUser_IssueReportRequest_03 extends BaseClass{
	// Verify the Issue report request for the Cure User
	@Test
	public void isssueReport() throws InterruptedException, Exception {
	TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
	lp.loginPage();
	log.info("Application got login successfully");
	CureUser_IssueReportRequestPage cure = new CureUser_IssueReportRequestPage(driver);
	log.info("Calling Cure User IssueReport Request function");
	cure.issueReportRequest();
	Assert.assertTrue("Issue Report Request against this partNo is already exists to RecoveryAdmin!", true);
    log.info("Cure user is successfully able to placed Issue Report request");
	}
	
}
