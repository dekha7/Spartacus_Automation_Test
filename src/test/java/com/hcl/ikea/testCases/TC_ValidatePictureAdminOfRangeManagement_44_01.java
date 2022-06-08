package com.hcl.ikea.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.ValidatePictureAdminOfRangeManagement_PicIconValidation;

public class TC_ValidatePictureAdminOfRangeManagement_44_01  extends BaseClass{

	@Test
	public void validatePictureAdminPickIcon() throws InterruptedException, Exception {
		TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
		lp.loginPage();
		ValidatePictureAdminOfRangeManagement_PicIconValidation obj = new ValidatePictureAdminOfRangeManagement_PicIconValidation(driver);
		obj.verifyPictureIcon();
		Assert.assertTrue(true);
	}
}
