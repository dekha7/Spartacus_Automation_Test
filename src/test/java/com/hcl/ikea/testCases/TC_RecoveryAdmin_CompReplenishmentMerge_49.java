package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryAdmin_MergeCompReplenishment;

public class TC_RecoveryAdmin_CompReplenishmentMerge_49  extends BaseClass {
	@Test
	public void linkComponent() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_MergeCompReplenishment rm= new RecoveryAdmin_MergeCompReplenishment(driver);
		rm.searchInManageStockToReplenishment();
		rm.mergeComponent();
	}
}
