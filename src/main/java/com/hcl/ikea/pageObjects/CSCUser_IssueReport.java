package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CSCUser_IssueReport {

	public WebDriver driver;
	public static int firstExpandableRow=1;
	public CSCUser_IssueReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='changeUserRole']/ul/li/a/span")public WebElement role;
	@FindBy(xpath="//input[contains(@name,'txtSearch') and @id='Body_txtSearch']")
	public WebElement searchArticleComponentTxt;
	@FindBy(xpath="//input[contains(@name,'btnSearch') and @id='Body_btnSearch']")
	public WebElement searchArticleComponentBtn;
	@FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer Component')]//thead//tr//th[contains(text(),'Part No')]")public WebElement partNoHeading;
	@FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer')]//thead//th[text()='Store']")public WebElement Store;
	@FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer')]//thead//th[text()='Store']//parent::tr//parent::thead//parent::table//tbody//tr[1]//td[6]//div[@title='ASAP']")
	public WebElement icompBtn;
	@FindBy(xpath="(//div[@title='Issue Report'])[1]") public WebElement issueReportBtn;
	@FindBy(xpath="//select[@id='Modal_ddlUnlinkRequestReason']") public WebElement issueReportReason;
	@FindBy(xpath="//textarea[@id='Modal_txtUnlinkRequest']") public WebElement issueReportText;
	@FindBy(xpath="//button[normalize-space(.)='OK' and @onclick='UnlinkRequest()']") public WebElement issueReportOk;
	@FindBy(xpath="//p[contains(text(),'Issue Request against this partNo is already exist')]") public WebElement existIssueMsg;
	@FindBy(xpath="//button[@class='btn btn-ikeabrn Alert' and normalize-space(.)='OK']//ancestor::div//button[@class='close']//span") public WebElement closeExistIssueMsg;
	public void cscIssueReport() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@id,'Repeater1_SwitchUserRole') and normalize-space()='CSC']")).click();
		Thread.sleep(2000);
		searchArticleComponentTxt.sendKeys("pax");
		searchArticleComponentBtn.click();
		Thread.sleep(3000);
		int rowNos= driver.findElements(By.xpath("//*[@id='tbl_Articles']/tbody/tr")).size();
//		int firstExpandableRow=0;
		for(int i=firstExpandableRow;i<=rowNos;i++) {
			driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
			try {	
			if(partNoHeading.isDisplayed()) {
					firstExpandableRow=i;
					System.out.println("the first part-decribed row is "+firstExpandableRow);
					int compRowNos=driver.findElements(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr ")).size();
					for(int j=1;j<=compRowNos;j++) {
						driver.findElement(By.xpath("(//div[@title='Issue Report'])["+Integer.toString(j)+"]")).click();
						Thread.sleep(5000);
						Select reason= new Select(issueReportReason);
						reason.selectByIndex(1);
						issueReportText.sendKeys("test");
						issueReportOk.click();
						Thread.sleep(6000);
						try {
							if(existIssueMsg.isDisplayed()) { 
							System.out.println("Issue Request against this partNo is already exists to RecoveryAdmin!");
//							driver.findElement(By.xpath("//button[@class='btn btn-ikeabrn Alert' and normalize-space(.)='OK']")).click();
							closeExistIssueMsg.click();	
                            if(j==compRowNos) {
                            	driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(firstExpandableRow)+"]/td[1]")).click();
                            	firstExpandableRow=firstExpandableRow+1;
                            	cscIssueReport();
						    }
						}
						}catch(Exception e) {
							break;
						}	
					}
	         }
			}
			catch(Exception e) {
				
			 }
			break;
		}
				
		}
   }

