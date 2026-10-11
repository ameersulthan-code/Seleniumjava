package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;
import com.qa.base.TestBase;




public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	
	
//	public  LoginPageTest() {
//		super();
//	}
	@BeforeMethod
	public void loadBrowser() {
		initialization();
		loginPage = new LoginPage();
}
	
	//Verify user able to login with valid credentials
	@Test(dataProvider="loginData",dataProviderClass = TestUtil.class)
	public void  verifyLogin(String userName,String passWord,String expectedResult) throws InterruptedException {
		 if (expectedResult.equalsIgnoreCase("valid")) {
		        // Expect successful login → Products page loads
			 Thread.sleep(5000);
		        String actualTitle = loginPage.verifyTitle().getText();
		        String expectedTitle = "Products";
		        Assert.assertEquals(actualTitle, expectedTitle,
		                "Expected successful login for user: " + userName);
		        System.out.println("✔ Login successful as expected for: " + userName);

		    } else {
		        // Expect failed login → error message shown
		        Assert.assertTrue(loginPage.isErrorDisplayed(),
		                "Expected login failure for user: " + userName + " but no error was shown");
		        System.out.println("✔ Login failed as expected for: " + userName
		                + " | Error: " + loginPage.getErrorText());
		    }
		}
	
	
	
	@AfterMethod()
	public void quitBrowser() {
		driver.quit();
	}
}	

