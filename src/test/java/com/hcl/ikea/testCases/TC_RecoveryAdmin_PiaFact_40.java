package com.hcl.ikea.testCases;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryAdmin_ManageStockCompInventory;
import com.hcl.ikea.testCases.BaseClass;
import com.hcl.ikea.testCases.TC_LoginPageTest_001;

public class TC_RecoveryAdmin_PiaFact_40 extends BaseClass{

	@Test
	public void piaFact() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_ManageStockCompInventory rm= new RecoveryAdmin_ManageStockCompInventory(driver);
		rm.searchInManageStockToInventory();
		rm.piaFact();
	}
}
