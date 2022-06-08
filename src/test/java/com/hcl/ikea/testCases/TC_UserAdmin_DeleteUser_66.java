package com.hcl.ikea.testCases;

import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.UserAdmin_DeleteUserPage;

public class TC_UserAdmin_DeleteUser_66 extends TC_UserAdmin_CreateUser_64 {
	@Test(dependsOnMethods="createUser")
	public void deleteUserInUserAdmin() throws InterruptedException, Exception {
	TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
	login.loginPage();
	UserAdmin_DeleteUserPage admin= new UserAdmin_DeleteUserPage(driver);
	admin.switchToUserAdmin();
	String userID=userid;
	admin.searchUserID(userID);
    admin.scrollDownDeleteBtn();
    Thread.sleep(2000);
    admin.confirmModal();
    log.info("User Admin is successfully able to delete Recoevry user details");
	}
}
