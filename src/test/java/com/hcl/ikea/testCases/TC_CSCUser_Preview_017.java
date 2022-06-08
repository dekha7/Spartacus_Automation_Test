package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.CSCUser_PreviewRequest;

public class TC_CSCUser_Preview_017 extends BaseClass {

	
	@Test
	public void previewRequest()throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		CSCUser_PreviewRequest cr= new CSCUser_PreviewRequest(driver);
		cr.previewRequest();
	}
}
