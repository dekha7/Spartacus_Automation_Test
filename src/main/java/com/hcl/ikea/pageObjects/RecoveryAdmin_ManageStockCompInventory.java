package com.hcl.ikea.pageObjects;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RecoveryAdmin_ManageStockCompInventory {
	public WebDriver driver;

	public RecoveryAdmin_ManageStockCompInventory(WebDriver driver) {
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
	@FindBy(xpath="//table[@id='tbl_Articles']/tbody/tr[1]/td[5]//a[@title='Add New Spare Part']") public WebElement addNewSparePart1stRow;
	@FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer Component')]//thead//tr//th[contains(text(),'Part No')]") public WebElement partNoHeading;
    @FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr[1]//td[6]//span[@title='Add stock']") public WebElement addStockForthe1stComp;
	@FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr[1]//td//div[@title='Link/Unlink component(s)']") public WebElement linkUnlinkFirstRowButton;
	@FindBy(xpath="//input[@id='Modal_SearchArticleTxt']") public WebElement searchCompTolinkUnlinkTextbox;
	@FindBy(xpath="//button[@id='btnSerch']") public WebElement searchCompToLinkUnlinkBtn;
	@FindBy(xpath="//input[@id='btnConfirm' and @value='GO']") public WebElement GoBtnToLink;
	@FindBy(xpath="//p[contains(text(),'Invalid Article.')]") public WebElement invalidArticleWhenLink;
	@FindBy(xpath="//b[text()='Unlink to article']//preceding-sibling::input[@type='radio' and @name='Unlink']") public WebElement unlinkRadioBtn;
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
	@FindBy(xpath="//div[@class='modal-body' and contains(text(),'It looks like this N Component you are trying to create already exist')]") public WebElement addDuplicateNCompMsg;
	@FindBy(xpath="//div[@class='modal-body']//div//following-sibling::br//following-sibling::h6[text()='Already present:']") public WebElement alreadyNCompPresentText;
	@FindBy(xpath="//div[contains(text(),'trying to create already exist')]//following-sibling::div//button[normalize-space(.)='OK']") public WebElement okSaveNDuplicateComp;
	@FindBy(xpath="//button[@class='btn btn-ikeabrn confirm' and normalize-space(.)='OK']//ancestor::div//button[@class='close']//span") public WebElement closeUploadImgWindow;
	@FindBy(xpath="//p[contains(text(),'Component Created Successfully!!')]") public WebElement msgSuccessAddNewSparePart;
	@FindBy(xpath="(//div[contains(@class,'EditNComp')])[1]") public WebElement editNComp;
	@FindBy(xpath="//button[contains(text(),'Update')]") public WebElement updateNComp;
	@FindBy(xpath="//button[normalize-space()='OK' and @class='btn btn-ikeabrn confirm']")  public WebElement deleteNComp;
	@FindBy(xpath="//input[contains(@id,'email')]") public WebElement emailToPiafact;
	@FindBy(xpath="//input[@id='i0116' and @type='email']") public WebElement signToPiaFact;
	@FindBy(xpath="//input[contains(@id,'email')]") public WebElement passwordToPiaFact;
	@FindBy(xpath="//input[@id='i0118' and @type='password']") public WebElement nextBtn;
	@FindBy(xpath="//span[contains(@class,'submit') and normalize-space(.)='Log In']") public WebElement loginBtnToPiafact;
	
	public void searchInManageStockToInventory() throws InterruptedException {
		Actions ac = new Actions(driver);
		ac.moveToElement(ManageStockMouseHover).perform();
//		driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[3]/ul/li[1]/a")).click();
		compInventory.click();
		searchArticleComponentTxt.sendKeys("pax");
		searchArticleComponentBtn.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='Body_btnSearch']")).click();
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
//				partno1=driver.findElement(By.xpath("((//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody)["+Integer.toString(i)+"]//tr)[1]//td[2]")).getText();
				partno1=driver.findElement(By.xpath("(//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr)[1]//td[2]")).getText();
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
		Thread.sleep(5000);
		searchCompToLinkUnlinkBtn.click();
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
			if(partNoHeading.isDisplayed()) {
				firstExpandableRow=i;
				System.out.println("the first part-decribed row is "+firstExpandableRow);
				partno1=driver.findElement(By.xpath("(//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr)[1]//td[2]")).getText();
//				partno1=driver.findElement(By.xpath("((//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody)["+Integer.toString(i)+"]//tr)[1]//td[2]")).getText();
				break;
          	}
      }
		linkUnlinkBtn=driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(firstExpandableRow)+"]//td//div[@title='Link/Unlink component(s)']"));
		linkUnlinkBtn.click();
		unlinkRadioBtn.click();
		goBtn.click();
	  }
	
	
	
	public void addStock() throws InterruptedException {
		int rowNos=driver.findElements(By.xpath("//table[@id='tbl_Articles']/tbody/tr")).size();
		int firstExpandableRow=0;
		int  beforeStockCount;
		int afterStockCount;
		for(int i=1;i<=rowNos;i++) {
			Thread.sleep(4000);
			driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
			Thread.sleep(3000);
			try {
			if(partNoHeading.isDisplayed()) {
				firstExpandableRow=i;
				System.out.println("Expanded row is "+firstExpandableRow);	
          	}
			 break;
			}catch(Exception e) {
				 
			 }
		}
		beforeStockCount=Integer.parseInt(driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr[1]//td[5]")).getText().trim());
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr[1]//td[6]//span[@title='Add stock']")));
		jse.executeScript("arguments[0].click()", addStockForthe1stComp);
		Thread.sleep(3000);
//		addStock.click();
        Select location= new Select(driver.findElement(By.xpath("//select[@id='Modal_ddlLocation']")));
        location.selectByIndex(5);
		quantity.sendKeys("2");
		saveBtn.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(firstExpandableRow)+"]/td[1]")).click();
		afterStockCount=Integer.parseInt(driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr[1]//td[5]")).getText().trim());
		Assert.assertEquals(beforeStockCount+2, afterStockCount);	
	}
	
	public void removeStock() throws InterruptedException {
		int rowNos=driver.findElements(By.xpath("//table[@id='tbl_Articles']/tbody/tr")).size();
		int firstExpandableRow=0;
		int compRowTobeStockDeleted =0;
		int  beforeStockCount=0;
		int afterStockCount;
		for(int i=1;i<=rowNos;i++) {
			driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
			try {
				if(partNoHeading.isDisplayed()) {
					firstExpandableRow=i;
					System.out.println("the first part-decribed row is "+firstExpandableRow);
					
					//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(i)+"]
					int compRowNos=driver.findElements(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr")).size();
					for(int j=1;j<=compRowNos;j++) {
						beforeStockCount=Integer.parseInt(driver.findElement(By.xpath("(//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(i)+"]//td[5])["+Integer.toString(j)+"]")).getText().trim());
						if(beforeStockCount!=0) {
							compRowTobeStockDeleted=j;
							break;
						}else {
//						    continue;
						}
					}
				break;
				}
			}
				catch(Exception e) {
					
				}
		}
				driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(compRowTobeStockDeleted)+"]//td[6]//span[@title='Remove stock']")).click();
				quantity.sendKeys("1");
				Select reason= new Select(removeReason);
				reason.selectByIndex(2);
				Thread.sleep(4000);
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click()", saveBtn);
				Thread.sleep(2000);
				//saveBtn.click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(firstExpandableRow)+"]/td[1]")).click();
				afterStockCount=Integer.parseInt(driver.findElement(By.xpath("(//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(firstExpandableRow)+"]//td[5])["+Integer.toString(compRowTobeStockDeleted)+"]")).getText().trim());
//				if()
//				partno1=driver.findElement(By.xpath("((//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody)["+Integer.toString(i)+"]//tr)[1]//td[2]")).getText();	
				System.out.println("before count "+beforeStockCount +"after count "+afterStockCount);
				Assert.assertEquals(beforeStockCount-1, afterStockCount);
 	
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
						try {
						if(existIssueMsg.isDisplayed()) { 
							System.out.println("Issue Request against this partNo is already exists to RecoveryAdmin!");
//							driver.findElement(By.xpath("//button[@class='btn btn-ikeabrn Alert' and normalize-space(.)='OK']")).click();
							closeExistIssueMsg.click();	
						}else {
							break;
						 }
						}catch(Exception e) {
							
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
		        addNewSparePart1stRow.click();
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
	
	public void editNComponent() throws InterruptedException {
		int rowNos=driver.findElements(By.xpath("//table[@id='tbl_Articles']/tbody/tr")).size();
		int firstExpandableRow=0;
		int firstNCompRow=0;
		for(int i=1;i<=rowNos;i++) {
			driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
			try {
				if(partNoHeading.isDisplayed()) {
					firstExpandableRow=i;
					int compRowNos=driver.findElements(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr ")).size();
					for(int j=1;j<=compRowNos;j++) {
					  String partno=driver.findElement(By.xpath("(//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr)["+Integer.toString(j)+"]//td[2]")).getText();	
//					  String partno=driver.findElement(By.xpath("((//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody)["+Integer.toString(i)+"]//tr)["+Integer.toString(j)+"]//td[2]")).getText();
					  if(partno.startsWith("N")) {
						  firstNCompRow=j;
						    editNComp.click();
						    Select partDes = new Select(driver.findElement(By.xpath("//select[@id='Modal_ddlGenericPartDesc1']")));
						    partDes.selectByIndex(10);
						    driver.findElement(By.xpath("//input[@id='Modal_PartAndPosition1']")).sendKeys("upper");
						    driver.findElement(By.xpath("//input[@id='Modal_Measurement1']")).sendKeys("12.24.36");
						    driver.findElement(By.xpath("//input[@id='Modal_Color1']")).sendKeys("Blue");
							updateNComp.click();
						 break; 
					  }else {
						 continue;
					  }
					}
					break;
				}
			}catch(Exception e) {
				
			}
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(firstExpandableRow)+"]/td[1]")).click();
		String partDesc= driver.findElement(By.xpath("((//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody)["+Integer.toString(firstExpandableRow)+"]//tr)["+Integer.toString(firstNCompRow)+"]//td[3]")).getText();
		System.out.println(partDesc);
	    if(partDesc.contains("upper") && partDesc.contains("12.24.36") && partDesc.contains("Blue")) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);	
	    }
	}
	
	public void deleteNComp() throws InterruptedException {
		int rowNos=driver.findElements(By.xpath("//table[@id='tbl_Articles']/tbody/tr")).size();
		int firstExpandableRow=0;
		int firstNCompRow=0;
		int compRowNos=0;
		String partno=null;
		addNewSparePart();
		Thread.sleep(5000);
		for(int i=1;i<=rowNos;i++) {
			int countOfNComp =0;
			driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr[1]/td[1]")).click();
			try {
				if(partNoHeading.isDisplayed()) {
					firstExpandableRow=i;
					compRowNos=driver.findElements(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr ")).size();
					for(int j=1;j<=compRowNos;j++) {
					  partno=driver.findElement(By.xpath("(//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr)["+Integer.toString(j)+"]//td[2]")).getText();	
//					  partno=driver.findElement(By.xpath("((//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody)["+Integer.toString(i)+"]//tr)["+Integer.toString(j)+"]//td[2]")).getText();
					  int beforeStockCount=Integer.parseInt(driver.findElement(By.xpath("(//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(j)+"]//td[5])")).getText().trim());
//					  if(partno.startsWith("N")) {
//						  countOfNComp++; 
//					  }
//					  if(countOfNComp>0 && j==compRowNos) {
//						  break;
//					  }
					  if(partno.startsWith("N") && (beforeStockCount==0) ) {
						  countOfNComp++;
						  firstNCompRow=j;
						  driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(firstNCompRow)+"]//td[6]//span[@title='Delete Component']")).click();
						  deleteNComp.click();
						  break;
	                  }
					}
			           break;
			    }
			}catch(Exception e) {
				
			}
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr[1]/td[1]")).click();
//		driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(firstExpandableRow)+"]/td[1]")).click();
		for(int k=1;k<=compRowNos-1;k++) {
			String partnoAfterDelete=driver.findElement(By.xpath("(//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr)["+Integer.toString(k)+"]//td[2]")).getText();
//			String partnoAfterDelete=driver.findElement(By.xpath("((//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody)["+Integer.toString(firstExpandableRow)+"]//tr)["+Integer.toString(k)+"]//td[2]")).getText();
		    if(partnoAfterDelete.equalsIgnoreCase(partno)) {
		    	Assert.assertTrue(false);
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
     				emailToPiafact.sendKeys("aakash.srivastava.@ingka.com");
     				Thread.sleep(1000);
     				loginBtnToPiafact.click();
     				Thread.sleep(5000);
     				signToPiaFact.clear();
     				Thread.sleep(2000);
     				signToPiaFact.sendKeys("aakash.srivastava@ingka.com");
     				Thread.sleep(2000);
     				//Actions act = new Actions(driver);
     				//act.moveToElement(nextBtn).build().perform();
     				//Thread.sleep(2000);
     				JavascriptExecutor js1 = (JavascriptExecutor)driver;
     				js1.executeScript("arguments[0].click()",nextBtn);
     				//passwordToPiaFact.sendKeys("Aakasharyan2015");
     				Thread.sleep(10000);
     			}
     			//Assert.assertEquals(driver.getTitle(), "PIA Facts");
     		}
     	}
     	
	}
	
		
	public void mergeComponent() throws InterruptedException {
//		piaFactsBtn
	}
	
}
	
	
	

	
