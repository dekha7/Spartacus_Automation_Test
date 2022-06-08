package com.hcl.ikea.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Recovery_Manager_CreateUserPage {
  
	public WebDriver driver;
	public Recovery_Manager_CreateUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='changeUserRole']/ul/li/a/span")
	public WebElement role;
	@FindBy(xpath="//div[@id='userTable_filter']/label/input")
	public WebElement searchTextField;
	@FindBy(xpath="//input[contains(@name,'txtSearch') and @id='Body_txtSearch']")
	public WebElement searchArticleComponentTxt;
	@FindBy(xpath="//input[contains(@name,'btnSearch') and @id='Body_btnSearch']")
	public WebElement searchArticleComponentBtn;
	@FindBy(xpath="//div[@id='changeUserCountry']/ul/li/a/span")
	public WebElement country1;
	@FindBy(xpath="//span[@title='Change Country']")
	public WebElement switchCountry;
	@FindBy(xpath="//select[@id='ddlStore']")
	public WebElement switchStoreId;
	@FindBy(xpath="//select[@id='Body_StoreID']")
    public WebElement storeID;
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
	@FindBy(xpath="//div[@id='divCheck']/following-sibling::div/input[2]")
	public WebElement resetBtn;
	@FindBy(xpath="//div[@id='sidebar-wrapper']/ul/li[2]/ul/li[4]")
	public WebElement userManagement;
	@FindBy(xpath="//a[@id='Repeater2_SwitchUserCountry_1']")
	public WebElement countrySelection;
	@FindBy(xpath="//a[@id='Repeater1_SwitchUserRole_5']")
	public WebElement adminRole;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/div[2]/p")
	public WebElement confirmModalMessage;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/div[3]/button[1]")
	public WebElement confirmModalOkBtn;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/div[3]/button[2]")
	public WebElement confirmModalCancelBtn;
	@FindBy(xpath="//p[@class='message' and normalize-space()='A user with this UserID already exists.']")
	public WebElement alreadyEsixtUserMsg;
	@FindBy(xpath="//p[contains(text(),'UserID already exists.')]//parent::div//following-sibling::div//button[normalize-space()='OK']")
	public WebElement OkAsExistUser;
	@FindBy(xpath="//table[@id='userTable']//tbody//tr//td[contains(text(),'No data available')]")
	public WebElement noUserAfterSearch;
	
	public void switchToRecoveryManager() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		recoveryManagerRole.click();
		Thread.sleep(1000);
		action.moveToElement(country1).build().perform();
		Thread.sleep(2000);
//		countrySelection.click();
	}
	public String selectCountry() {
		Actions action = new Actions(driver);
		action.moveToElement(switchCountry).build().perform();
		String countrySelected= countrySelection.getText().trim();
		countrySelection.click();
	    System.out.println("the selected country is "+countrySelected);
		return countrySelected;
	}
	public String selectStoreId() throws Exception {
		Select sel = new Select(switchStoreId);
		sel.selectByIndex(0);
		Thread.sleep(5000);
		String storeID=sel.getFirstSelectedOption().getText();
		return storeID;
	}
	public String setRMUserID() throws InterruptedException {
		double num=Math.random();
		String no=Double.toString(num);
		String no2="";
		if(no.length()>6) {
			 no2=no.substring(no.indexOf("0.")+2, 7);
		}
		userID.click();
		Thread.sleep(3000);
		String userIDVal="abc"+no2;
		userID.sendKeys(userIDVal);
		return userIDVal;
	}
	public void setRMUNam(String usrRMNm) {
		userNamee.sendKeys(usrRMNm);
	}
	public void selectRole() {
		Select sel = new Select(userRole);
//	    sel.selectByValue("2");
		sel.selectByVisibleText("Recovery");
	}

	public void selectStoreID(String storeid) {
		Select sel = new Select(storeID);
	    sel.selectByValue(storeid+" ");
	}
	  public void selectLanguage() { 
		  Select sel = new Select(language);
	  sel.selectByValue("1"); 
	  }
	public void submitClick() {
		submitBtn.click();
	}
	public void confirmModal() {
		if(confirmModalMessage.getText().equals("Are you sure you want to add this User?")) {
			confirmModalOkBtn.click();
		}
//		else {  confirmModalCancelBtn.click();}	
//		try {
//		if(alreadyEsixtUserMsg.isDisplayed()) {
//			OkAsExistUser.click();
//		  }
//		}catch(Exception e) {
//			System.out.println("Not a Existing user hence added");
//		}
	}
	public void searchUserID(String userRMID) throws Exception {
		Actions action = new Actions(driver);
		int x = searchTextField.getLocation().getX();
		System.out.println("X coordinate of searchtextField web element is "+x);
		int y = searchTextField.getLocation().getY();
		System.out.println("Y coordinate of searchtextField web element is "+y);
		action.moveToElement(searchTextField, x, y).click();
		Thread.sleep(3000);
	    searchTextField.sendKeys(userRMID);
	    try {
	    if(noUserAfterSearch.isDisplayed()) {
	    	Assert.assertTrue(false);
	     }
	    }catch(Exception e) {
	    	Assert.assertTrue(true);
	    }
	    
}
}
