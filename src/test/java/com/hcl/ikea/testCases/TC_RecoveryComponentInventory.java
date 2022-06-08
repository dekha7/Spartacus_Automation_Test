package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.Recovery_ManageStockCompInventory;

public class TC_RecoveryComponentInventory extends BaseClass{

	@Test
	public void addStock() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		Recovery_ManageStockCompInventory rm= new Recovery_ManageStockCompInventory(driver);
		rm.switchToRecoverySearchInManageStockToInventory();	
		rm.addStock();	
	}
	@Test
	public void deleteStock() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		Recovery_ManageStockCompInventory rm= new Recovery_ManageStockCompInventory(driver);
		rm.switchToRecoverySearchInManageStockToInventory();	
		rm.deleteStock();
   }
	@Test
	public void issueReport() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		Recovery_ManageStockCompInventory rm= new Recovery_ManageStockCompInventory(driver);
		rm.switchToRecoverySearchInManageStockToInventory();	
		rm.issueReport();
	}
	@Test
	public void addNewSparePart() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		Recovery_ManageStockCompInventory rm= new Recovery_ManageStockCompInventory(driver);
		rm.switchToRecoverySearchInManageStockToInventory();	
		rm.addNewSparePart();
	}
	@Test
	public void deleteNComponent()throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		Recovery_ManageStockCompInventory rm= new Recovery_ManageStockCompInventory(driver);
		rm.switchToRecoverySearchInManageStockToInventory();
//		rm.deleteNComp();
	}
	@Test
	public void piaFact() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		Recovery_ManageStockCompInventory rm= new Recovery_ManageStockCompInventory(driver);
		rm.switchToRecoverySearchInManageStockToInventory();
		rm.piaFact();
	}
}
