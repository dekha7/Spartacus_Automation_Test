package com.hcl.ikea.pageObjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sparta_263_CureUser_NewLinkPiaFactsPage {
  
	public WebDriver driver;
	public Sparta_263_CureUser_NewLinkPiaFactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='changeUserRole']/ul/li/a/span")
	public WebElement role;
	@FindBy(xpath="//input[@name='ctl00$Body$txtSearch' and @id='Body_txtSearch']")
	public WebElement searchTextField;
	@FindBy(xpath="//input[@name='ctl00$Body$btnSearch' and @id='Body_btnSearch']")
	public WebElement searchButton;
	@FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer Component')]//thead//tr//th[contains(text(),'Part No')]")
	public WebElement partNoHeading;
	@FindBy(xpath="//div[@id='changeUserCountry']/ul/li/a/span")
	public WebElement country;
	@FindBy(xpath="ctl00$ddlStore")
    public WebElement storeID;
	@FindBy(xpath="//*[@id='modalRequest']/div[2]/div/div[3]/button[2]")
    public WebElement gotoRequestForm;
	@FindBy(xpath="//*[@id='Body_rptPartDetail_txtQty_0']")
	public WebElement quantity;
	@FindBy(xpath="//*[@id='Body_txtComment']")
	public WebElement comment;
	@FindBy(xpath="//*[@id='Body_ddlRequestReason']")
	public WebElement reason;
	@FindBy(xpath="//*[@id='Body_btnRequest']")
	public WebElement sendToRecovery;
	@FindBy(xpath="//h4[@class='modal-title' and @id='confirm-label']")
	public WebElement confirmModal;
	@FindBy(xpath="//table[@id='tbl_Articles']/tbody/tr[1]/td[5]/a")
	public WebElement piaFactLink;
	@FindBy(xpath="//input[@id='1-email']")
	public WebElement inputField;
	@FindBy(xpath="//span[text()='Log In']")
	public WebElement logInBtn;

	public void piaFactsNewLink() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Repeater1_SwitchUserRole_2']")).click();
		//role.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
		Thread.sleep(1000);
		action.moveToElement(country).build().perform();
		Thread.sleep(2000);
		//country.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='Repeater2_SwitchUserCountry_0' and text()='AUSTRIA']")).click();
		Thread.sleep(2000);
		searchTextField.sendKeys("pax");
		searchButton.click();
		Thread.sleep(3000);
		int rowNos= driver.findElements(By.xpath("//*[@id='tbl_Articles']/tbody/tr")).size();
		WebElement expandBtn;
		for(int i=1; i<=rowNos; i++) {
		    expandBtn=driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]"));
		    if(expandBtn.isDisplayed()) {
				piaFactLink.click();
				break;
		    }else {
		    	System.out.println("Pia fact button is not available for expendable row");
		    }
		}
		Thread.sleep(25000);
		String parentWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		for(String s:s1) {
			if(!s.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(s);
				Thread.sleep(2000);
				break;
	}
		}
	}
	public void setPiaFactUserID(String piaLoginID) throws InterruptedException {
		inputField.sendKeys(piaLoginID);
		logInBtn.click();
		Thread.sleep(10000);
		if(driver.getTitle().equals("PIA Facts")) {
			driver.quit();
		}
		//String parentWindow = driver.getWindowHandle();
		//driver.switchTo().window(parentWindow);
 }
}
