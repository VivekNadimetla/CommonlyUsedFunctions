package com.test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.lang.System.Logger;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beust.jcommander.internal.Console;

public class CommonlyUsedFunctions {

	public static void main(String[] args) throws InterruptedException {
		GetTitle();
		SendInput("Hello","//*[@title='Search']"); //Provide input string as first arg and xpath of the xpath of input field as second arg 
		FetchText("https://www.google.com","//div[@class='vcVZ7d']//a[1]"); //Provide xpath of the element you want to fetch in text format
		SetZoomToZero();
		WaitForElement(); //Provide Xpath of the element you want Selenium to wait until it is visible
		WaitForClickableElement(); //Provide xpath of the element you want Selenium to wait until clickable
		ScrollUntilElementVisible("//a[text()='Facebook']"); //Provide xpath of the element
		
		
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
			 e.printStackTrace();
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
			 e.printStackTrace();
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
		 driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// WebElement zoom = driver.findElement(By.tagName("html"));
		 //Thread.sleep(5000);
		 //zoom.sendKeys(Keys.chord(Keys.CONTROL, "0")); 
	     Robot robot = new Robot();
	     System.out.println("About to zoom in");
	     for (int i = 0; i < 3; i++) 
	     {			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	     Thread.sleep(5000);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_0);
	     Thread.sleep(5000);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyRelease(KeyEvent.VK_0);
		 driver.close();
		 driver.quit();
		 Thread.sleep(5000);
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		}

	 }
	 
	 //Explicit wait until a specific element is visible
	 public static void WaitForElement(String... args) {
		 try {
			 WebDriver driver;
			 System.setProperty("webdriver.chrome.driver", "C:\\Selenium-java\\chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.get("https://www.google.com");
			 driver.manage().window().maximize();
			 WebDriverWait wait = new WebDriverWait(driver, 10);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(args[0])));
			 System.out.println("Expected element is visible");
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
	
	 //Explicit wait until a an element is Clickable
	 public static void WaitForClickableElement(String... args) 
	 {
		 try {
			 WebDriver driver;
			 System.setProperty("webdriver.chrome.driver", "C:\\Selenium-java\\chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.get("https://www.google.com");
			 driver.manage().window().maximize();
			 WebDriverWait wait = new WebDriverWait(driver, 10);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(args[0])));
			 System.out.println("Expected clickalble element is visible");
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		}
	 }
	 
	 //Scroll until an element is visible
	 public static void ScrollUntilElementVisible(String... args) {
		 try {
			 WebDriver driver;
			 System.setProperty("webdriver.chrome.driver", "C:\\Selenium-java\\chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.get("https://www.examtopics.com/exams/microsoft/az-900/");
			 driver.manage().window().maximize();
			 Thread.sleep(500);
			 String arg = "arguments[0].scrollIntoView({behavior: \"auto\", block: \"center\", inline: \"center\"}) ;";
			 WebElement fblink = driver.findElement(By.xpath(args[0]));
			 ((JavascriptExecutor)driver).executeScript(arg, fblink);
		     Thread.sleep(1800);
			 System.out.println("Element is found");
			 fblink.click();
			 driver.close();
			 driver.quit();
		 }
		 catch (Exception e) {
			 e.printStackTrace(); //Will point the exact line in which the method raised the exception.
		}
	 }
	 
	 
}
