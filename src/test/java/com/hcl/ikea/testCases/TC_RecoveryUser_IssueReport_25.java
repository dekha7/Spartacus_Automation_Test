package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryUser_IssueReportCompInventory;

public class TC_RecoveryUser_IssueReport_25 extends BaseClass {

//	Recovery user should be able to place issue report successfully
	@Test
	public void compInventIssueReport() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryUser_IssueReportCompInventory ruser= new RecoveryUser_IssueReportCompInventory(driver);
		ruser.searchInManageStockToInventory();
		ruser.issueReport();
	}
}
	

