package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.ValidateRangeUploadPhaseInPhaseOutUploadedDateIssue;

public class TC_ValidateRangeUploadPhaseInPhaseOutUploadedDateIssue_80 extends BaseClass{

	@Test
	public void validatephaseInOutDateIssue() throws InterruptedException, Exception {
		TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
		lp.loginPage();
		ValidateRangeUploadPhaseInPhaseOutUploadedDateIssue obj = new ValidateRangeUploadPhaseInPhaseOutUploadedDateIssue(driver);
		obj.phaseInOutDateIssue();
	}
}

