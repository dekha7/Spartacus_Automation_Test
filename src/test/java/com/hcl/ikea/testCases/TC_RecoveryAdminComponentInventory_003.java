package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryAdmin_ManageStockCompInventory;

public class TC_RecoveryAdminComponentInventory_003 extends BaseClass {

//	Recovery admin user should be able to validate the linking of components in component inventory.
	/*
	@Test
	public void linkComponent() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_ManageStockCompInventory rm= new RecoveryAdmin_ManageStockCompInventory(driver);
		rm.searchInManageStockToInventory();
		rm.linkComponent();
	}
	
//	Recovery admin user should be able to validate the unlinking of components in component inventory.
	@Test
	public void unLinkComponent() throws InterruptedException, Exception{
	    TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_ManageStockCompInventory rm= new RecoveryAdmin_ManageStockCompInventory(driver);
		rm.searchInManageStockToInventory();
		rm.unLinkComponent();	
	}
	*/
/*
	@Test
	public void mergeComponent() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_ManageStockCompInventory rm= new RecoveryAdmin_ManageStockCompInventory(driver);
		rm.searchInManageStockToInventory();
	}
		
//	Recovery admin user should be able to add stock successfully
	@Test
	public void addStock() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_ManageStockCompInventory rm= new RecoveryAdmin_ManageStockCompInventory(driver);
		rm.searchInManageStockToInventory();	
		rm.addStock();	
	}
	
	
//	Recovery admin user should be able to delete stock successfully
	@Test
	public void deleteStock() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_ManageStockCompInventory rm= new RecoveryAdmin_ManageStockCompInventory(driver);
		rm.searchInManageStockToInventory();	
		rm.deleteStock();
   }
   
	
//	Recovery admin user should be able to place issue report request successfully
	@Test
	public void issueReport() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_ManageStockCompInventory rm= new RecoveryAdmin_ManageStockCompInventory(driver);
		rm.searchInManageStockToInventory();	
		rm.issueReport();
	}
	
	
//	Recovery admin user should be able to add new spare part successfully
	@Test
	public void addNewSparePart() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_ManageStockCompInventory rm= new RecoveryAdmin_ManageStockCompInventory(driver);
		rm.searchInManageStockToInventory();	
		rm.addNewSparePart();
	}
	
	
//	Recovery admin user should be able to edit the details of the N component
	@Test
	public void editNComponent()throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_ManageStockCompInventory rm= new RecoveryAdmin_ManageStockCompInventory(driver);
		rm.searchInManageStockToInventory();
		rm.editNComponent();
	}
	*/
	
//	Recovery admin user should be able to delete the N component
	@Test
	public void deleteNComponent()throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_ManageStockCompInventory rm= new RecoveryAdmin_ManageStockCompInventory(driver);
		rm.searchInManageStockToInventory();
		rm.deleteNComp();
	}
	/*
	
//	Recovery admin user will be able to open the pia fact webpage from component Inventory
	@Test
	public void piaFact() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		RecoveryAdmin_ManageStockCompInventory rm= new RecoveryAdmin_ManageStockCompInventory(driver);
		rm.searchInManageStockToInventory();
		rm.piaFact();
	}
*/
}
	

