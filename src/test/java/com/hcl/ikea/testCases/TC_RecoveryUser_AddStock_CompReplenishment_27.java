package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryUser_AddStock_CompReplenishment;

public class TC_RecoveryUser_AddStock_CompReplenishment_27 extends BaseClass {

//	Recovery user should be able to add stock successfully
	@Test
	public void addStock() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryUser_AddStock_CompReplenishment ruser= new RecoveryUser_AddStock_CompReplenishment(driver);
		ruser.searchInManageStockToReplenishment();
		ruser.addStockFor0Stock();
		ruser.addStockForNon0Stock();
	}
}
	

