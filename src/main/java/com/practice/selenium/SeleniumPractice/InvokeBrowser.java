package com.practice.selenium.SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeBrowser {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Assassin\\JavaPractise1\\SeleniumPractice\\src\\test\\java\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost/orangehrm/login.php");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='txtUserName']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();

	}

}
