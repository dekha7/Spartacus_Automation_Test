package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.ValidateRangeUploadIssueNotificationAlert;

public class TC_ValidateRangeUploadIssueNotificationAlert_81 extends BaseClass{

	@Test
	public void validatephaseInOutDateIssue() throws InterruptedException, Exception {
		TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
		lp.loginPage();
		ValidateRangeUploadIssueNotificationAlert obj = new ValidateRangeUploadIssueNotificationAlert(driver);
		obj.notificationAndCCompCount();
	}
}
