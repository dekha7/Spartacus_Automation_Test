package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.Recovery_Request;

public class TC_RecoveryRequest extends BaseClass{

//	@Test
//	public void cancelRequest()throws InterruptedException, Exception{
//		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
//		login.loginPage();
//		Recovery_Request rR= new Recovery_Request(driver);
//		rR.switchToRecoveryAndClickOnRequest();
//		rR.cancelRequest();
//	}
	
//	@Test
//	public void acceptRequest()throws InterruptedException, Exception{
//		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
//		login.loginPage();
//		Recovery_Request rR= new Recovery_Request(driver);
//		rR.switchToRecoveryAndClickOnRequest();
//		rR.acceptRequest();
//	}

//@Test
//public void rejectRequest()throws InterruptedException, Exception{
//	TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
//	login.loginPage();
//	Recovery_Request rR= new Recovery_Request(driver);
//	rR.switchToRecoveryAndClickOnRequest();
//	rR.rejectRequest();
//}
//*/
@Test
public void previewRequest()throws InterruptedException, Exception{
	TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
	login.loginPage();
	Recovery_Request rR= new Recovery_Request(driver);
	rR.switchToRecoveryAndClickOnRequest();
	rR.previewRequest();
}
}
