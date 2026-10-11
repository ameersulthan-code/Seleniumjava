package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import com.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static  WebDriver driver;
	
	public static Properties prop;
	
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/qa"
					+ "/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization() {
	WebDriverManager.chromedriver().setup();
	// 1. Create the original ChromeDriver instance
	 driver = new ChromeDriver();
	    // 2. Instantiate the listener
	    WebEventListener listener = new WebEventListener();

	    // 3. Wrap originalDriver into the decorated driver
	    driver = new EventFiringDecorator<>(listener).decorate(driver);
	 driver.manage().window().maximize();
	driver.get(prop.getProperty("url"));
	}

}

