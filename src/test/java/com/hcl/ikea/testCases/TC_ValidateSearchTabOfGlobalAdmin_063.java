package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.GlobalAdmin_ValidateSearchTab;

public class TC_ValidateSearchTabOfGlobalAdmin_063 extends BaseClass{
	// Verify the Reject request for the Recovery User
	@Test
	public void validateSearchTab() throws InterruptedException, Exception {
		TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
		lp.loginPage();
		GlobalAdmin_ValidateSearchTab calSearchGlobalAdmin= new GlobalAdmin_ValidateSearchTab(driver);
		calSearchGlobalAdmin.validateSearchTabGlobalAdmin();
	}

}
