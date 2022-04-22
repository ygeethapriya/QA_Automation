package com.crm.services;

import com.crm.config.BaseConfiguration;
import com.crm.objectRepository.CrmOr;
import com.crm.utils.CommonUtils;

public class CrmServices extends BaseConfiguration{
 CrmOr crmObjects = new CrmOr();
 public CrmServices openCrmApplication() {
	 invokebrowser();
	return this;

}
 
 public CrmServices loginCrmApplication(String username , String password) throws InterruptedException{
	Thread.sleep(5000);
	
	 CommonUtils.insertText("xpath", crmObjects.getCrmObjects().getProperty("crm_login_username"), driver, username);
	// driver.findElement(By.xpath("//input[@name='txtUserName']")).sendKeys(username);
	 CommonUtils.insertText("xpath", crmObjects.getCrmObjects().getProperty("crm_login_password"), driver, password);
	 CommonUtils.clickButton("xpath", crmObjects.getCrmObjects().getProperty("crm_login_loginButton"), driver);
	 
	 
	 return this;
	 
 }
 public CrmServices AdminGeneral(String company, int tax, int naics, String phoneno , int fax) throws InterruptedException{
	 Thread.sleep(5000);
	 CommonUtils.mouseOverAnElement("xpath", crmObjects.getCrmObjects().getProperty("Admin_dropdown"), driver);
	 CommonUtils.mouseOverAnElement("xpath", crmObjects.getCrmObjects().getProperty("Company_info"), driver);
	 CommonUtils.mouseOverAnElement("xpath", crmObjects.getCrmObjects().getProperty("General"), driver);
	 CommonUtils.clickButton("xpath", crmObjects.getCrmObjects().getProperty("General"), driver);
	 Thread.sleep(3000);
	 CommonUtils.switchToFrame(0, driver);
	 Thread.sleep(3000);
	 CommonUtils.clickButton("xpath", crmObjects.getCrmObjects().getProperty("General_Edit"), driver);
	 Thread.sleep(6000);
	 CommonUtils.clearText("xpath", crmObjects.getCrmObjects().getProperty("CompanyName_General"), driver);
	 CommonUtils.insertText("xpath", crmObjects.getCrmObjects().getProperty("CompanyName_General"), driver, company);
	 
	 CommonUtils.clearText("xpath", crmObjects.getCrmObjects().getProperty("TaxID_General"), driver);
	 CommonUtils.insertText("xpath", crmObjects.getCrmObjects().getProperty("TaxID_General"), driver, String.valueOf(tax));
	 
	 CommonUtils.clearText("xpath", crmObjects.getCrmObjects().getProperty("NAICS_General"), driver);
	 CommonUtils.insertText("xpath", crmObjects.getCrmObjects().getProperty("NAICS_General"), driver, String.valueOf(naics));
	 
	 CommonUtils.clearText("xpath", crmObjects.getCrmObjects().getProperty("Phone_General"), driver);
	 CommonUtils.insertText("xpath", crmObjects.getCrmObjects().getProperty("Phone_General"), driver, String.valueOf(phoneno));
	 
	 CommonUtils.insertText("xpath", crmObjects.getCrmObjects().getProperty("Fax_General"), driver, String.valueOf(fax));
	 Thread.sleep(3000);

     CommonUtils.selectDropDownItems("xpath", crmObjects.getCrmObjects().getProperty("CountryDropDown_General"), driver, "text", "France");
	 
	 
	 
	return this;
 }
}
