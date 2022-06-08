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

public class RecoveryUser_AddStockCompInventory {
	public WebDriver driver;

	public RecoveryUser_AddStockCompInventory(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='txtUser'] [@id='txtUser']") WebElement userName;
	@FindBy(xpath="//div[@id='changeUserRole']/ul/li/a/span") public WebElement role;
	@FindBy(xpath = "//*[@id=\"sidebar-wrapper\"]/ul/li[3]") public WebElement ManageStockMouseHover;
	@FindBy(xpath="//span[contains(text(),'Component Inventory')]") public WebElement compInventory;
	@FindBy(xpath = "//span[contains(text(),'Component Replenishment')]")public WebElement compReplenishment;
	@FindBy(xpath="//input[contains(@name,'txtSearch') and @id='Body_txtSearch']")
	public WebElement searchArticleComponentTxt;
	@FindBy(xpath="//input[contains(@name,'btnSearch') and @id='Body_btnSearch']")
	public WebElement searchArticleComponentBtn;
	@FindBy(xpath = "//div[@class = 'col-md-12 col-sm-12 col-lg-8 searchFormArea']/input[@type='submit']") public WebElement SearchButtonAddStock;
	@FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer Component')]//thead//tr//th[contains(text(),'Part No')]") public WebElement partNoHeading;
    @FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr[1]//td[6]//span[@title='Add stock']") public WebElement addStock;
	@FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr[1]//td//div[@title='Link/Unlink component(s)']") public WebElement linkUnlinkFirstRowButton;
	@FindBy(xpath="//input[@id='Modal_SearchArticleTxt']") public WebElement searchCompTolinkUnlinkTextbox;
	@FindBy(xpath="//button[@id='btnSerch']") public WebElement searchCompToLinkUnlinkBtn;
	@FindBy(xpath="//input[@id='btnConfirm' and @value='GO']") public WebElement GoBtnToLink;
	@FindBy(xpath="//p[contains(text(),'Invalid Article.')]") public WebElement invalidArticleWhenLink;
	@FindBy(xpath="(//input[@type='radio' and @name='Unlink'])[2]") public WebElement unlinkRadioBtn;
	@FindBy(xpath="//input[@id='btnConfirm' and @value='GO']") public WebElement goBtn;
	@FindBy(xpath="//select[@id='Modal_ddlLocation']") public WebElement location;
	@FindBy(xpath="//input[@id='txtQty']") public WebElement quantity;
	@FindBy(xpath="//button[contains(@class,'StockSave') and contains(text(),'Save')]") public WebElement saveBtn;
	@FindBy(xpath="//div[@id='UpdateStockModal']//select[@id='Modal_ddlReason']") public WebElement removeReason;
	@FindBy(xpath="(//div[@title='Issue Report'])[1]") public WebElement issueReportBtn;
	@FindBy(xpath="//select[@id='Modal_ddlUnlinkRequestReason']") public WebElement issueReportReason;
	@FindBy(xpath="//textarea[@id='Modal_txtUnlinkRequest']") public WebElement issueReportText;
	@FindBy(xpath="//button[normalize-space(.)='OK' and @onclick='UnlinkRequest()']") public WebElement issueReportOk;
	@FindBy(xpath="//p[contains(text(),'Issue Request against this partNo is already exist')]") public WebElement existIssueMsg;
	@FindBy(xpath="//button[@class='btn btn-ikeabrn Alert' and normalize-space(.)='OK']//ancestor::div//button[@class='close']//span") public WebElement closeExistIssueMsg;
	@FindBy(xpath="//a[@title='Add New Spare Part']") public WebElement addNewSparePartBtn;
	@FindBy(xpath="//a[@title='Pia-Facts']") public WebElement piaFactsBtn;
	@FindBy(xpath="//select[@id='Modal_ddlGenericPartDesc']") public WebElement partDesc;
	@FindBy(xpath="//input[@id='Modal_PartAndPosition']") public WebElement partPositionTxtBx;
	@FindBy(xpath="//input[@id='Modal_Measurement']") public WebElement measurementTxtBx;
	@FindBy(xpath="//input[@id='Modal_Color']") public WebElement colorTxtBx;
	@FindBy(xpath="//button[normalize-space(.)='Save' and contains(@onclick,'ConfirmSavePart')]") public WebElement saveBttn;
	@FindBy(xpath="//div[contains(text(),'It looks like this N Component you are trying to create already exist')]") public WebElement addDuplicateNCompMsg;
	@FindBy(xpath="//button[normalize-space(.)='OK' and contains(@onclick,'SavePart')]") public WebElement okSaveNDuplicateComp;
	@FindBy(xpath="//button[@class='btn btn-ikeabrn confirm' and normalize-space(.)='OK']//ancestor::div//button[@class='close']//span") public WebElement closeUploadImgWindow;
	@FindBy(xpath="//p[contains(text(),'Component Created Successfully!!')]") public WebElement msgSuccessAddNewSparePart;
	@FindBy(xpath="(//div[contains(@class,'EditNComp')])[1]") public WebElement editNComp;
	@FindBy(xpath="//button[contains(text(),'Update')]") public WebElement updateNComp;
	@FindBy(xpath="//button[normalize-space()='OK' and @class='btn btn-ikeabrn confirm']")  public WebElement deleteNComp;
	public void searchInManageStockToInventory() throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Repeater1_SwitchUserRole_1' and normalize-space()='Recovery']")).click();
		Actions ac = new Actions(driver);
		ac.moveToElement(ManageStockMouseHover).perform();
//		driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[3]/ul/li[1]/a")).click();
		compInventory.click();
		Thread.sleep(2000);
		searchArticleComponentTxt.sendKeys("pax");
		Thread.sleep(2000);
		searchArticleComponentBtn.click();
	}
	public void addStock() throws InterruptedException {
		int rowNos=driver.findElements(By.xpath("//table[@id='tbl_Articles']/tbody/tr")).size();
		int firstExpandableRow=0;
		String partno1=null;
		int  beforeStockCount;
		int afterStockCount;
		for(int i=1;i<=rowNos;i++) {
			driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
			if(partNoHeading.isDisplayed()) {
				firstExpandableRow=i;
				System.out.println("the first part-decribed row is "+firstExpandableRow);
//				partno1=driver.findElement(By.xpath("((//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody)["+Integer.toString(i)+"]//tr)[1]//td[2]")).getText();
				partno1=driver.findElement(By.xpath("(//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr)[1]//td[2]")).getText();
				break;
          	}
        }
		beforeStockCount=Integer.parseInt(driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(firstExpandableRow)+"]//td[5]")).getText().trim());
		addStock.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		if(beforeStockCount==0){
			Select location= new Select(driver.findElement(By.xpath("//select[@id='Modal_ddlLocation']")));
			location.selectByIndex(5);
		}
		quantity.sendKeys("10");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", saveBtn);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(firstExpandableRow)+"]/td[1]")).click();
		afterStockCount=Integer.parseInt(driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(firstExpandableRow)+"]//td[5]")).getText().trim());
		Assert.assertEquals(beforeStockCount+10, afterStockCount);
		
	}
}
	
	

	
