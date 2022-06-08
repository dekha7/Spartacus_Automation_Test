package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryUserOrAdminClearStockScreen_RemoveStockLocation;

public class TC_ValidateRemoveStockLocationButtonIsVisible_74 extends BaseClass{

	@Test
	public void validateAddLabel() throws InterruptedException, Exception {
		TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
		lp.loginPage();
		RecoveryUserOrAdminClearStockScreen_RemoveStockLocation obj= new RecoveryUserOrAdminClearStockScreen_RemoveStockLocation(driver);
		obj.validateRemoveStockLocation();
	}
}
