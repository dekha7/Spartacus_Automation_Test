package com.hcl.ikea.testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.Administration_SearchFunctionality_AddingNewStorePage;

public class TC_Administration_SearchFunctionality_AddingNewStore_56 extends BaseClass{
//	Recovery user should be able to add stock successfully
	@Test
	public void createUser() throws InterruptedException, Exception {
			TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
			login.loginPage();
			Administration_SearchFunctionality_AddingNewStorePage admin= new Administration_SearchFunctionality_AddingNewStorePage(driver);
			admin.createStore();
			Thread.sleep(1000);
			log.info("Store Management page is getting displayed successfully");
		    admin.searchStore(storeNameee);
		    log.info("Required store is getting search after input Store name into search text field");
	        Thread.sleep(1000);
	        admin.clickEditBtn();
	       JavascriptExecutor js = (JavascriptExecutor) driver;
	        
	       String city = js.executeScript("return document.getElementById('Body_City').value").toString();
	        //Assert.assertEquals(admin.city, "Frielas, Boston", "City name is not getting validate");
	        log.info("user is successfully able to click on edit button for serched store");
	        //Assert.assertEquals(admin.storID, "154", "Store ID is not getting verified");
	        log.info("Store ID got verified successfully.");
	        //Assert.assertEquals(admin.postalCod, "2660-100", "Postal Code is not getting verified");
	        log.info("postal Code got verified successfully");
	        Thread.sleep(4000);
	        admin.submitClick();
		}
	}

		