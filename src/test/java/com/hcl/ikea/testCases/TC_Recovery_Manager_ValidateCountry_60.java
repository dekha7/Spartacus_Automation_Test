package com.hcl.ikea.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.Recovery_Manager_ValidateCountryPage;

public class TC_Recovery_Manager_ValidateCountry_60 extends BaseClass{
//	Recovery user should be able to add stock successfully
	@Test
	public void countryValidation() throws InterruptedException, Exception {
			TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
			login.loginPage();
			Recovery_Manager_ValidateCountryPage admin= new Recovery_Manager_ValidateCountryPage(driver);
			admin.createUser();
			Thread.sleep(2000);
			admin.selectCountry();
			 Thread.sleep(1000);
	        admin.countryCheckValidation();
	        Thread.sleep(2000);
	        admin.searchCountryName();
	        Thread.sleep(1000);
	        admin.setCountryNamee(countryNameeee);
	        Assert.assertEquals(admin.countryCheck.getText(), ":CA", "Country name is not expected one");
	        log.info("user is getting added sucessfully by Recovery Manager");
		}
	}

		