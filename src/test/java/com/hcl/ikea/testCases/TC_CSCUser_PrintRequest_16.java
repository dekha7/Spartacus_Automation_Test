package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.CSCUser_PrintRequestPage;

public class TC_CSCUser_PrintRequest_16 extends BaseClass{

	@Test
	public void printRequest()throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		CSCUser_PrintRequestPage cr= new CSCUser_PrintRequestPage(driver);
		cr.printRequestMethod();
	}
}
