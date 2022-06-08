package com.hcl.ikea.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Release2_23_CSC_CSC_Manager_duplicate_entry_validation {

	public WebDriver driver;

	// int filterRowNos = 0;
	public Release2_23_CSC_CSC_Manager_duplicate_entry_validation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='changeUserRole']/ul/li/a/span")
	public WebElement role;
	@FindBy(xpath = "//div[@id='userTable_filter']/label/input")
	public WebElement searchTextField;
	@FindBy(xpath = "//input[@name='ctl00$Body$btnSearch' and @id='Body_btnSearch']")
	public WebElement searchButton;
	@FindBy(xpath = "//div[@id='changeUserCountry']/ul/li/a/span")
	public WebElement country1;
	@FindBy(xpath = "//select[@id='Body_StoreID']")
	public WebElement storeID;
	@FindBy(xpath = "//a[text()='CSCManager']")
	public WebElement cscManagerRole;
	@FindBy(xpath = "//h4[@class='modal-title' and @id='confirm-label']")
	public WebElement confirmModal;
	@FindBy(xpath = "//*[@id=\"confirm\"]/div[2]/div/div[3]/button[2]")
	public WebElement cancelBtn;
	@FindBy(xpath = "//input[@id='Body_UserName']")
	public WebElement userNamee;
	@FindBy(xpath = "//select[@id='Body_UserLevel']")
	public WebElement userRole;
	@FindBy(xpath = "//select[@id='Body_CountryCode']")
	public WebElement country2;
	@FindBy(xpath = "//select[@id='Body_CultureID']")
	public WebElement language;
	@FindBy(xpath = "//input[@id='Body_UserID']")
	public WebElement userID;
	@FindBy(xpath = "//div[@id='divCheck']/following-sibling::div/input[1]")
	public WebElement submitBtn;
	@FindBy(xpath = "//div[@id='divCheck']/following-sibling::div/input[2]")
	public WebElement resetBtn;
	@FindBy(xpath = "//div[@id='sidebar-wrapper']/ul/li[2]/ul/li[4]")
	public WebElement userManagement;
	@FindBy(xpath = "//a[@id='Repeater2_SwitchUserCountry_1']")
	public WebElement countrySelection;
	@FindBy(xpath = "//a[@id='Repeater1_SwitchUserRole_5']")
	public WebElement adminRole;
	@FindBy(xpath = "//div[@id='confirm']/div[2]/div/div[2]/p")
	public WebElement confirmModalMessage;
	@FindBy(xpath = "//div[@id='confirm']/div[2]/div/div[3]/button[1]")
	public WebElement confirmModalOkBtn;
	@FindBy(xpath = "//div[@id='confirm']/div[2]/div/div[3]/button[2]")
	public WebElement confirmModalCancelBtn;
	@FindBy(xpath = "//td[contains(text(),'Aakash Srivastva')]/following-sibling::td[8]/span[1]")
	public WebElement editBtn1;
	@FindBy(xpath = "//td[contains(text(),'ChandraShekharCSCUser')]/following-sibling::td[8]/span[1]")
	public WebElement editBtn2;
	@FindBy(xpath = "//td[text()='ChandraShekharCSCUser']/following-sibling::td[8]/span[2]")
	public WebElement deleteBtn;
	@FindBy(xpath = "//td[text()='ChandraShekharCSCUser']")
	public WebElement filterUserName2;
	@FindBy(xpath = "//td[text()='Aakash Srivastva']")
	public WebElement filterUserName1;
	@FindBy(xpath = "//div[@id='confirm']/div[2]/div/div[2]/p")
	public WebElement deleteConfirmModalMsg;
	@FindBy(xpath = "//div[@id='confirm']/div[2]/div/div[3]/button[1]")
	public WebElement deleteConfirmModalOkCTA;
	@FindBy(xpath = "//div[@id='confirm']/div[2]/div/div[3]/button[2]")
	public WebElement deleteConfirmModalCancelCTA;
	@FindBy(xpath = "//h4[@id='Alert-label']")
	public WebElement messageModal;
	@FindBy(xpath = "//p[text()='A user with this UserID already exists.']")
	public WebElement messageModalTextMessage;
	@FindBy(xpath = "//p[text()='A user with this UserID already exists.']/parent::div/following-sibling::div/button")
	public WebElement messageModalOKCta;

	public void createFirstCSC_Coworker() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		cscManagerRole.click();
		Thread.sleep(1000);
	}

	/*
	 * public void selectCountry() { countrySelection.click(); }
	 */
	public void setCscUserID(String cscUID) throws Exception {
		userID.click();
		Thread.sleep(1000);
		userID.sendKeys(cscUID);
	}

	public void setcscUNam(String cscUsrNm) {
		userNamee.sendKeys(cscUsrNm);
	}

	public void selectRole() {
		Select sel = new Select(userRole);
		sel.selectByValue("4");
	}

	/*
	 * public void selectStoreID() { Select sel = new Select(storeID);
	 * sel.selectByValue("372 "); }
	 */
	public void selectLanguage() throws InterruptedException {
		Select sel = new Select(language);
		sel.selectByValue("1");
		Thread.sleep(1000);
		// submitBtn.click();
	}

	public void submitClick() {
		submitBtn.click();
	}

	public void confirmModal() {
		if (confirmModalMessage.getText().equals("Are you sure you want to add this User?")) {
			confirmModalOkBtn.click();
		} else {
			confirmModalCancelBtn.click();
		}
	}

	public void searchUserID(String userCSCID) throws Exception {
		Actions action = new Actions(driver);
		int x = searchTextField.getLocation().getX();
		System.out.println("X coordinate of searchtextField web element is " + x);
		int y = searchTextField.getLocation().getY();
		System.out.println("Y coordinate of searchtextField web element is " + y);
		action.moveToElement(searchTextField, x, y).click();
		Thread.sleep(3000);
		searchTextField.sendKeys(userCSCID);
	}

	public void scrollDownEditBtn1() throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = editBtn1.getLocation().getY();
		System.out.println("Y coordinate of editBtn is " + y);
		jse.executeScript("window.scrollBy(0,508)", "");
		Thread.sleep(4000);
		// filterRowNos =
		// driver.findElements(By.xpath("//table[@id='userTable']/tbody/tr")).size();
		// for(int i=0; i<=filterRowNos; i++) {
		if (filterUserName1.getText().equals("Aakash Srivastva")) {
			Assert.assertTrue(true, "CSC User role is getting created successfully for user named Aakash Srivastva");
		} else {
			Assert.assertTrue(false, "CSC User role is not getting created");
		}
		jse.executeScript("window.scrollBy(0,-508)", "");
	}
	public void messageModalValidation() {
		if(messageModalTextMessage.getText().equals("A user with this UserID already exists.")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
			messageModalOKCta.click();
		}
	/*
	 * public void scrollDownEditBtn2() throws Exception { JavascriptExecutor jse =
	 * (JavascriptExecutor)driver; int y = editBtn2.getLocation().getY();
	 * System.out.println("Y coordinate of editBtn is "+y);
	 * jse.executeScript("window.scrollBy(0,408)", ""); Thread.sleep(4000);
	 * //filterRowNos =
	 * driver.findElements(By.xpath("//table[@id='userTable']/tbody/tr")).size();
	 * //for(int i=0; i<=filterRowNos; i++) {
	 * if(filterUserName2.getText().equals("ChandraShekharCSCUser")) {
	 * System.out.println("Username got updated successfully"); }else {
	 * System.out.println("Username is not as expected " +filterUserName1); }
	 * //jse.executeScript("window.scrollBy(0,-408)", "");
	 * 
	 * } public void scrollDownDeleteUserDetails() throws InterruptedException {
	 * 
	 * JavascriptExecutor jse = (JavascriptExecutor)driver; int y =
	 * editBtn2.getLocation().getY();
	 * System.out.println("Y coordinate of editBtn is "+y);
	 * jse.executeScript("window.scrollBy(0,508)", ""); Thread.sleep(4000);
	 * 
	 * //filterRowNos =
	 * driver.findElements(By.xpath("//table[@id='userTable']/tbody/tr")).size();
	 * //for(int i=0; i<=filterRowNos; i++) {
	 * if(filterUserName2.getText().equals("ChandraShekharCSCUser")) {
	 * deleteBtn.click(); }else {
	 * System.out.println("User details deleted successfully"); } } public void
	 * deleteModalOps() { if(deleteConfirmModalMsg.getText().
	 * equals("Are you sure you want to delete this user?")) {
	 * deleteConfirmModalOkCTA.click(); }else { deleteConfirmModalCancelCTA.click();
	 * } } public void setEditUserNameCSC(String editUNameCSC) throws
	 * InterruptedException { userNamee.clear(); Thread.sleep(1000);
	 * userNamee.sendKeys(editUNameCSC); } public void confirmUpdateModal() {
	 * if(confirmModalMessage.getText().
	 * equals("Are you sure you want to update this User?")) {
	 * confirmModalOkBtn.click(); }else { confirmModalCancelBtn.click(); } } public
	 * void searchClearUserID(String userCSCID) throws Exception { Actions action =
	 * new Actions(driver); int x = searchTextField.getLocation().getX();
	 * System.out.println("X coordinate of searchtextField web element is "+x); int
	 * y = searchTextField.getLocation().getY();
	 * System.out.println("Y coordinate of searchtextField web element is "+y);
	 * action.moveToElement(searchTextField, x, y).click(); Thread.sleep(3000);
	 * searchTextField.clear(); Thread.sleep(1000);
	 * searchTextField.sendKeys(userCSCID); }
	 */
}
