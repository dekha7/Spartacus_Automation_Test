package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryAdmin_ManageStockCompReplenishment;

public class TC_ValidateOptionIsEnableToTypeInTheQuantity_85 extends BaseClass {

	@Test
	public void upStockForNon0Stock() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_ManageStockCompReplenishment rm= new RecoveryAdmin_ManageStockCompReplenishment(driver);
		rm.searchInManageStockToReplenishment();
		rm.addStockWithLocationStock();
	}
}
