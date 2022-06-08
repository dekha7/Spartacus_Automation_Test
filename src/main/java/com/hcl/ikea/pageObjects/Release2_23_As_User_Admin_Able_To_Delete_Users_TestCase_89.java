package com.hcl.ikea.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Release2_23_As_User_Admin_Able_To_Delete_Users_TestCase_89 {

	public WebDriver driver;

	public Release2_23_As_User_Admin_Able_To_Delete_Users_TestCase_89(WebDriver driver) {
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
	@FindBy(xpath = "//a[text()=\"UserAdmin\"]")
	public WebElement userAdminRole;
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
	@FindBy(xpath = "//select[@name='ctl00$Body$CountryCode' and @id='Body_CountryCode']")
	public WebElement countrySelection;
	@FindBy(xpath = "//a[@id='Repeater1_SwitchUserRole_5']")
	public WebElement adminRole;
	@FindBy(xpath = "//div[@id='confirm']/div[2]/div/div[2]/p")
	public WebElement confirmModalMessage;
	@FindBy(xpath = "//div[@id='confirm']/div[2]/div/div[2]/p")
	public WebElement deleteconfirmModalMessage;
	@FindBy(xpath = "//div[@id='confirm']/div[2]/div/div[3]/button[1]")
	public WebElement confirmModalOkBtn;
	@FindBy(xpath = "//div[@id='confirm']/div[2]/div/div[3]/button[2]")
	public WebElement confirmModalCancelBtn;
	@FindBy(xpath = "//td[contains(text(),'User IT - Aakash Srivastava')]/following-sibling::td[8]/span[2]")
	public WebElement deleteBtn1;
	@FindBy(xpath = "//td[text()='No data available in table']")
	public WebElement recordsMessage;
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

	public void createRecovery_worker() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		userAdminRole.click();
		Thread.sleep(1000);
	}
	public void setUserAdminID(String userAdminID) throws Exception {
		userID.click();
		Thread.sleep(1000);
		userID.sendKeys(userAdminID);
	}

	public void setUserAdminName(String userAdminName) {
		userNamee.sendKeys(userAdminName);
	}

	public void selectRole() {
		Select sel = new Select(userRole);
		sel.selectByValue("2");
	}
    public void selectCountry() {
    	Select sel = new Select(countrySelection);
    	sel.selectByVisibleText("Norway");
    }
	
	  public void selectStoreID() { 
		  Select sel = new Select(storeID);
	  sel.selectByValue("091 "); }
	 
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

	public void searchUserID(String userAdminID) throws Exception {
		Actions action = new Actions(driver);
		int x = searchTextField.getLocation().getX();
		System.out.println("X coordinate of searchtextField web element is " + x);
		int y = searchTextField.getLocation().getY();
		System.out.println("Y coordinate of searchtextField web element is " + y);
		action.moveToElement(searchTextField, x, y).click();
		Thread.sleep(3000);
		searchTextField.sendKeys(userAdminID);
	}
	public void searchUserAdminName(String userAdminName) throws Exception {
		Actions action = new Actions(driver);
		int x = searchTextField.getLocation().getX();
		System.out.println("X coordinate of searchtextField web element is " + x);
		int y = searchTextField.getLocation().getY();
		System.out.println("Y coordinate of searchtextField web element is " + y);
		action.moveToElement(searchTextField, x, y).click();
		Thread.sleep(3000);
		searchTextField.sendKeys(userAdminName);
	}

	public void scrollDownDeleteBtn1() throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = deleteBtn1.getLocation().getY();
		System.out.println("Y coordinate of editBtn is " + y);
		jse.executeScript("window.scrollBy(0,508)", "");
		Thread.sleep(1000);
	}
	public void deleteRecoveryUser() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", deleteBtn1);
	}
	
	  public void recoverUserDelete() {
		  if (deleteconfirmModalMessage.getText().equals("Are you sure you want to delete this user?")) {
				confirmModalOkBtn.click();
			} else {
				confirmModalCancelBtn.click();
			}
	   }
}
