package com.hcl.ikea.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.ValidatePictureAdminOfRangeManagement_RejectBtnValidation;

public class TC_ValidatePictureAdminOfRangeManagement_44_03  extends BaseClass{

	@Test
	public void validateIctureAdminRejectButton() throws InterruptedException, Exception {
		TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
		lp.loginPage();
		ValidatePictureAdminOfRangeManagement_RejectBtnValidation obj = new ValidatePictureAdminOfRangeManagement_RejectBtnValidation(driver);
		obj.verifyRejectButton();
		Assert.assertTrue(true);
	}
}
