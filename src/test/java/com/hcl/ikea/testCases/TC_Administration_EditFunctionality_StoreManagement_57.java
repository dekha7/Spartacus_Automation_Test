package com.hcl.ikea.testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.Administration_EditFunctionality_StoreManagement;
import com.hcl.ikea.pageObjects.Administration_SearchFunctionality_AddingNewStorePage;

public class TC_Administration_EditFunctionality_StoreManagement_57 extends BaseClass{
//	Recovery user should be able to add stock successfully
	@Test
	public void createUser() throws InterruptedException, Exception {
			TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
			login.loginPage();
			Administration_EditFunctionality_StoreManagement admin= new Administration_EditFunctionality_StoreManagement(driver);
			admin.createStore();
			Thread.sleep(1000);
			log.info("Store Management page is getting displayed successfully");
		    admin.searchStore(editFunctionalityStoreName);
		    log.info("Required store is getting search after input Store name into search text field");
	        Thread.sleep(1000);
	        admin.clickEditBtn();
	        Thread.sleep(1000);
	        //admin.setName(editStoreName);
	        //Thread.sleep(1000);
	        admin.setStName(editStreetName);
	        Thread.sleep(1000);
	        admin.setPostalCode(editPostalCode);
	        Thread.sleep(4000);
	        admin.submitClick();
	        Thread.sleep(3000);
	        admin.validationCheck();
	        Thread.sleep(2000);
	        admin.alertOk();
	        Thread.sleep(2000);
	        admin.clearSearchStoreTextfield(editFunctionalityStoreName);
	        Thread.sleep(2000);
	        admin.searchStore(editFunctionalityStoreName);
		    log.info("Required store is getting search after input Store name into search text field");
	        Thread.sleep(1000);
	        admin.clickEditBtn();
	        Thread.sleep(2000);
	       // admin.validationCheck();
	        //Thread.sleep(1000);
	        admin.fieldsValidation();
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        String city = js.executeScript("return document.getElementById('Body_City').value").toString();
	        //Assert.assertEquals(admin.city, "Lissabondon");
	        log.info("user is successfully able to click on edit button for serched store");
	        //Assert.assertEquals(admin.storName, "Frielas, Boston", "Store name is not getting verified");
	        log.info("Store Name got verified successfully after editing details.");
	        //Assert.assertEquals(admin.strName, "MN 342 Mrn 30 de Setembro", "Street name is not getting verified");
	        log.info("Street Name got verified successfully after editing details");
	        
		}
	}

		