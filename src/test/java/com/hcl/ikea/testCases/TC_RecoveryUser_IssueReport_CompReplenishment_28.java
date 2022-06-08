package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryUser_AddStockCompInventory;
import com.hcl.ikea.pageObjects.RecoveryUser_AddStock_CompReplenishment;
import com.hcl.ikea.pageObjects.RecoveryUser_IssueReport_CompReplenishment;

public class TC_RecoveryUser_IssueReport_CompReplenishment_28 extends BaseClass {

//	Recovery user should be able to placed issue report successfully in component replenishment
	@Test
	public void addStock() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryUser_IssueReport_CompReplenishment ruser= new RecoveryUser_IssueReport_CompReplenishment(driver);
		ruser.searchInManageStockToReplenishment();
		ruser.issueReport();
	}
}
	

