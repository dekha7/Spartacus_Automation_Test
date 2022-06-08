package com.hcl.ikea.testCases;

import org.testng.annotations.Test;
import com.hcl.ikea.pageObjects.RecoveryAdmin_Cancel_Request_Page;

public class TC_RecoveryAdmin_Cancel_Request_031 extends BaseClass {

	
	@Test
	public void cancelRequest()throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_Cancel_Request_Page rR= new RecoveryAdmin_Cancel_Request_Page(driver);
		rR.clickOnRequest();
		Thread.sleep(1000);
		rR.recoveryAdminCancelRequest();
	}
}
