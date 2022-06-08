package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryUserOrAdminClearStockScreen_ValidateAddLabel;

public class TC_ValidateAddLabelToSelectAllInClearStockScreen_73 extends BaseClass{

	@Test
	public void validateAddLabel() throws InterruptedException, Exception {
		TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
		lp.loginPage();
		RecoveryUserOrAdminClearStockScreen_ValidateAddLabel obj = new RecoveryUserOrAdminClearStockScreen_ValidateAddLabel(driver);
		obj.validateAddLabel();
	}
}
