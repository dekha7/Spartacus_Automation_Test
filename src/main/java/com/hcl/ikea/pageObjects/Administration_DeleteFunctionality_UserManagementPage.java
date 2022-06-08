package com.hcl.ikea.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Administration_DeleteFunctionality_UserManagementPage {
  
	public WebDriver driver;
	public Administration_DeleteFunctionality_UserManagementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='changeUserRole']/ul/li/a/span")
	public WebElement role;
	@FindBy(xpath="//div[@class='side-menu']//span[text()='Administration']")
    public WebElement administration;
	@FindBy(xpath="//span[@title='Change Country']")
	public WebElement countrySwitch;
	@FindBy(xpath="//select[@id='ddlStore']")
	public WebElement switchStoreId;
	@FindBy(xpath="//div[@id='userTable_filter']/label/input")
	public WebElement searchTextField;
	@FindBy(xpath="//input[contains(@name,'txtSearch') and @id='Body_txtSearch']")
	public WebElement searchArticleComponentTxt;
	@FindBy(xpath="//input[contains(@name,'btnSearch') and @id='Body_btnSearch']")
	public WebElement searchArticleComponentBtn;
	@FindBy(xpath="//div[@id='changeUserCountry']/ul/li/a/span")
	public WebElement country1;
	@FindBy(xpath="//span[@id='lblCountry']")
    public WebElement countryCheck;
	@FindBy(xpath="//a[contains(@id,'Repeater1_SwitchUserRole') and normalize-space()='UserAdmin']")
	public WebElement userAdminRole;
	@FindBy(xpath="//a[contains(@id,'Repeater1_SwitchUserRole') and normalize-space()='RecoveryManager']")
	public WebElement recoveryManagerRole;
	@FindBy(xpath="//h4[@class='modal-title' and @id='confirm-label']")
	public WebElement confirmModal;
	@FindBy(xpath="//*[@id=\"confirm\"]/div[2]/div/div[3]/button[2]")
	public WebElement cancelBtn;
	@FindBy(xpath="//input[@id='Body_UserName']")
	public WebElement userNamee;
	@FindBy(xpath="//select[@id='Body_UserLevel']")
	public WebElement userRole;
	@FindBy(xpath="//select[@id='Body_CountryCode']")
	public WebElement country2;
	@FindBy(xpath="//select[@id='Body_CultureID']")
	public WebElement language;
	@FindBy(xpath="//input[@id='Body_UserID']")
	public WebElement userID;
	@FindBy(xpath="//div[@id='divCheck']/following-sibling::div/input[1]")
	public WebElement submitBtn;
	@FindBy(xpath="//td[contains(text(),'249')]/following-sibling::td[7]/span[2]")
	public WebElement deleteBtn;
	@FindBy(xpath="//div[@id='sidebar-wrapper']/ul/li[2]/ul/li[4]")
	public WebElement userManagement;
	@FindBy(xpath="//span[@title='Change Country']")
	public WebElement switchCountry;
	@FindBy(xpath="//a[@id='Repeater2_SwitchUserCountry_1']")
	public WebElement countrySelection;
	@FindBy(xpath="//a[contains(@id,'Repeater1_SwitchUserRole') and text()='Admin']")
	public WebElement adminRole;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/div[2]/p")
	public WebElement confirmModalMessage;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/div[3]/button[1]")
	public WebElement confirmModalOkBtn;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/div[3]/button[2]")
	public WebElement confirmModalCancelBtn;
	@FindBy(xpath="//select[@id='Body_StoreID']")
	public WebElement storeIDDropDown;
	@FindBy(xpath="//select[@id='ddlStore']")
	public WebElement storeID;
	@FindBy(xpath="//table[@id='userTable']/tbody/tr/td[2]")
	public WebElement editedUserName;
	@FindBy(xpath="//table[@id='userTable']//tbody//tr//td[contains(text(),'No data available')]")
	public WebElement noUserAfterSearch;
	@FindBy(xpath="(//table[@id='userTable']//tbody//tr//td)[10]//span[@class='cancel actButton']")
	public WebElement deleteFirstUserBtn;
	
	public void switchToAdminUserManagement() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		adminRole.click();
		Thread.sleep(1000);
		action.moveToElement(administration).build().perform();
		Thread.sleep(2000);
		userManagement.click();
		Thread.sleep(1000); 
	}
	public void setNetworkID(String netID) {
	     searchTextField.sendKeys(netID);	       
	}    

	public void searchUserID(String userID) throws Exception {
		Actions action = new Actions(driver);
		int x = searchTextField.getLocation().getX();
		System.out.println("X coordinate of searchtextField web element is "+x);
		int y = searchTextField.getLocation().getY();
		System.out.println("Y coordinate of searchtextField web element is "+y);
		action.moveToElement(searchTextField, x, y).click();
		Thread.sleep(3000);
	    searchTextField.sendKeys(userID);
	    try {
	    if(noUserAfterSearch.isDisplayed()) {
	    	Assert.assertTrue(false);
	     }
	    }catch(Exception e) {
	    	Assert.assertTrue(true);
	    }
	}
	public void scrollDownDeleteBtn() throws Exception {

		try {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			int y = deleteFirstUserBtn.getLocation().getY();
			System.out.println("Y coordinate of editBtn web element is "+y);
			jse.executeScript("window.scrollBy(0,519)", "");
			deleteFirstUserBtn.isDisplayed();
			deleteFirstUserBtn.click();
		}catch(Exception e) {
			System.out.println("Delete buton not found for first user");
			Assert.assertTrue(false);
		}
 }
	public void confirmModal() throws Exception {
		if(confirmModalMessage.getText().equals("Are you sure you want to delete this user?")) {
			Thread.sleep(2000);
			confirmModalOkBtn.click();
		}else {
			Thread.sleep(2000);
		  confirmModalCancelBtn.click();   
		}	
	}
	 public void validationCheck() {
		 if(confirmModalMessage.getText().equals("Are you sure you want to delete this user?")) {
			 confirmModalOkBtn.click();
		 }else {
			 confirmModalCancelBtn.click();
		 }
	 }
		
}
