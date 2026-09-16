package com.qa.pages;

import org.openqa.selenium.By;

public class LoginPage extends Testbase {
		String userName;
		String passWord;
		 private final By userNameField = By.id("user-name");
		 private final By passWordField = By.id("password");
		 private final By loginButtonField = By.id("login-button");
		 
		public void login(String userName,String passWord) {
			this.userName=userName;
			this.passWord=passWord;
		driver.findElement(userNameField).sendKeys(userName);
		driver.findElement(passWordField).sendKeys(passWord);
		driver.findElement(loginButtonField).click();
	}		
		
}