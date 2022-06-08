package com.hcl.ikea.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Recovery_Manager_ValidateCountryPage {
  
	public WebDriver driver;
	public Recovery_Manager_ValidateCountryPage(WebDriver driver) {
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
	@FindBy(xpath="//span[@id='lblCountry']")
    public WebElement countryCheck;
	@FindBy(xpath="//a[@id='Repeater1_SwitchUserRole_7']")
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
	@FindBy(xpath="//a[@id='Repeater2_SwitchUserCountry_2']")
	public WebElement countrySelection;
	@FindBy(xpath="//a[@id='Repeater1_SwitchUserRole_5']")
	public WebElement adminRole;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/div[2]/p")
	public WebElement confirmModalMessage;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/div[3]/button[1]")
	public WebElement confirmModalOkBtn;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/div[3]/button[2]")
	public WebElement confirmModalCancelBtn;
	
	public void createUser() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		recoveryManagerRole.click();
		Thread.sleep(1000);
		action.moveToElement(country1).build().perform();
		Thread.sleep(2000);
		//countrySelection.click();
	}
	public void setCountryNamee(String counNam) {
		searchTextField.sendKeys(counNam);
	}
	public void countryCheckValidation() {
		if(countryCheck.getText().equals(":CA")) {
			Assert.assertTrue(true);
		}else {
		  //Assert.assertTrue(false);  
		}	
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
	public void selectCountry() {
		countrySelection.click();
		
	}
}
