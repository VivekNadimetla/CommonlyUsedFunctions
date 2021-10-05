package com.test;

import java.lang.System.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.beust.jcommander.internal.Console;

public class CommonlyUsedFunctions {

	public static void main(String[] args) throws InterruptedException {
		//GetTitle();
		//SendInput("Hello","//*[@title='Search']");
		//FetchText("https://www.google.com","//div[@class='vcVZ7d']//a[1]");
		SetZoomToZero();
		
	}

	//Get title of webpage
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
	 
	 //Fetch Text of an element
	 public static void FetchText(String... args) {
		 try {
			 WebDriver driver;
			 System.setProperty("webdriver.chrome.driver", "C:\\Selenium-java\\chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.get(args[0]);
			 String text = driver.findElement(By.xpath(args[1])).getText(); //Will fetch text of the xpath and store in valriable 'text'
			 System.out.println("Text:"+text);
			 driver.close();
			 driver.quit(); 
		 }
		 catch (Exception e) {
			 System.out.println(e);
		}
	 }
	 
	 //Set browser zoom to zero
	 public static void SetZoomToZero() throws InterruptedException 
	 {
		 try {	
		 WebDriver driver;
		 System.setProperty("webdriver.chrome.driver", "C:\\Selenium-java\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.google.com");
		// WebElement zoom = driver.findElement(By.tagName("html"));
		 Thread.sleep(5000);
		 //zoom.sendKeys(Keys.chord(Keys.CONTROL, "0")); 
		 driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
		 driver.close();
		 driver.quit();
			 
		 }
		 catch (Exception e) {
			System.out.println(e);
		}

	 }




}
