package com.qa.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.LoginPage;
import com.qa.pages.Testbase;



public class LoginPageTest extends Testbase {
	LoginPage loginPage;
	
	@BeforeMethod
	public static void intializeBrowser() {
		//Testbase obj = new Testbase();
	}
	
//	//Verify user able to login with valid credentials
//	@Test(priority=1)
//	public void loginPageTitle(){
//	loginPage = new LoginPage();
//	loginPage.login();
//	String url ="https://www.saucedemo.com/inventory.html";
//	String homePageUrl=driver.getCurrentUrl();
//	boolean compareUrl=url.equals(homePageUrl);
//	System.out.println(compareUrl);
//	
//}
	@AfterMethod()
	public void quitBrowser() {
		driver.quit();
	}
}	

