package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.CommonUserRoles_Report;

public class TC_CommonReport_71 extends BaseClass {


	@Test
	public void UpdateStockInStockCheckInLocation() throws InterruptedException, Exception{

		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		CommonUserRoles_Report ruser= new CommonUserRoles_Report(driver);
		ruser.verifyReport();
   }
}

