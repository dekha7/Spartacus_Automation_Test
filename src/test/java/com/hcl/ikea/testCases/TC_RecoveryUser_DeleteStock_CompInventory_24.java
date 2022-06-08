package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryUser_DeleteStockCompInventory;

public class TC_RecoveryUser_DeleteStock_CompInventory_24 extends BaseClass {

//	Recovery user should be able to delete stock successfully
	@Test
	public void deleteStock() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryUser_DeleteStockCompInventory ruser= new RecoveryUser_DeleteStockCompInventory(driver);
		ruser.searchInManageStockToInventory();
		ruser.deleteStock();
	}
}
	

