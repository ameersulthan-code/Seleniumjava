package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
		 private final By userNameField = By.id("user-name");
		 private final By passWordField = By.id("password");
		 private final By loginButtonField = By.id("login-button");
		 private final By homePageTitle=By.xpath("//span[@class='title']");
		 private final By errorMessage = By.cssSelector("[data-test='error']");
		 
		 public void login(String userName,String passWord) {
		driver.findElement(userNameField).sendKeys(userName);
		driver.findElement(passWordField).sendKeys(passWord);
		driver.findElement(loginButtonField).click();
	}	
		public WebElement verifyTitle() {
		return	driver.findElement(homePageTitle);
			
		}
		 public boolean isErrorDisplayed() {
		        return driver.findElements(errorMessage).size() > 0;
		    }

		    public String getErrorText() {
		        return driver.findElement(errorMessage).getText();
		    }
		
}