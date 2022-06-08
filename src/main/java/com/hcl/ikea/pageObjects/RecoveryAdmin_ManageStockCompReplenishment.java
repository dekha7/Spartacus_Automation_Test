package com.hcl.ikea.pageObjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RecoveryAdmin_ManageStockCompReplenishment {
	public WebDriver driver;

	public RecoveryAdmin_ManageStockCompReplenishment(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='txtUser'] [@id='txtUser']") WebElement userName;
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
	@FindBy(xpath="(//div[@title='Update Stock'])[1]") public WebElement updateStockBtn; 
	@FindBy(xpath="(//button[@class='btn btn-ikeabrn confirm'])[1]") public WebElement okToUpdateStock;
	@FindBy(xpath="(//input[@name='txtNewStock'])[1]") public WebElement upStockTxtBx;
	@FindBy(xpath="//input[contains(@id,'email')]") public WebElement emailToPiafact;
	@FindBy(xpath="//span[contains(@class,'submit') and normalize-space(.)='Log In']") public WebElement loginBtnToPiafact;
	public void searchInManageStockToReplenishment() throws InterruptedException {
		Actions ac = new Actions(driver);
		ac.moveToElement(ManageStockMouseHover).perform();
		Thread.sleep(5000);
//		driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[3]/ul/li[1]/a")).click();
		compReplenishment.click();
		searchArticleComponentTxt.sendKeys("pax");
		searchArticleComponentBtn.click();
	}
	public void linkComponent() throws InterruptedException {
		int rowNos=driver.findElements(By.xpath("//table[@id='tbl_Articles']/tbody/tr")).size();
		int firstExpandableRow=0;
		String partno1=null;
		String articleNo=null;
		WebElement linkUnlinkBtn;
		for(int i=1;i<=rowNos;i++) {
			driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
			if(partNoHeading.isDisplayed()) {
				firstExpandableRow=i;
				System.out.println("the first part-decribed row is "+firstExpandableRow);
				partno1=driver.findElement(By.xpath("((//table[contains(@id,'DataTables_Table')]//tbody)["+Integer.toString(i)+"]//tr)[1]//td[2]")).getText();
				articleNo=driver.findElement(By.xpath("(//table[@id='tbl_Articles']//tbody//tr//td[contains(@class,' col-md-2 full-width fixLineHeight paddingFix')])["+Integer.toString(i+1)+"]")).getText();
				System.out.println("the partno for which link be done"+partno1);
				System.out.println("the Article No for which component should be linked"+articleNo);
				break;
			}
		}
		linkUnlinkBtn=driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(firstExpandableRow)+"]//td//div[@title='Link/Unlink component(s)']"));
//		linkUnlinkFirstRowButton.click();
		linkUnlinkBtn.click();
		searchCompTolinkUnlinkTextbox.sendKeys(articleNo);
		searchCompToLinkUnlinkBtn.click();
		Thread.sleep(12000);
		try {
		boolean invalidArticle=invalidArticleWhenLink.isDisplayed();
		System.out.println("Component is already present in the article");
		}
		catch(Exception e) {
		Thread.sleep(10000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement elem= driver.findElement(By.xpath("(//input[@type='checkbox' and @data-newarticleno='"+articleNo+"'])[2]"));
		System.out.println("The xpath for chkbx is : "+"(//input[@type='checkbox' and @data-newarticleno='"+articleNo+"'])[2]");
		jse.executeScript("arguments[0].click()", elem);
		GoBtnToLink.click();
		}
		
	}
	public void unLinkComponent() throws InterruptedException {
		int rowNos=driver.findElements(By.xpath("//table[@id='tbl_Articles']/tbody/tr")).size();
		int firstExpandableRow=0;
		String partno1=null;
		WebElement linkUnlinkBtn;
		for(int i=1;i<=rowNos;i++) {
			driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
			boolean partHeadingDisplay=false;
			try {
			 partHeadingDisplay = partNoHeading.isDisplayed();
			}catch(Exception e) {
				System.out.println("there is no component in the article row no"+i);
			}
			if(partHeadingDisplay) {
				firstExpandableRow=i;
				System.out.println("the first part-decribed row is "+firstExpandableRow);
				partno1=driver.findElement(By.xpath("(//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr)[1]//td[2]")).getText();
				break;
          	}
      }
		linkUnlinkBtn=driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(firstExpandableRow)+"]//td//div[@title='Link/Unlink component(s)']"));
		linkUnlinkBtn.click();
		unlinkRadioBtn.click();
		goBtn.click();
	  }
	
	public void addStockForWithOutLocationStock() throws InterruptedException {
		int rowNos=driver.findElements(By.xpath("//table[@id='tbl_Articles']/tbody/tr")).size();
		int firstExpandableRow=0;
		int compRowNos= 0;
		int componentRow=0;
		String partno1=null;
		int beforeStockCount=0;
		String location="";
		int afterStockCount;
		Thread.sleep(3000);
		for(int i=1;i<=rowNos;i++) {
			driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
//			boolean isexpandable = false;
			Thread.sleep(3000);
			try {
				if(partNoHeading.isDisplayed()) {
					firstExpandableRow=i;
					compRowNos=driver.findElements(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr")).size();
					break;
				}
				
			}catch(Exception e) {
				System.out.println("no components are there in the row no : "+i);
			}
        }
		for(int j=1;j<=compRowNos;j++) {
			beforeStockCount=Integer.parseInt(driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(j)+"]//td[5]")).getText().trim());
			location=driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(j)+"]//td[4]")).getText();
			int locationLenght= location.length();
			if(beforeStockCount==0 && locationLenght==0){
				componentRow=j;
				System.out.println("1st part of 0 stock row : "+componentRow+"before stock no"+beforeStockCount+"location is"+locationLenght);
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click()", driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(j)+"]//td[6]//span[@title='Add stock']")));
//				driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(j)+"]//td[6]//span[@title='Add stock']")).click();
				Thread.sleep(5000);
				Select locationDrpDwn= new Select(driver.findElement(By.xpath("//select[@id='Modal_ddlLocation']")));
				locationDrpDwn.selectByIndex(5);
				quantity.sendKeys("10");
				saveBtn.click();
				Thread.sleep(5000);
				break;
		    }
		}
		driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(firstExpandableRow)+"]/td[1]")).click();
		Thread.sleep(5000);
		afterStockCount=Integer.parseInt(driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(componentRow)+"]//td[5]")).getText().trim());
		Assert.assertEquals(beforeStockCount+10, afterStockCount);
	}
	
	public void addStockWithLocationStock() throws InterruptedException {
		int rowNos=driver.findElements(By.xpath("//table[@id='tbl_Articles']/tbody/tr")).size();
		int firstExpandableRow=0;
		int compRowNos= 0;
		int componentRow=0;
		String partno1=null;
		int beforeStockCount=0;
		int afterStockCount;
		Thread.sleep(3000);
		for(int i=1;i<=rowNos;i++) {
			driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
			try {
				if(partNoHeading.isDisplayed()) {
					firstExpandableRow=i;
					compRowNos=driver.findElements(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr")).size();
					break;
				}
				
			}catch(Exception e) {
				System.out.println("no components are there in the row no : "+i);
			}
        }
		for(int j=1;j<=compRowNos;j++) {
			beforeStockCount=Integer.parseInt(driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(j)+"]//td[5]")).getText().trim());
			if(beforeStockCount!=0){
			   componentRow=j;
			   driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(j)+"]//td[6]//div //input[@name='txtNewStock']")).sendKeys("6");
			   for(int k=0;k<5;k++) {
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("arguments[0].click()", driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(j)+"]//td[6]//span[@title='Up']")));
//				driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(j)+"]//td[6]//span[@title='Up']")).click();
				}
				updateStockBtn.isDisplayed();
//				updateStockBtn.click();
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click()",updateStockBtn);
				Thread.sleep(5000);
				okToUpdateStock.click();
				break;
		    }
		}
		Thread.sleep(10000);
		driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(firstExpandableRow)+"]/td[1]")).click();
		Thread.sleep(5000);
		afterStockCount=Integer.parseInt(driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(componentRow)+"]//td[5]")).getText().trim());
		Assert.assertEquals(beforeStockCount+11, afterStockCount);	
	}
	
	public void alphabtSpclCharInUpTestBox() throws InterruptedException {
		int rowNos=driver.findElements(By.xpath("//table[@id='tbl_Articles']/tbody/tr")).size();
		int firstExpandableRow=0;
		int compRowNos= 0;
		int componentRow=0;
		String partno1=null;
		int beforeStockCount=0;
		int afterStockCount;
		Thread.sleep(3000);
		for(int i=1;i<=rowNos;i++) {
			driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
			boolean isexpandable = false;
			try {
				isexpandable = partNoHeading.isDisplayed();
			}catch(Exception e) {
				System.out.println("no components are there in the row no : "+i);
			}
			if(isexpandable) {
				firstExpandableRow=i;
				System.out.println("the first part-decribed row is "+firstExpandableRow);
				compRowNos=driver.findElements(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr")).size();
//				partno1=driver.findElement(By.xpath("((//table[contains(@id,'DataTables_Table')]//tbody)["+Integer.toString(i)+"]//tr)[1]//td[2]")).getText();
				partno1=driver.findElement(By.xpath("(//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr)[1]//td[2]")).getText();
				System.out.println("partno: "+partno1);
				break;
          	}
        }
		for(int j=1;j<=compRowNos;j++) {
			beforeStockCount=Integer.parseInt(driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(j)+"]//td[5]")).getText().trim());
			if(beforeStockCount!=0){
				componentRow=j;
				upStockTxtBx.sendKeys("@#$");
				Thread.sleep(5000);
				Assert.assertEquals(upStockTxtBx.getAttribute("value"), "0");
				upStockTxtBx.clear();
				upStockTxtBx.sendKeys("abc");
				Assert.assertEquals(upStockTxtBx.getAttribute("value"), "");
				upStockTxtBx.clear();
				upStockTxtBx.sendKeys("a@A");
				Assert.assertEquals(upStockTxtBx.getAttribute("value"), "");
			}
		}
	}
	
	
	public void max3DigitInUPdateStockTextBox() throws InterruptedException{
	int rowNos=driver.findElements(By.xpath("//table[@id='tbl_Articles']/tbody/tr")).size();
	int firstExpandableRow=0;
	int compRowNos= 0;
	int componentRow=0;
	String partno1=null;
	int beforeStockCount=0;
	int afterStockCount;
	Thread.sleep(3000);
	for(int i=1;i<=rowNos;i++) {
		driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
		boolean isexpandable = false;
		try {
			isexpandable = partNoHeading.isDisplayed();
		}catch(Exception e) {
			System.out.println("no components are there in the row no : "+i);
		}
		if(isexpandable) {
			firstExpandableRow=i;
			System.out.println("the first part-decribed row is "+firstExpandableRow);
			compRowNos=driver.findElements(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr")).size();
//			partno1=driver.findElement(By.xpath("((//table[contains(@id,'DataTables_Table')]//tbody)["+Integer.toString(i)+"]//tr)[1]//td[2]")).getText();
			partno1=driver.findElement(By.xpath("(//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr)[1]//td[2]")).getText();
			System.out.println("partno: "+partno1);
			break;
      	}
    }
	for(int j=1;j<=compRowNos;j++) {
		beforeStockCount=Integer.parseInt(driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(j)+"]//td[5]")).getText().trim());
		if(beforeStockCount!=0){
			componentRow=j;
			upStockTxtBx.sendKeys("1234");
			Thread.sleep(5000);
			Assert.assertEquals(upStockTxtBx.getAttribute("value"), "123");
			Assert.assertNotEquals(upStockTxtBx.getAttribute("value"), "1234");
			upStockTxtBx.clear();
			upStockTxtBx.sendKeys("998");
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(j)+"]//td[6]//span[@title='Up']")));
			Assert.assertEquals(upStockTxtBx.getAttribute("value"), "999");
			jse.executeScript("arguments[0].click()", driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(j)+"]//td[6]//span[@title='Up']")));
			Assert.assertEquals(upStockTxtBx.getAttribute("value"), "999");
			
		}
	}
}

	public void deleteNComp() throws InterruptedException {
		int rowNos=driver.findElements(By.xpath("//table[@id='tbl_Articles']/tbody/tr")).size();
		int firstExpandableRow=0;
		int firstNCompRow=0;
		int compRowNos=0;
		String partno=null;
		boolean stockExistOtherStore =false;
		for(int i=1;i<=rowNos;i++) {
			driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
				if(partNoHeading.isDisplayed()) {
					firstExpandableRow=i;
					compRowNos=driver.findElements(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr ")).size();
					for(int j=1;j<=compRowNos;j++) {
					  partno=driver.findElement(By.xpath("(//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr)["+Integer.toString(j)+"]//td[2]")).getText();	
//					  partno=driver.findElement(By.xpath("((//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody)["+Integer.toString(i)+"]//tr)["+Integer.toString(j)+"]//td[2]")).getText();
					  int beforeStockCount=Integer.parseInt(driver.findElement(By.xpath("(//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(j)+"]//td[5])")).getText().trim());
					  System.out.println("the part no is "+partno+" and the before stock count is " +beforeStockCount);

					  if(partno.startsWith("N") && (beforeStockCount==0) ) {
						  firstNCompRow=j;
						  driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(firstNCompRow)+"]//td[6]//span[@title='Delete Component']")).click();
						  deleteNComp.click();
						  
						  try {
							  stockExistOtherStore= driver.findElement(By.xpath("//div[contains(text(),'The stock for this component exists in')]")).isDisplayed();
						  if(stockExistOtherStore) {
							  driver.findElement(By.xpath("//button[@id='btnOK']")).click();
							  driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(firstExpandableRow)+"]/td[1]")).click();
      				 	  }else {
      				 		  break;
      				 	  }
						  }
						  catch(Exception e)
						  {  
						  }
	                  }
					}
			           break;
			    }
		}
		if(stockExistOtherStore) {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(firstExpandableRow)+"]/td[1]")).click();
		for(int k=1;k<=compRowNos-1;k++) {
			String partnoAfterDelete=driver.findElement(By.xpath("(//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr)["+Integer.toString(k)+"]//td[2]")).getText();
//			String partnoAfterDelete=driver.findElement(By.xpath("((//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody)["+Integer.toString(firstExpandableRow)+"]//tr)["+Integer.toString(k)+"]//td[2]")).getText();
		    if(partnoAfterDelete.equalsIgnoreCase(partno)) {
		    	Assert.assertTrue(false);
		    }
		}
	  }
	}
	
	public void issueReport() throws InterruptedException {
		int rowNos=driver.findElements(By.xpath("//table[@id='tbl_Articles']/tbody/tr")).size();
		int firstExpandableRow=0;
		for(int i=1;i<=rowNos;i++) {
			driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
				if(partNoHeading.isDisplayed()) {
					firstExpandableRow=i;
					System.out.println("the first part-decribed row is "+firstExpandableRow);
					int compRowNos=driver.findElements(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr ")).size();
					for(int j=1;j<=compRowNos;j++) {
						driver.findElement(By.xpath("(//div[@title='Issue Report'])["+Integer.toString(j)+"]")).click();
						Thread.sleep(5000);
						Select reason= new Select(issueReportReason);
						reason.selectByIndex(2);
						issueReportText.sendKeys("test");
						issueReportOk.click();
						if(existIssueMsg.isDisplayed()) { 
							System.out.println("Issue Request against this partNo is already exists to RecoveryAdmin!");
//							driver.findElement(By.xpath("//button[@class='btn btn-ikeabrn Alert' and normalize-space(.)='OK']")).click();
							closeExistIssueMsg.click();	
						}
						else {
							break;
						}
					}
	       }
				break;
		}
	}
	public void addNewSparePart() throws InterruptedException {
		int rowNos=driver.findElements(By.xpath("//table[@id='tbl_Articles']/tbody/tr")).size();
		int firstExpandableRow=0;
		for(int i=1;i<=rowNos;i++) {
			driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
			try {	
				boolean isArticleExpand=partNoHeading.isDisplayed();
			if(isArticleExpand) {
				driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
				Thread.sleep(3000);
			 }
		}
			catch(Exception e){
				driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[5]//a[@title='Add New Spare Part']")).click();
				Select partDes = new Select(partDesc);
				partDes.selectByIndex(10);
				partPositionTxtBx.sendKeys("upper");
				measurementTxtBx.sendKeys("12.24.36");
				colorTxtBx.sendKeys("Blue");
				saveBttn.click();
				Thread.sleep(5000);
				if(msgSuccessAddNewSparePart.isDisplayed()) {
					Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);
				}
				closeUploadImgWindow.click();
				break;
			}
		  }
	}
	public void piaFact() throws InterruptedException {
		String mainWindow= driver.getWindowHandle();
     	piaFactsBtn.click();
     	Thread.sleep(5000);
     	Set<String> s1= driver.getWindowHandles();
     	for(String s: s1) {
     		if(!s.equalsIgnoreCase(mainWindow)) {
     			driver.switchTo().window(s);
     			if(driver.getTitle().contains("Sign In with Auth")) {
     				emailToPiafact.sendKeys("sourab.jhariat@ingka.com");
     				loginBtnToPiafact.click();
     				Thread.sleep(10000);
     			}
     			Assert.assertEquals(driver.getTitle(), "PIA Facts");
     		}
     	}
     	
	}
}
