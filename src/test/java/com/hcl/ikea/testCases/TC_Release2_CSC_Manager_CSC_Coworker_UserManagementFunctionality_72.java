package com.hcl.ikea.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.Release2_CSC_Manager_CSC_Coworker_ManagePage;

public class TC_Release2_CSC_Manager_CSC_Coworker_UserManagementFunctionality_72 extends BaseClass{
//	CSC Manager should be able to manager user functionality of CSC_Coworker
	@Test
	public void countryValidation() throws InterruptedException, Exception {
			TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
			login.loginPage();
			Release2_CSC_Manager_CSC_Coworker_ManagePage admin= new Release2_CSC_Manager_CSC_Coworker_ManagePage(driver);
			admin.createCSC_Coworker();
			Thread.sleep(2000);
			//admin.selectCountry();
			 //Thread.sleep(1000);
	        admin.setCscUserID(cscuserID);
	        Thread.sleep(1000);
	        admin.setcscUNam(cscuserName);
	        Thread.sleep(1000);
	        admin.selectRole();
	        Thread.sleep(5000);
	        admin.selectLanguage();
	        Thread.sleep(1000);
	        //admin.submitClick();
	        //Thread.sleep(1000);
	        admin.confirmModal();
	        log.info("CSC Manager is successfully able to create CSC Coworker");
	        Thread.sleep(1000);
	        admin.searchUserID(cscuserID);
	        Thread.sleep(2000);
	        admin.scrollDownEditBtn1();
	        Thread.sleep(3000);
	        admin.setEditUserNameCSC(editCSCUName);
	        Thread.sleep(1000);
	        admin.submitClick();
	        log.info("User name got updated successfully after editing user name");
	        Thread.sleep(2000);
	        admin.confirmUpdateModal();
	        log.info("CSC Manager is successfully able to edit CSC Coworker details");
	        Thread.sleep(4000);
	        admin.searchClearUserID(cscuserID);
	        Thread.sleep(4000); 
	        admin.scrollDownEditBtn2();
	        Thread.sleep(2000);
	        //Assert.assertEquals(admin.filterUserName2.getText(), "ChandraShekharCSCUser");
	        log.info("CSC is successfully able to handle userManagement functionality of CSC Coworker");
	        //Thread.sleep(1000);
	        admin.scrollDownDeleteUserDetails();
	        Thread.sleep(1000);
	        admin.deleteModalOps();
	        log.info("User details got deleted successfully");
		}
	}

		