package com.hcl.ikea.testCases;

import org.testng.annotations.Test;
import com.hcl.ikea.pageObjects.RecoveryAdmin_Request;

public class TC_RecoveryAdminRequest_005 extends BaseClass {

	
	@Test
	public void cancelRequest()throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_Request rR= new RecoveryAdmin_Request(driver);
		rR.clickOnRequest();
		rR.cancelRequest();
	}
}
