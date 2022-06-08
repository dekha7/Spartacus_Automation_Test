package com.hcl.ikea.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hcl.ikea.testCases.BaseClass;

public class Reporting extends TestListenerAdapter
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public WebDriver driver;
		
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/Reports/"+repName);//specify location of the report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","PTSpartacus");
		extent.setSystemInfo("user","Aakash");
		
		htmlReporter.config().setDocumentTitle("IKEA-Spartacus Test Automation Project"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult tr)
	{ // create new entry in th report
		String testCaseClassName=tr.getTestClass().getName();
		int no =testCaseClassName.indexOf("TC_");
//		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
		logger=extent.createTest(testCaseClassName.substring(no));
		logger.log(Status.PASS,MarkupHelper.createLabel(testCaseClassName.substring(no),ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr)
	{
		String testCaseClassName=tr.getTestClass().getName();
		int no =testCaseClassName.indexOf("TC_");
		logger=extent.createTest(testCaseClassName.substring(no)); // create new entry in th report
//		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		logger.log(Status.FAIL,MarkupHelper.createLabel(testCaseClassName.substring(no),ExtentColor.RED));
//		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getTestClass().getName()+".png";
		BaseClass bc= new BaseClass();
		try {
			bc.captureScreen(BaseClass.driver, testCaseClassName.substring(no));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*
		File f = new File(screenshotPath); 
		if(f.exists())
		{
		try {
			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			} 
		catch (IOException e) 
				{
				e.printStackTrace();
				}
		}
		*/
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		String testCaseClassName=tr.getTestClass().getName();
		int no =testCaseClassName.indexOf("TC_");
		logger=extent.createTest(testCaseClassName.substring(no)); // create new entry in th report
//		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		logger.log(Status.SKIP,MarkupHelper.createLabel(testCaseClassName.substring(no),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
}