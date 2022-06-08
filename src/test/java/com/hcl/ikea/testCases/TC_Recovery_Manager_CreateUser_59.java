package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.Recovery_Manager_CreateUserPage;

public class TC_Recovery_Manager_CreateUser_59 extends BaseClass{
	public  static String selectedCountry="";
	public  static String userid="";
	public static String selectedStoreId="";
//	Recovery user should be able to add stock successfully
	@Test
	public void createUser() throws InterruptedException, Exception {
			TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
			login.loginPage();
			Recovery_Manager_CreateUserPage admin= new Recovery_Manager_CreateUserPage(driver);
			admin.switchToRecoveryManager();
			Thread.sleep(2000);
			selectedCountry=admin.selectCountry();
			Thread.sleep(2000);
			selectedStoreId=admin.selectStoreId();
			userid=admin.setRMUserID();
			System.out.println("the country,storeid,userid to be created is : "+selectedCountry+" "+selectedStoreId+" "+ userID);
			Thread.sleep(2000);
	        admin.setRMUNam(recoverManagUserName);
	        Thread.sleep(2000);
	        admin.selectRole();
	        //Thread.sleep(1000);
	        //admin.selectCountry();
	        Thread.sleep(2000);
	        admin.selectStoreID(selectedStoreId);
	        Thread.sleep(1000);
	        admin.selectLanguage();
	        Thread.sleep(1000);
	        admin.submitClick();
	        Thread.sleep(1000);
	        admin.confirmModal();
	        Thread.sleep(2000);
	        admin.searchUserID(userid);
	        log.info("user is getting added sucessfully by Recovery Manager");
		}
	}

		