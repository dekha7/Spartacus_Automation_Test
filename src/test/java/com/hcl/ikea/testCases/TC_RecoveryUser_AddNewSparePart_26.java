package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.RecoveryUser_AddNewSparePart_CompInventory;

public class TC_RecoveryUser_AddNewSparePart_26 extends BaseClass {

//	Recovery user should be able to add new spare part successfully
	@Test
	public void compInventAddNewSpareParts() throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
     	RecoveryUser_AddNewSparePart_CompInventory ruser= new RecoveryUser_AddNewSparePart_CompInventory(driver);
		ruser.searchInManageStockToInventory();
		ruser.addNewSparePart();
		
	}
}
	

