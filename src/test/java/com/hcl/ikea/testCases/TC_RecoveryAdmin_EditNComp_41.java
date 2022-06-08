package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryAdmin_ManageStockCompInventory;

public class TC_RecoveryAdmin_EditNComp_41 extends BaseClass {

	@Test
	public void editNComponent()throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_ManageStockCompInventory rm= new RecoveryAdmin_ManageStockCompInventory(driver);
		rm.searchInManageStockToInventory();
		rm.editNComponent();
	}
}
