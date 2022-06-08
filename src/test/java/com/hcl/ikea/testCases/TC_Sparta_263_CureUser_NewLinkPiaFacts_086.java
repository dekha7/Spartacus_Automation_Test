package com.hcl.ikea.testCases;

import org.testng.annotations.Test;
import com.hcl.ikea.pageObjects.Sparta_263_CureUser_NewLinkPiaFactsPage;

public class TC_Sparta_263_CureUser_NewLinkPiaFacts_086 extends BaseClass{
	
	@Test
	public void newLinkPiaFacts() throws InterruptedException, Exception {
	TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
	lp.loginPage();
	log.info("Application got login successfully");
	Sparta_263_CureUser_NewLinkPiaFactsPage piaLink = new Sparta_263_CureUser_NewLinkPiaFactsPage(driver);
	log.info("Calling Pia Facts icon link to be click by Cure User");
	piaLink.piaFactsNewLink();
	Thread.sleep(2000);
	piaLink.setPiaFactUserID(piaFactLoginID);
    log.info("For click on Pia icon link by Cure user a new page with new link Url: https://pia.ikea.net is successfully getting displayed");
	}
	
}
