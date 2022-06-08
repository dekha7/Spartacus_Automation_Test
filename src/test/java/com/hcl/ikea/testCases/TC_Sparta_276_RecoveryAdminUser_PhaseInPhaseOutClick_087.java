package com.hcl.ikea.testCases;

import org.testng.annotations.Test;
import com.hcl.ikea.pageObjects.Sparta_276_RangeManagementReportissue_Page;

public class TC_Sparta_276_RecoveryAdminUser_PhaseInPhaseOutClick_087 extends BaseClass{
	
	@Test
	public void newLinkPiaFacts() throws InterruptedException, Exception {
	TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
	lp.loginPage();
	log.info("Application got login successfully");
	Sparta_276_RangeManagementReportissue_Page phase = new Sparta_276_RangeManagementReportissue_Page(driver);
	log.info("Creating object of page for calling phaseInPhaseOutClick() method");
	phase.phaseInPhaseOutClick();
	Thread.sleep(2000);
    log.info("C Component details are getting displayed successfully and no runtime error found for click on PhaseIn/PhaseOut click");
	}
	
}
