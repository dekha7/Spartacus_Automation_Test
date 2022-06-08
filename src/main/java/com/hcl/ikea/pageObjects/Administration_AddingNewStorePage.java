package com.hcl.ikea.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Administration_AddingNewStorePage {
  
	public WebDriver driver;
	public Administration_AddingNewStorePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='changeUserRole']/ul/li/a/span")
	public WebElement role;
	@FindBy(xpath="//div[@id='StoreTable_filter']/label/input")
	public WebElement searchTextField;
	@FindBy(xpath="//input[@name='ctl00$Body$btnSearch' and @id='Body_btnSearch']")
	public WebElement searchButton;
	@FindBy(xpath="//div[@id='changeUserCountry']/ul/li/a/span")
	public WebElement country1;
	@FindBy(xpath="//input[@id='Body_StoreID']")
    public WebElement storeID;
	@FindBy(xpath="//input[@id='Body_StoreName']")
    public WebElement storeName;
	@FindBy(xpath="//input[@id='Body_PostalCode']")
    public WebElement postalCode;
	@FindBy(xpath="//input[@id='Body_Street']")
    public WebElement streetName;
	@FindBy(xpath="//input[@id='Body_City']")
    public WebElement cityName;
	@FindBy(xpath="//div[@id='sidebar-wrapper']/ul/li[2]/a")
	public WebElement administration;
	@FindBy(xpath="//h4[@class='modal-title' and @id='confirm-label']")
	public WebElement confirmModal;
	@FindBy(xpath="//*[@id=\"confirm\"]/div[2]/div/div[3]/button[2]")
	public WebElement cancelBtn;
	//@FindBy(xpath="//input[@id='Body_UserName']")
	//public WebElement userNamee;
	@FindBy(xpath="//select[@id='Body_UserLevel']")
	public WebElement userRole;
	@FindBy(xpath="//select[@id='Body_CountryCode']")
	public WebElement country2;
	@FindBy(xpath="//input[@id='Body_RuCode']")
	public WebElement ruCode;
	@FindBy(xpath="//input[@id='Body_RdCode']")
	public WebElement rdCode;
	@FindBy(xpath="//input[@id='Body_UserID']")
	public WebElement userID;
	@FindBy(xpath="//input[@id='Body_RdCode']/parent::div/following-sibling::div/input[1]")
	public WebElement submitBtn;
	@FindBy(xpath="//div[@id='divCheck']/following-sibling::div/input[2]")
	public WebElement resetBtn;
	@FindBy(xpath="//div[@id='sidebar-wrapper']/ul/li[2]/ul/li[3]/a")
	public WebElement storeManagement;
	@FindBy(xpath="//a[@id='Repeater1_SwitchUserRole_5']")
	public WebElement adminRole;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/div[3]/button[1]")
	public WebElement confirmModalOkBtn;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/div[3]/button[2]")
	public WebElement confirmModalCancelBtn;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/div[2]/p")
	public WebElement confirmModalMessage;
	@FindBy(xpath="//button[contains(@class,'btn-ikeabrn Alert')]")
	public WebElement okButton;
	
	public void createUser() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		adminRole.click();
		Thread.sleep(1000);
		action.moveToElement(administration).build().perform();
		Thread.sleep(2000);
		storeManagement.click();
	}
	public void setStoreID(String sID) {
		storeID.sendKeys(sID);
	}
	public void setStoreNam(String sName) {
		storeName.sendKeys(sName);
	}
	public void setStreetNam(String streetN) {
		streetName.sendKeys(streetN);
	}
	public void setPostalCod(String posC) {
		postalCode.sendKeys(posC);
	}
	public void setCityNam(String cityN) {
		cityName.sendKeys(cityN);
	}
	public void setRuCod(String cityN) {
		ruCode.sendKeys(cityN);
	}
	public void setRdCod(String cityN) {
		rdCode.sendKeys(cityN);
	}
	public void selectCountry() {
		Select sel = new Select(country2);
	    sel.selectByValue("CA");
	}
	public void submitClick() throws Exception {
		Actions action = new Actions(driver);
		int x = submitBtn.getLocation().getX();
		System.out.println("X coordinate of submitBtn element is "+x);
		int y = submitBtn.getLocation().getY();
		action.moveByOffset(x, y).click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        Thread.sleep(6000);
		jse.executeScript("arguments[0].click()", submitBtn);
		Thread.sleep(2000);
		if(confirmModalMessage.getText().equals("Are you sure you want to add this Store?")) {
			confirmModalOkBtn.click();
        }else {
        	confirmModalCancelBtn.click();
        }
		Thread.sleep(1000);
		okButton.click();
		Thread.sleep(3000);
	}
	  public void searchStoreID(String sID) throws Exception 
	  { Actions action = new Actions(driver); 
	  int x = searchTextField.getLocation().getX();
	  System.out.println("X coordinate of searchtextField web element is "+x); 
	  int y = searchTextField.getLocation().getY();
	  System.out.println("Y coordinate of searchtextField web element is "+y);
	  action.moveToElement(searchTextField, x, y).click(); 
	  Thread.sleep(6000);
	  searchTextField.sendKeys(sID);
	  Thread.sleep(3000); 
	  }
}
