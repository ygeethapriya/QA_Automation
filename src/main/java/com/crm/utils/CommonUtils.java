package com.crm.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {

	public static WebDriver wd = null;

	public static void clickButton(String identifiedBy, String locator, WebDriver wd) {
		if (identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).click();

		} else if (identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.className(locator)).click();
		} else if (identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).click();
		} else if (identifiedBy.equalsIgnoreCase("link")) {
			wd.findElement(By.linkText(locator)).click();

		} else if (identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).click();
		}

	}

	public static void insertText(String identifiedBy, String locator, WebDriver wd, String value) {
		if (identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).sendKeys(value);
			System.out.println("Locator : " + locator);
		} else if (identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).sendKeys(value);
		} else if (identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.className(locator)).sendKeys(value);
		} else if (identifiedBy.equalsIgnoreCase("Link")) {
			wd.findElement(By.linkText(locator)).sendKeys(value);
		} else if (identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).sendKeys(value);
		}

	}

	public static void waitForElement1(String identifiedBy, String locator, WebDriver wd) {
		if (identifiedBy.equalsIgnoreCase("id")) {
			WebDriverWait wait = new WebDriverWait(wd, 50);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		} else if (identifiedBy.equalsIgnoreCase("css")) {
			WebDriverWait wait = new WebDriverWait(wd, 50);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));

		} else if (identifiedBy.equalsIgnoreCase("name")) {
			WebDriverWait wait = new WebDriverWait(wd, 50);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
		} else if (identifiedBy.equalsIgnoreCase("xpath")) {
			WebDriverWait wait = new WebDriverWait(wd, 50);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		}
	}

	public static void mouseOverAnElement(String identifiedBy, String locator, WebDriver wd) {
		WebElement element = null;
		Actions action = new Actions(wd);
		if (identifiedBy.equalsIgnoreCase("linktext")) {
			element = wd.findElement(By.linkText(locator));
			action.moveToElement(element).perform();

		} else if (identifiedBy.equalsIgnoreCase("xpath")) {
			element = wd.findElement(By.xpath(locator));
			action.moveToElement(element).perform();

		} else if (identifiedBy.equalsIgnoreCase("id")) {
			element = wd.findElement(By.id(locator));
			action.moveToElement(element).perform();

		} else if (identifiedBy.equalsIgnoreCase("name")) {
			element = wd.findElement(By.name(locator));
			action.moveToElement(element).perform();

		} else if (identifiedBy.equalsIgnoreCase("css")) {
			element = wd.findElement(By.cssSelector(locator));
			action.moveToElement(element).perform();

		}
	}
	
	public static void switchToFrame(int index , WebDriver wd){
		wd.switchTo().frame(index);
		
	}
	
	public static void clearText(String identifiedBy , String locator , WebDriver wd){
		if (identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).clear();
		} else if(identifiedBy.equalsIgnoreCase("name")){
			wd.findElement(By.name(locator)).clear();

		}else if(identifiedBy.equalsIgnoreCase("xpath")){
			wd.findElement(By.xpath(locator)).clear();
		}else if(identifiedBy.equalsIgnoreCase("css")){
			wd.findElement(By.cssSelector(locator)).clear();
		}
		
	}
	
	public static void selectDropDownItems(String identifiedBy , String locator , WebDriver wd, String itemType , String value){
		WebElement element =null;
		if (identifiedBy.equalsIgnoreCase("id")) {
			element = wd.findElement(By.id(locator));
		} else if(identifiedBy.equalsIgnoreCase("name")){
			element = wd.findElement(By.name(locator));
		}else if(identifiedBy.equalsIgnoreCase("xpath")){
			element = wd.findElement(By.xpath(locator));
		}else if(identifiedBy.equalsIgnoreCase("css")){
			element = wd.findElement(By.cssSelector(locator));
		}
		Select select = new Select(element);
		if (itemType.equals("value")) {
			select.selectByValue(value);
		} else if(itemType.equals("text")){
            select.selectByVisibleText(value);
		}else if(itemType.equals("index")){
			select.selectByIndex(Integer.parseInt(value));
			
		}
	}
	

}
