package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryAdmin_MergeCompInventory;

public class TC_RecoveryAdmin_Merge_46  extends BaseClass {
	@Test
	public void linkComponent() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_MergeCompInventory rm= new RecoveryAdmin_MergeCompInventory(driver);
		rm.searchInManageStockToInventory();
		rm.mergeComponent();
	}
}
