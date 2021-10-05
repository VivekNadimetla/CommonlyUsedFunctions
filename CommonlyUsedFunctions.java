package com.test;

import java.lang.System.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.beust.jcommander.internal.Console;

public class CommonlyUsedFunctions {
	//public static WebDriver driver = new ChromeDriver(); //Set path of ChromeDriver on your local desktop
	

	//public CommonlyUsedFunctions(WebDriver driver) {
		//CommonlyUsedFunctions.driver = driver;
		//System.setProperty("webdriver.chrome.driver", "C:\\Selenium-java\\chromedriver.exe"); //Set path of ChromeDriver on your local desktop
		//setProperty("webdriver.chrome.driver", "C:\\Selenium-java\\chromedriver.exe");driver = ;

	//}
	public static void main(String[] args) {
		GetTitle();
		SendInput("Hello","//*[@title='Search']");
	}

	// Get title of webpage
	public static void GetTitle() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium-java\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
		driver.quit();
	}
	

	 //Provide input in a text field
	 public static void SendInput(String... args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium-java\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		 String value = args[0]; //Stores input to be sent
		 String inputvalue=args[1]; // Stpres Xpath of the element
		 try {
			 WebElement inputfield = driver.findElement(By.xpath(inputvalue));
			 System.out.println("Sending value"+value+"to input field");
			 inputfield.click();
			 inputfield.sendKeys(value+Keys.ENTER); //Sends input and clicks Enter
		 }
		 catch (Exception e) {
			 System.out.println(e);
		}
			driver.close();
			driver.quit();
	  }


}
