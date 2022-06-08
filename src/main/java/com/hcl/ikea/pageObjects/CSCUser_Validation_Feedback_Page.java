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

public class CSCUser_Validation_Feedback_Page {

	public WebDriver driver;
	public CSCUser_Validation_Feedback_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='changeUserRole']/ul/li/a/span")public WebElement role;
	@FindBy(xpath="//input[@name='ctl00$Body$txtSearch' and @id='Body_txtSearch']")public WebElement searchTextField;
	@FindBy(xpath="//input[@name='ctl00$Body$btnSearch' and @id='Body_btnSearch']")public WebElement searchButton;
	//@FindBy(xpath="//input[@name='txtUser'] [@id='txtUser']")public WebElement userName;
	@FindBy(xpath="//img[@id='Body_imgFeedback']") public WebElement feedbackIcon;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr//td[text()='No Records Found']") public WebElement NoNewRequest;
	@FindBy(xpath="//textarea[@id='txtNoActionComment']") public WebElement commentBox;
	@FindBy(xpath="//h4[@id='FeedbackModalLabel']") public WebElement feedbackPage;
	@FindBy(xpath="//span[@title='Search' and text()='Search']") public WebElement searchTab;
	@FindBy(xpath="//div[@id='FeedbackModal']/div[2]/div/div[3]/button[1]") public WebElement okCTA;
	@FindBy(xpath="//div[@id='FeedbackModal']/div[2]/div/div[3]/button[2]") public WebElement cancelCTA;
	@FindBy(xpath="//select[@id='Modal_ddlNoActionReason']") public WebElement requestReason;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[1]//td[1]") public WebElement chevronFirstNewRqst;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[1]//td[2]") public WebElement firstRequestId;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[contains(@class,'selected')]//td//div[@title='Cancel']") public WebElement cancelBtn;
	@FindBy(xpath="//button[@class='btn btn-ikeabrn confirm' and normalize-space()='OK']")public WebElement okBtn;
	
	public void validateFeedbackPage() throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='Repeater1_SwitchUserRole_3']")).click();
		Thread.sleep(2000);
		action.moveToElement(searchTab);
		searchTab.click();
		Thread.sleep(2000);
		searchTextField.sendKeys("pax");
		searchButton.click();
		Thread.sleep(4000);
		Actions act = new Actions(driver);
		act.moveToElement(feedbackIcon);
		feedbackIcon.click();
		Thread.sleep(3000);
		Select sel = new Select(requestReason);
		sel.selectByValue("10");
		Thread.sleep(1000);
		commentBox.sendKeys("abcd12345");
		if(feedbackPage.isDisplayed()) {
			okCTA.click();
		}else {
			cancelCTA.click();
		}
		
	}
}