package com.hcl.ikea.testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.Administration_DeleteFunctionality_UserManagementPage;
import com.hcl.ikea.pageObjects.Administration_EditFunctionality_StoreManagement;
import com.hcl.ikea.pageObjects.Administration_SearchFunctionality_AddingNewStorePage;
import com.hcl.ikea.pageObjects.UserAdmin_DeleteUserPage;

public class TC_Administration_DeleteFunctionality_UserManagement_58 extends TC_Administration_CreateUser_53{
//	Recovery user should be able to add stock successfully
	@Test(dependsOnMethods="adminCreateUser")
	public void deleteFunctionalityUserManagement() throws InterruptedException, Exception {
			TC_LoginPageTest_001 login = new TC_LoginPageTest_001();
			login.loginPage();
			Administration_DeleteFunctionality_UserManagementPage admin= new Administration_DeleteFunctionality_UserManagementPage(driver);
			admin.switchToAdminUserManagement();
			String userID=userid;
			admin.searchUserID(userID);
		    admin.scrollDownDeleteBtn();
		    Thread.sleep(2000);
		    admin.confirmModal();
		    log.info("Admin user management is successfully able to delete Recoevry user details");	  
		}
	}

		