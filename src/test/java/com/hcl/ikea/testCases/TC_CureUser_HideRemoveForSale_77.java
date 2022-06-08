package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.CureUser_HandOutValidateHideRemoveForSale;

public class TC_CureUser_HideRemoveForSale_77  extends BaseClass{

	@Test
	public void validateAddLabel() throws InterruptedException, Exception {
		TC_LoginPageTest_001 lp = new TC_LoginPageTest_001();
		lp.loginPage();
		CureUser_HandOutValidateHideRemoveForSale cure= new CureUser_HandOutValidateHideRemoveForSale(driver);
		cure.handOutRequestValidateHideRemoveSale();

  }

}
