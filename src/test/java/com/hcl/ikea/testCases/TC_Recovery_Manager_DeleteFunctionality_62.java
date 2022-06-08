package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.Recovery_Manager_DeleteFunctionalityPage;

public class TC_Recovery_Manager_DeleteFunctionality_62 extends TC_Recovery_Manager_CreateUser_59{
	@Test(dependsOnMethods="createUser")
	public void deleteUser() throws InterruptedException, Exception {
		
			TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
			login.loginPage();
			Recovery_Manager_DeleteFunctionalityPage admin= new Recovery_Manager_DeleteFunctionalityPage(driver);
			String countrySelected=selectedCountry;
			String userID=userid;
			System.out.println("selectedCountry"+countrySelected);
			admin.switchToRecoveryManager(countrySelected);
			admin.selectStoreId(selectedStoreId);
			System.out.println("the country,storeid,userid to be deleted is : "+countrySelected+" "+selectedStoreId+ " "+userID);
			/*Thread.sleep(2000);
			String selectedCountry=admin.selectCountry(countrySelected);
			Thread.sleep(1000);
//			String selectedStore=admin.selectStoreIDRM();
			Thread.sleep(1000);
	        admin.searchCountryName();
	        Thread.sleep(1000);
	        admin.setCountryNamee(selectedCountry);
	        Thread.sleep(1000);*/
			admin.searchUserID(userID);
	        admin.scrollDownDeleteBtn();
	        Thread.sleep(2000);
	        admin.confirmModal();
	        log.info("Recovery Manager is successfully able to delete Recoevry user details");
	        //admin.setRMUserName(editusernameRM);
	        //Thread.sleep(1000);
	        admin.selectStoreIDRM();
	        Thread.sleep(1000);
	        //admin.submitClick();
	        //Thread.sleep(2000);
	        //admin.changeStoreID(); 
	        //Assert.assertEquals(admin.countryCheck.getText(), ":CA", "Country name is not expected one");
	        //admin.setRMStoreID(storIddeeeeee);
	        //Thread.sleep(1000);
	        //admin.verifydeletedUserName();
	        
	         
		}
	}

		