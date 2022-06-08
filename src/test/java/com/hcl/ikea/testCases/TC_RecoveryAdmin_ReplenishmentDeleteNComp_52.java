package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryAdmin_ManageStockCompReplenishment;

public class TC_RecoveryAdmin_ReplenishmentDeleteNComp_52 extends BaseClass{

	@Test
	public void deleteNcomponent() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_ManageStockCompReplenishment rm= new RecoveryAdmin_ManageStockCompReplenishment(driver);
		rm.searchInManageStockToReplenishment();
		rm.deleteNComp();
   }
}
