package com.qa.pages;

import org.openqa.selenium.By;

public class LoginPage extends Testbase {
		String userName;
		 private final By userNameField = By.id("user-name");
		 private final By passWordField = By.id("password");
		 private final By loginButtonField = By.id("login-button");
		 
		public void login() {
		driver.findElement(userNameField).sendKeys("standard_user");
		driver.findElement(passWordField).sendKeys("secret_sauce");
		driver.findElement(loginButtonField).click();
	}		
		
}