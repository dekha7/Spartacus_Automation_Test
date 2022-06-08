package com.hcl.ikea.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.Administration_AddingNewStorePage;

public class TC_Administration_AddingNewStore_55 extends BaseClass{
//	Recovery user should be able to add stock successfully
	@Test
	public void addingNewStore() throws InterruptedException, Exception {
			TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
			login.loginPage();
			Administration_AddingNewStorePage admin= new Administration_AddingNewStorePage(driver);
			admin.createUser();
			Thread.sleep(1000);
			admin.setStoreID(storeIdee);
			Thread.sleep(1000);
	        admin.setStoreNam(storeNameee);
	        Thread.sleep(2000);
	        admin.setPostalCod(postalCodeee);
	        Thread.sleep(1000);
	        admin.setStreetNam(streetNameee);
	        Thread.sleep(1000);
	        admin.setCityNam(cityNameee);
	        Thread.sleep(1000);
	        admin.selectCountry();
	        Thread.sleep(1000);
	        admin.setRuCod(ruCodeee);
	        Thread.sleep(1000);
	        admin.setRdCod(rdCodeee);
	        log.info("RD Code entered successfully");
	        Thread.sleep(1000);
	        admin.submitClick();
	        log.info("Submit buttn got clicked successfully after calling method");
	        Thread.sleep(1000);
	        admin.searchStoreID(storeIdee);
	        Assert.assertTrue(true, "New Store has been added successfully");
		}
	}

		