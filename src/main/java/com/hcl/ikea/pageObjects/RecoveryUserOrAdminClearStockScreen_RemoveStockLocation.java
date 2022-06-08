package com.hcl.ikea.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecoveryUserOrAdminClearStockScreen_RemoveStockLocation {

	public WebDriver driver;
	public RecoveryUserOrAdminClearStockScreen_RemoveStockLocation(WebDriver driver) {
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
	@FindBy(xpath="//input[@title='Logout']//preceding-sibling::span[@title='Stock Clear Count']")
	public WebElement stockClearCountIcon;
	@FindBy(xpath="//div[contains(text(),'Clear Stock Management')]")
	public WebElement clearStockManagementText;
	@FindBy(xpath="//input[contains(@title,'Select entries')]//preceding::label")
	public WebElement selectAllChkBox;
	@FindBy(xpath="//input[contains(@title,'Select entries')]")
	public WebElement selectAllEntries;
	@FindBy(xpath="//input[contains(@value,'Remove Stock/Location')]")
	public WebElement removeStockBtn;
	@FindBy(xpath="(//input[contains(@title,'Delete Comp')])[1]")
	public WebElement remove1stStock;
	
	public void validateRemoveStockLocation() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,30); 
        wait.until(ExpectedConditions.elementToBeClickable(stockClearCountIcon));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		Thread.sleep(5000);
		for(int i=0;i<5;i++) {
			jse.executeScript("arguments[0].click()", stockClearCountIcon);
			}
	    wait.until(ExpectedConditions.visibilityOf(clearStockManagementText));
	    Thread.sleep(6000); 
	    selectAllEntries.click();
	    Thread.sleep(4000); 
	    removeStockBtn.isDisplayed();
	    selectAllEntries.click();
	    Thread.sleep(4000); 
	    remove1stStock.click();
	    removeStockBtn.isDisplayed();
	}
}
