package com.hcl.ikea.testCases;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.Recovery_Manager_EditFunctionalityPage;

public class TC_Recovery_Manager_EditFunctionality_61 extends BaseClass{
	@Test
	public void countryValidation() throws InterruptedException, Exception {
			TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
			login.loginPage();
			Recovery_Manager_EditFunctionalityPage admin= new Recovery_Manager_EditFunctionalityPage(driver);
			admin.createUser();
			Thread.sleep(2000);
			admin.selectCountry();
			 Thread.sleep(1000);
			 admin.selectStoreIDRM();
			 Thread.sleep(1000);
	        admin.searchCountryName();
	        Thread.sleep(1000);
	        admin.setCountryNamee(countryNameeee);
	        Thread.sleep(1000);
	        admin.scrollDownEditBtn();
	        Thread.sleep(5000);
	        admin.setRMUserName(editusernameRM);
	        Thread.sleep(1000);
	        admin.selectEditStoreIDRM();
	        Thread.sleep(1000);
	        admin.submitClick();
	        Thread.sleep(2000);
	        admin.confirmModal();
	        log.info("Recovery Manager is successfully able to edit Recoevry user details");
	        admin.changeStoreID(); 
	        //Assert.assertEquals(admin.countryCheck.getText(), ":CA", "Country name is not expected one");
	        admin.setRMStoreID(storIddeeeeee);
	        Thread.sleep(1000);
	        admin.verifyeditedUserName();
		}
	}

		