package com.hcl.ikea.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.Administration_CreateUserPage;
import com.hcl.ikea.pageObjects.Administration_EditUserDetailsPage;

public class TC_Administration_EditUserDetails_54 extends TC_Administration_CreateUser_53{
//	Recovery user should be able to add stock successfully
	@Test
	public void adminEditUser() throws InterruptedException, Exception {
			TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
			login.loginPage();
			Administration_EditUserDetailsPage admin= new Administration_EditUserDetailsPage(driver);
			admin.switchToAdminUserManagement();
			String userID=userid;
			admin.searchUserID(userID);
			admin.clickEditBtn();
		    String newLang=admin.changeLanguage("Bangla - BN-IN");
		    admin.submitClick();
		    admin.confirmModal();
		    Thread.sleep(3000);
		    admin.searchUserID(userID);
		    String newLangIntable=admin.getFirstUserLanguage();
		    Assert.assertEquals(newLangIntable, "Bangla");
		    Thread.sleep(2000);
		    log.info("User Admin is successfully able to delete Recoevry user details");
			 
		}
	}

		