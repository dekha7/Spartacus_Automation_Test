package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.Administration_CreateUserPage;

public class TC_Administration_CreateUser_53 extends BaseClass{
	public  static String userid="";
	@Test
	public void adminCreateUser() throws InterruptedException, Exception {
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		Administration_CreateUserPage admin= new Administration_CreateUserPage(driver);
		admin.switchToAdminUserManagement();
		Thread.sleep(2000);
		userid=admin.setUserID();
		Thread.sleep(2000);
        admin.setUserName(recoverManagUserName);
        Thread.sleep(2000);
        admin.selectRole();
        //Thread.sleep(1000);
        admin.selectCountry();
        Thread.sleep(2000);
        admin.selectStoreId();
        Thread.sleep(1000);
        admin.selectLanguage();
        Thread.sleep(1000);
        admin.submitClick();
        Thread.sleep(1000);
        admin.confirmModal();
        Thread.sleep(2000);
        admin.searchUserID(userid);
        log.info("user is getting added sucessfully by Admin");
		}
	}

		