package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryAdmin_Accept_Request_Page;

public class TC_RecoveryAdmin_Accept_Request_030 extends BaseClass {

	
	@Test
	public void recoveryAdminAcceptRequest()throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_Accept_Request_Page rR= new RecoveryAdmin_Accept_Request_Page(driver);
		rR.clickOnRequest();
		rR.recoveryAdminAcceptRequest();
	}
}
