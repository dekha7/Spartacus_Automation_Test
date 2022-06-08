package com.hcl.ikea.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.UserAdmin_EditUserPage;

public class TC_UserAdmin_EditUser_65 extends TC_UserAdmin_CreateUser_64{

	@Test(dependsOnMethods="createUser")
	public void deleteUserInUserAdmin() throws InterruptedException, Exception {
	TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
	login.loginPage();
	UserAdmin_EditUserPage admin= new UserAdmin_EditUserPage(driver);
	admin.switchToUserAdmin();
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
