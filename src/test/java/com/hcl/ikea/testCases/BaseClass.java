package com.hcl.ikea.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.hcl.ikea.utilities.ReadConfig;
import com.hcl.ikea.utilities.XLS_Reader;

public class BaseClass {
	ReadConfig readConfig = new ReadConfig();
	public String baseUrl = readConfig.getApplicationUrl();
	public String usrNm = readConfig.getUserName();
	public String password = readConfig.getPassword();
	public String chromePath = readConfig.getChromePath();
	public String firefoxPath = readConfig.getFirefoxPath();
	public String edgePath = readConfig.getEdgePath();
	public String iePath = readConfig.getIEPath();
	public String userID = readConfig.getUserID();
	public String userNm = readConfig.getUNam();
	public String storeIdee = readConfig.getStoreId();
	public String storeNameee = readConfig.getStoreName();
	public String streetNameee = readConfig.getStreetNam();
	public String postalCodeee = readConfig.getPostalCod();
	public String cityNameee = readConfig.getCityNam();
	public String ruCodeee = readConfig.getRuCod();
	public String rdCodeee = readConfig.getRdCod();
	
	public String editStoreName = readConfig.getEditStoreNam();
	public String editStreetName = readConfig.getEditStreetNam();
	public String editPostalCode = readConfig.getEditPostalCod();
	public String recoveryManagUserID = readConfig.getRMUserID();
	public String recoverManagUserName = readConfig.getRMUserName();
	public String countryNameeee = readConfig.getCountryNamee();
	public String editusernameRM = readConfig.getEditUserNameRM();
	public String storIddeeeeee = readConfig.getRMStoreID();
	public String cscuserID = readConfig.getCSCUserID();
	public String cscuserName = readConfig.getCSCUserName();
	public String editCSCUName = readConfig.getEditUserNameCSC();
	public String piaFactLoginID = readConfig.getUserIDPiaFact();
	public String editFunctionalityStoreName = readConfig.getStorName();
	public String userNetworkIdee = readConfig.getNetworkId();
	public String counttryName = readConfig.getCountNamee();
	public String cscUserIDDetail = readConfig.getCSCUID();
	public String cscUserNameDetail = readConfig.getCSCUName();
	public String userIDEEEE = readConfig.getUserAdminIdee();
	public String userNAMEEEE = readConfig.getuserAdminName();
	
	public static ExtentTest test;
	public static ExtentReports extent;
    public XLS_Reader reader;
	public static WebDriver driver;
	

	public static Logger log;

	@Parameters("browser")
	@BeforeMethod
	public void setUp(String br) {

		log = Logger.getLogger(BaseClass.class);
		PropertyConfigurator.configure("log4jConfig.properties");
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();
		}
		if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		if (br.equals("edge")) {
			System.setProperty("webdriver.edge.driver", readConfig.getEdgePath());
			driver = new EdgeDriver();
		}
		if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {
	  driver.quit();
	}
	  public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}
		
		public String randomestring()
		{
			String generatedstring=RandomStringUtils.randomAlphabetic(8);
			return(generatedstring);
		}
		
		public static String randomeNum() {
			String generatedString2 = RandomStringUtils.randomNumeric(4);
			return (generatedString2);
		}
}
