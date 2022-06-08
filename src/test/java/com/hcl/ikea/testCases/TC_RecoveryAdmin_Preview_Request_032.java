package com.hcl.ikea.testCases;

import java.rmi.server.RMIClassLoader;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryAdmin_Accept_Request_Page;
import com.hcl.ikea.pageObjects.RecoveryAdmin_Preview_Request_Page;

public class TC_RecoveryAdmin_Preview_Request_032 extends BaseClass {

	
	@Test
	public void recoveryAdminPreviewRequest()throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_Preview_Request_Page rR= new RecoveryAdmin_Preview_Request_Page(driver);
		rR.clickOnRequest();
		rR.recoveryAdminPreviewRequest();
		Thread.sleep(2000);
		Assert.assertTrue(true);
	}
}
