package com.hcl.ikea.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.Release2_23_As_User_Admin_Able_To_Delete_Users_TestCase_89;

public class TC_Release2_23_User_Admin_Self_User_Deletion_TC_89 extends BaseClass{
//	As a User manager I expect to be able to delete my users --> Test case No.89 
	@Test
	public void firstCSCUserCreateValidation() throws InterruptedException, Exception {
			TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
			login.loginPage();
			log.info("Spartacus application getting login successfully with valid credentials");
			Release2_23_As_User_Admin_Able_To_Delete_Users_TestCase_89 admin= new Release2_23_As_User_Admin_Able_To_Delete_Users_TestCase_89(driver);
			admin.createRecovery_worker();
			log.info("Creating Recovery worker by using user ID: aasri");
			Thread.sleep(2000);
	        admin.setUserAdminID(userIDEEEE);
	        log.info("User ID got entered successfully");
	        Thread.sleep(1000);
	        admin.setUserAdminName(userNAMEEEE);
	        log.info("User name got entered successfully");
	        Thread.sleep(1000);
	        admin.selectRole();
	        log.info("Recovery role got selected successfully from drop down");
	        Thread.sleep(5000);
	        admin.selectCountry();
	        log.info("Counry got selected successfully");
	        Thread.sleep(2000);
	        admin.selectStoreID();
	        log.info("Store ID got selected successfully");
	        Thread.sleep(2000);
	        admin.selectLanguage();
	        log.info("English language got selected successfully from drop down");
	        Thread.sleep(1000);
	        admin.submitClick();
	        log.info("Submit button got clicked successfully by user");
	        Thread.sleep(2000);
	        admin.confirmModal();
	        log.info("User Admin is successfully able to create Recovery worker");
	        Thread.sleep(1000);
	        admin.searchUserAdminName(userNAMEEEE);
	        log.info("Created Recovery user is getting searched by user ID through search filter");
	        Thread.sleep(2000);
	        admin.scrollDownDeleteBtn1();
	        Thread.sleep(6000);
	        admin.deleteRecoveryUser();
	        Thread.sleep(1000);
	        admin.recoverUserDelete();
	        log.info("Recovery User details got deleted successfully");
	        Thread.sleep(6000);
	        admin.searchUserAdminName(userNAMEEEE);
	        log.info("Searching Recovery Role via user name");
	        Thread.sleep(3000);
	        if(admin.recordsMessage.getText().equals("No data available in table")) {
	        	Assert.assertTrue(true);
	        }else {
	        	Assert.assertTrue(false);
	        }
		}
	}

		