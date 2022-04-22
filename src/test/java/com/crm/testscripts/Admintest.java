package com.crm.testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.services.CrmServices;

public class Admintest {
 CrmServices services = new CrmServices();
 
 @BeforeClass
 public void init() throws InterruptedException{
	 services.openCrmApplication();
	 services.loginCrmApplication("admin", "admin");
	 services.AdminGeneral("Titan",2008,8020, "8686609500" , 8907);
 }
 @Test
 public void in(){
	 
 }
}
