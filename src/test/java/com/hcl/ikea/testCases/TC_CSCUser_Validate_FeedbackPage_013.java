package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.CSCUser_Validation_Feedback_Page;

public class TC_CSCUser_Validate_FeedbackPage_013 extends BaseClass{

	@Test
	public void feedbackPage()throws InterruptedException, Exception{
		TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
		login.loginPage();
		CSCUser_Validation_Feedback_Page cr= new CSCUser_Validation_Feedback_Page(driver);
		cr.validateFeedbackPage();
	}
}
