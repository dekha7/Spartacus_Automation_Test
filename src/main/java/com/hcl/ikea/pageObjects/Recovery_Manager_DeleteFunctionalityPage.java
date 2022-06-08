package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Recovery_Manager_DeleteFunctionalityPage {
  
	public WebDriver driver;
	public Recovery_Manager_DeleteFunctionalityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='changeUserRole']/ul/li/a/span")
	public WebElement role;
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
	@FindBy(xpath="//a[@id='Repeater1_SwitchUserRole_5']")
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
	
	public void switchToRecoveryManager(String country) throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		recoveryManagerRole.click();
		Thread.sleep(5000);
//		action.moveToElement(country1).build().perform();
		String countryToSwitch=country.toUpperCase();
	    WebElement countryElem=driver.findElement(By.xpath("//a[contains(@id,'Repeater2_SwitchUserCountry_') and text()='"+countryToSwitch+"']"));
	    action.moveToElement(countrySwitch).moveToElement(countryElem).click(countryElem).build().perform();
	    Thread.sleep(2000);
		//countrySelection.click();
	}
	public String selectCountry(String country) {
		Actions action = new Actions(driver);
		action.moveToElement(switchCountry).build().perform();
		String countrySelected= countrySelection.getText().trim();
		countrySelection.click();
	    System.out.println("the selected country is "+countrySelected);
		return countrySelected;
	}
	public void selectStoreId(String storeid) throws Exception {
		Select sel = new Select(switchStoreId);
		sel.selectByValue(storeid);	
	}
	public void setCountryNamee(String counNam) {
		searchTextField.sendKeys(counNam);
	}
	public void scrollDownDeleteBtn() throws Exception {
		/*
		 * int rowNos =
		 * driver.findElements(By.xpath("//table[@id='userTable']/tbody/tr")).size();
		 * int firstRow=0; WebElement editBtn=null;; for(int i=0; i<=rowNos; i++) {
		 * if(editBtn.isDisplayed()) { editBtn.click(); // } }
		 */	
//	  JavascriptExecutor jse = (JavascriptExecutor)driver; int y =
//	  deleteBtn.getLocation().getY();
//	  System.out.println("Y coordinate of editBtn is "+y);
//	  jse.executeScript("window.scrollBy(0,508)", ""); 
//	  Thread.sleep(4000);
//	  deleteBtn.click();
//	  jse.executeScript("window.scrollBy(0,-508)", "");
		try {
			deleteFirstUserBtn.isDisplayed();
			deleteFirstUserBtn.click();
		}catch(Exception e) {
			System.out.println("Delete buton not found for first user");
			Assert.assertTrue(false);
		}
		
	 
	}
	public void setRMUserName(String editUNameRM) {
		userNamee.clear();
		userNamee.sendKeys(editUNameRM);
	}
	public void submitClick() {
		submitBtn.click();
	}
	public String selectStoreIDRM() {
		Select sel = new Select(storeID);
//		sel.selectByValue("501");
		sel.selectByIndex(2);
		WebElement option = sel.getFirstSelectedOption();
		String selectedItem = option.getText();
		return selectedItem;
	}
	public void selectEditStoreIDRM() {
		Select sel = new Select(storeIDDropDown);
		sel.selectByValue("230 ");
	}
	public void confirmModal() {
		if(confirmModalMessage.getText().equals("Are you sure you want to delete this user?")) {
			confirmModalOkBtn.click();
		}else {
		  confirmModalCancelBtn.click();   
		}	
	}
	public void changeStoreID() {
		Select sel = new Select(storeID);
		sel.selectByValue("230");
	}
	
	public void searchCountryName() throws Exception {
		Actions action = new Actions(driver);
		int x = searchTextField.getLocation().getX();
		System.out.println("X coordinate of searchtextField web element is "+x);
		int y = searchTextField.getLocation().getY();
		System.out.println("Y coordinate of searchtextField web element is "+y);
		action.moveToElement(searchTextField, x, y).click();
		Thread.sleep(3000);
	}
	public void searchStoreID() throws Exception {
		Actions action = new Actions(driver);
		int x = searchTextField.getLocation().getX();
		System.out.println("X coordinate of searchtextField web element is "+x);
		int y = searchTextField.getLocation().getY();
		System.out.println("Y coordinate of searchtextField web element is "+y);
		action.moveToElement(searchTextField, x, y).click();
		Thread.sleep(3000);
	}
	public void setRMStoreID(String storeID) throws InterruptedException {
		searchTextField.clear();
		Thread.sleep(1000);
		searchTextField.sendKeys(storeID);
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
	public void verifydeletedUserName() throws InterruptedException { 
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		int y = editedUserName.getLocation().getY();
		System.out.println("Y coordinate of editedUserName is " +y);
		jse.executeScript("window.scrollBy(0,515)", "");
		Thread.sleep(5000);
		if(editedUserName.getText().equals("Aakash Srivas")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
}
