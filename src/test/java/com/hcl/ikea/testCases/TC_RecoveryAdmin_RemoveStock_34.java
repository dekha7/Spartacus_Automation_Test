package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryAdmin_ManageStockCompInventory;

public class TC_RecoveryAdmin_RemoveStock_34 extends BaseClass {

	
	@Test
	public void recoveryAdminRemoveStock() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_ManageStockCompInventory rm= new RecoveryAdmin_ManageStockCompInventory(driver);
		rm.searchInManageStockToInventory();	
		rm.removeStock();
   }
   
}
