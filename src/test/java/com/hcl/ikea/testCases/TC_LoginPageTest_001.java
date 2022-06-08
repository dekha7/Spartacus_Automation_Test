package com.hcl.ikea.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.LoginPage;

public class TC_LoginPageTest_001 extends BaseClass{
	
	@Test
	public void loginPage() throws InterruptedException, Exception {
		
		log.info("Url launched successfully");
		Thread.sleep(2000);
		LoginPage lp = new LoginPage(driver);
		lp.setName(usrNm);
		log.info("Entered UserName");
		Thread.sleep(1000);
		lp.setPassword(password);
		log.info("Entered Password");
		Thread.sleep(3000);
		lp.submit();
		log.info("Submit button got clicked");
		
		if(driver.getTitle().contains("Spartacus V2")) {
			Assert.assertTrue(true);
			log.info("Test Case got passed");
		}else {
			captureScreen(driver, "TC_LoginPageTest_001");
			log.info("Taking screenshot of failed test case");
			Assert.assertTrue(false);
			log.info("Test case got failed");
		}
	}
}
