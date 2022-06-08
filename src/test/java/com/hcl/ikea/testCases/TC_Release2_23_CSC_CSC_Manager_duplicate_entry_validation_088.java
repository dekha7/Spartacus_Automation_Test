package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.Release2_23_CSC_CSC_Manager_duplicate_entry_validation;

public class TC_Release2_23_CSC_CSC_Manager_duplicate_entry_validation_088 extends BaseClass{
//	CSC/CSC Manager duplicate entry validation 
	@Test
	public void firstCSCUserCreateValidation() throws InterruptedException, Exception {
			TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
			login.loginPage();
			log.info("Spartacus application getting login successfully with valid credentials");
			Release2_23_CSC_CSC_Manager_duplicate_entry_validation admin= new Release2_23_CSC_CSC_Manager_duplicate_entry_validation(driver);
			admin.createFirstCSC_Coworker();
			log.info("Creating first CSC user by using user ID: aasri");
			Thread.sleep(2000);
	        admin.setCscUserID(cscUserIDDetail);
	        log.info("User ID got entered successfully");
	        Thread.sleep(1000);
	        admin.setcscUNam(cscUserNameDetail);
	        log.info("user name got entered successfully");
	        Thread.sleep(1000);
	        admin.selectRole();
	        log.info("CSC role got selected successfully from drop down");
	        Thread.sleep(5000);
	        admin.selectLanguage();
	        log.info("English language got selected successfully from drop down");
	        Thread.sleep(1000);
	        admin.submitClick();
	        log.info("Submit button got clicked successfully by user");
	        Thread.sleep(2000);
	        admin.confirmModal();
	        log.info("CSC Manager is successfully able to create first CSC Coworker");
	        Thread.sleep(1000);
	        admin.searchUserID(cscUserIDDetail);
	        log.info("Created CSC user is getting searched by user ID through search filter");
	        Thread.sleep(2000);
	        admin.scrollDownEditBtn1();
	        log.info("CSC User details got validated successfully");
	        admin.createFirstCSC_Coworker();
	        log.info("Logged in as CSC Manager and trying to create second CSC user by using same user ID");
	        Thread.sleep(1000);
	        admin.setCscUserID(cscUserIDDetail);
	        log.info("Same user ID: aasri got enetered successfully");
	        Thread.sleep(1000);
	        admin.setcscUNam(cscUserNameDetail);
	        log.info("Same user name got entered into text field successfully");
	        Thread.sleep(1000);
	        admin.selectRole();
	        log.info("Selecting same CSC user role");
	        Thread.sleep(5000);
	        admin.selectLanguage();
	        Thread.sleep(1000);
	        admin.submitClick();
	        log.info("Trying to submit details of secong CSC user by click on Submit button");
	        Thread.sleep(2000);
	        admin.confirmModal();
	        log.info("CSC Manager is trying to create duplicate CSC Coworker with same user ID");
	        Thread.sleep(1000);
	        admin.messageModalValidation();
	        log.info("CSC Manager is not able to create duplicate CSC Coworker with same user ID");
		}
	}

		