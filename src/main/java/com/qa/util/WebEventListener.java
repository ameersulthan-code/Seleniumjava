package com.qa.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import com.qa.base.TestBase;



public class WebEventListener extends TestBase implements WebDriverListener {

    @Override
    public void beforeTo(WebDriver.Navigation navigation, String url) {
        System.out.println("Before navigating to: '" + url + "'");
    }

    @Override
    public void afterTo(WebDriver.Navigation navigation, String url) {
        System.out.println("Navigated to: '" + url + "'");
    }

    @Override
    public void beforeClick(WebElement element) {
        System.out.println("Trying to click on: " + element.toString());
    }

    @Override
    public void afterClick(WebElement element) {
        System.out.println("Clicked on: " + element.toString());
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        System.out.println("Trying to find Element By: " + locator.toString());
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        System.out.println("Found Element By: " + locator.toString());
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        System.out.println("Exception occurred: " + e.getCause());
        try {
          //  TestUtil.takeScreenshotAtEndOfTest();
        } //catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}