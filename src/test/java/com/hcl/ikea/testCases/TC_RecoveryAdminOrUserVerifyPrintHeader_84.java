package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryUserOrAdminClearStockScreen_PrintHeader;

public class TC_RecoveryAdminOrUserVerifyPrintHeader_84 extends BaseClass{

	@Test
	public void validateAddLabel() throws InterruptedException, Exception {
		TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
		lp.loginPage();
		RecoveryUserOrAdminClearStockScreen_PrintHeader print= new RecoveryUserOrAdminClearStockScreen_PrintHeader(driver);
		print.validatePrint();

  }
}
