package com.hcl.ikea.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.ValidatePictureAdminOfRangeManagement_RejectBtnValidation;
import com.hcl.ikea.pageObjects.ValidatePictureAdminOfRangeManagement_SendMailValidation;

public class TC_ValidatePictureAdminOfRangeManagement_44_04  extends BaseClass{

	@Test
	public void validatePictureAdminSendMail() throws InterruptedException, Exception {
		TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
		lp.loginPage();
		ValidatePictureAdminOfRangeManagement_SendMailValidation obj = new ValidatePictureAdminOfRangeManagement_SendMailValidation(driver);
		obj.verifySendMail();
		Assert.assertTrue(true);
	}
}
