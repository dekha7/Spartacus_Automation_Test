package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryUser_AddStockCompInventory;

public class TC_RecoveryUser_AddStock_CompInventory_23 extends BaseClass {

//	Recovery user should be able to add stock successfully
	@Test
	public void addStock() throws InterruptedException, Exception{

		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryUser_AddStockCompInventory ruser= new RecoveryUser_AddStockCompInventory(driver);
		ruser.searchInManageStockToInventory();
		ruser.addStock();
		
	}
}
	

