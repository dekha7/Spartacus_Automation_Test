package com.hcl.ikea.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RecoveryUserOrAdminClearStockScreen_ValidateAddLabel {

	public WebDriver driver;
	public RecoveryUserOrAdminClearStockScreen_ValidateAddLabel(WebDriver driver) {
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
	@FindBy(xpath="//div[@class='container']//span[@title='Stock Clear Count']")
	//input[@title='Logout']//parent::div//span[@title='Stock Clear Count']
	//input[@title='Logout']//preceding-sibling::span[@title='Stock Clear Count']
	public WebElement stockClearCountIcon;
	@FindBy(xpath="//div[contains(text(),'Clear Stock Management')]")
	public WebElement clearStockManagementText;
	@FindBy(xpath="//input[contains(@title,'Select entries')]//preceding::label")
	public WebElement selectAllChkBox;
	
	public void validateAddLabel() throws Exception {
		Actions action = new Actions(driver);
		int x = stockClearCountIcon.getLocation().getX();
		int y = stockClearCountIcon.getLocation().getY();
		System.out.println("x : "+x+" y: "+y);
		action.moveToElement(stockClearCountIcon, x, y).click(stockClearCountIcon);
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,30); 
        wait.until(ExpectedConditions.elementToBeClickable(stockClearCountIcon));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		Thread.sleep(5000);
		for(int i=0;i<5;i++) {
			jse.executeScript("arguments[0].click()", stockClearCountIcon);
			}
	     wait.until(ExpectedConditions.visibilityOf(clearStockManagementText));
		clearStockManagementText.isDisplayed();
		List<WebElement> labels=driver.findElements(By.xpath("//input[contains(@title,'Select entries')]//preceding::label"));
		int size=labels.size();
		for(int i=0;i<size;i++ ) {
			String lbl=labels.get(i).getText();
			if(lbl.contains("Select All")) {
				Assert.assertTrue(true);
				break;
			}else if(i==size-1) {
				Assert.assertTrue(false);
			}
		}
	}
}
