package com.hcl.ikea.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.ValidatePictureAdminOfRangeManagement_ApproveBtnValidation;

public class TC_ValidatePictureAdminOfRangeManagement_44_02  extends BaseClass{

	@Test
	public void validatePictureAdminApproveButton() throws InterruptedException, Exception {
		TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
		lp.loginPage();
		ValidatePictureAdminOfRangeManagement_ApproveBtnValidation obj = new ValidatePictureAdminOfRangeManagement_ApproveBtnValidation(driver);
		obj.verifyApproveButton();
		Assert.assertTrue(true);
	}
}
