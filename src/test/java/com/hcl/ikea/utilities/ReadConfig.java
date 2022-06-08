package com.hcl.ikea.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
  Properties pro;
  public ReadConfig() {	
  File src = new File(System.getProperty("user.dir")+"/Configuration/Config.properties");
  try {
	  FileInputStream fis = new FileInputStream(src);
	  pro = new Properties();
	  pro.load(fis);
  }catch(Exception e){
	System.out.println("Exception is " +e.getMessage());
  }
  }
 public String getApplicationUrl() {
	String url=pro.getProperty("baseUrl");
	return url;  
  }
 public String getUserName() {
	 String uname = pro.getProperty("userName");
	return uname;
 }
 public String getPassword() {
	String pwd = pro.getProperty("password");
	return pwd;
 }
 public String getChromePath() {
	 String chromePath = pro.getProperty("chromePath");
	return chromePath;
 }
 public String getFirefoxPath() {
	 String firefoxPath = pro.getProperty("firefoxPath");
	return firefoxPath;
	
 }
 public String getEdgePath() {
	 String edgePath = pro.getProperty("edgePath");
	return edgePath;
	
 }
 public String getCountryNamee() {
	 String countryNam = pro.getProperty("countryName");
	 return countryNam;
 }
 public String getIEPath() {
	 String iePath = pro.getProperty("iePath");
	return iePath;
	
 }
 public String getUserID() {
	 String uID = pro.getProperty("userID");
	return uID;
 }
 public String getUNam() {
	 String usrNm = pro.getProperty("uName");
	return usrNm;
 }
 public String getStoreId() {
	 String storID = pro.getProperty("storeID");
	return storID;
 }
 public String getStoreName() {
	 String storNm = pro.getProperty("storeName");
	return storNm;
 }
 public String getStreetNam() {
	 String streetNm = pro.getProperty("streetName");
	return streetNm;
 }
 public String getPostalCod() {
	 String posCd = pro.getProperty("postalCode");
	return posCd;
 }
 public String getCityNam() {
	 String citNm = pro.getProperty("cityName");
	return citNm;
 }
 public String getRuCod() {
	 String ruCd = pro.getProperty("ruCode");
	return ruCd;
 }
 public String getRdCod() {
	 String rdCd = pro.getProperty("rdCode");
	return rdCd;
 }
 // creating methods to verify edit functionalities
 public String getEditStoreNam() {
	 String storNm = pro.getProperty("storeName1");
	return storNm;
 }
 public String getEditStreetNam() {
	 String streetNm = pro.getProperty("streetName1");
	return streetNm;
 }
 public String getEditPostalCod() {
	 String posCd = pro.getProperty("postalCode1");
	return posCd;
 }
 //creating methods for creating user by Recovery Manager
 public String getRMUserID() {
	 String rMUserID = pro.getProperty("recoverManagerUserID");
	 return rMUserID;
 }
 public String getRMUserName() {
	 String rMUserName = pro.getProperty("recoveryManagerUserName");
	 return rMUserName;
 }
 //creating methods to validate edit functionality of Recovery Manager
 public String getEditUserNameRM() {
	 String URM = pro.getProperty("editRMUserName");
	 return URM;
 }
//creating method to validate store ID after edit functionality of Recovery Manager
public String getRMStoreID() {
	 String URM = pro.getProperty("storIddee");
	 return URM;
}
//creating methods to validate user management details of CSC Coworker created by CSC Manager Sparta-177 Release 2.22
public String getCSCUserID() {
	 String cscUID = pro.getProperty("cscUserID");
	 return cscUID;
}
public String getCSCUserName() {
	String cscUName = pro.getProperty("cscUserName");
	return cscUName;
}
public String getEditUserNameCSC() {
	 String UCSC = pro.getProperty("editCSCUserName");
	 return UCSC;
}
public String getNetworkId() {
	 String nwId = pro.getProperty("networkID");
	 return nwId;
}
public String getCountNamee() {
	 String countryNam = pro.getProperty("countNamee");
	 return countryNam;
}
public String getStoreNam() {
	 String storNm = pro.getProperty("storeName");
	return storNm;
}
//creating method for cure user clicking Pia-Facts new Url link
public String getUserIDPiaFact() {
	 String piaFactLoginUserID = pro.getProperty("userIdPiaFact");
	 return piaFactLoginUserID;
}
public String getStorName() {
	 String storeName = pro.getProperty("storNam");
	 return storeName;
}
//creating methods to validate duplicate entry of CSC Coworker created by CSC Manager Sparta-298 Release 2.23
public String getCSCUID() {
	 String cscUIDDetail = pro.getProperty("cscUID");
	 return cscUIDDetail;
}
public String getCSCUName() {
	String cscUNameDetail = pro.getProperty("cscUName");
	return cscUNameDetail;
}
//creating methods for test case No.89 --> As a User manager I expect to be able to delete my users
public String getUserAdminIdee() {
	 String userIDEE = pro.getProperty("userAdminID");
	 return userIDEE;
}
public String getuserAdminName() {
	    String userNAMEE =  pro.getProperty("userAdminName");
	    return userNAMEE;
}
}
 
