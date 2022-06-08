package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.CSCUser_CancelRequest;

public class TC_CSCUser_CancelRequest_15 extends BaseClass{

	@Test
	public void cancelRequest()throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		CSCUser_CancelRequest cr= new CSCUser_CancelRequest(driver);
		cr.cancelRequest();
	}
}
