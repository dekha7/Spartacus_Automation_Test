package com.hcl.ikea.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Administration_SearchFunctionality_AddingNewStorePage {
  
	public WebDriver driver;
	public static String city;
	public static String storID;
	public static String postalCod;
	public Administration_SearchFunctionality_AddingNewStorePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='changeUserRole']/ul/li/a/span")
	public WebElement role;
	@FindBy(xpath="//div[@id='StoreTable_filter']/label/input")
	public WebElement searchTextField;
	@FindBy(xpath="//input[contains(@name,'txtSearch') and @id='Body_txtSearch']")
	public WebElement searchArticleComponentTxt;
	@FindBy(xpath="//input[contains(@name,'btnSearch') and @id='Body_btnSearch']")
	public WebElement searchArticleComponentBtn;
	@FindBy(xpath="//div[@id='changeUserCountry']/ul/li/a/span")
	public WebElement country1;
	@FindBy(xpath="//input[@id='Body_StoreID']")
    public WebElement storeID;
	@FindBy(xpath="//input[@id='Body_StoreName']")
    public WebElement storeName;
	@FindBy(xpath="//table[@id='StoreTable']/thead/tr/th[1]")
    public WebElement storeIDVerification;
	@FindBy(xpath="//table[@id='StoreTable']/thead/tr/th[3]")
    public WebElement postalCodeVerification;
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
	@FindBy(xpath="//table[@id='StoreTable']/tbody/tr/td[9]/span[1]")
	public WebElement editBtn;
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
	
	public void createStore() throws Exception {
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
	public void searchStore(String sName) throws Exception {
		Actions action = new Actions(driver);
		int x = searchTextField.getLocation().getX();
		System.out.println("X coordinate of searchtextField web element is "+x);
		int y = searchTextField.getLocation().getY();
		System.out.println("Y coordinate of searchtextField web element is "+y);
		action.moveToElement(searchTextField, x, y).click();
		Thread.sleep(1000);
	    searchTextField.sendKeys(sName);
	}
	public void clickEditBtn() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		int y = editBtn.getLocation().getY();
		System.out.println("Y coordinate of editBtn web element is "+y);
		jse.executeScript("window.scrollBy(0,509)", "");
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.elementToBeClickable(editBtn));
	    Thread.sleep(5000);
	    editBtn.click();
	    jse.executeScript("window.scrollBy(0,-509)", ""); 
	    //city = cityName.getText();
	    //storID = storeID.getText();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    city = js.executeScript("return document.getElementById('Body_City').value").toString();
	    storID = js.executeScript("return document.getElementById('Body_StoreID').value").toString();
	    postalCod = js.executeScript("return document.getElementById('Body_City').value").toString();
	}
	
	  public void submitClick() { 
		  submitBtn.click(); 
		  }
	 
}
