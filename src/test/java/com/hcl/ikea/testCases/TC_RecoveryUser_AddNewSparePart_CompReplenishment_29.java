package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryUser_AddNewSparePart_CompReplenishment;

public class TC_RecoveryUser_AddNewSparePart_CompReplenishment_29 extends BaseClass {

//	Recovery user should be able to add new spare part successfully in component replenishment
	@Test
	public void addStock() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryUser_AddNewSparePart_CompReplenishment ruser= new RecoveryUser_AddNewSparePart_CompReplenishment(driver);
		ruser.searchInManageStockToReplenishment();
		ruser.addNewSparePart();

	}
}
	

