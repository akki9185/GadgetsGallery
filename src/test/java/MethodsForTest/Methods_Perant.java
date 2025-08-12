package MethodsForTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Methods_Perant {
	
	public static WebDriver driver;	
	
	public static WebDriver launchBrowser(String broName, String propdata) throws IOException {
		driver = null;
		if(broName == "Chrome") {
			 driver = new ChromeDriver();
		}
		if(broName == "Fire") {
			 driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(PropGet(propdata));
		return driver;	
	}
		
	
	public static String PropGet(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fil = new FileInputStream("src/test/java/data.properties");
		prop.load(fil);
		String value = prop.getProperty(key);
		return value;
		
	}
	//It will Return Locators
		public WebElement locaterFind(String type, String value) {
			WebElement Element = null;
			switch (type) {
			case "linktxt":
				Element =driver.findElement(By.linkText(value));
				break;
			case "xpath":
				Element =driver.findElement(By.xpath(value));
				break;
			case "name":
				Element =driver.findElement(By.name(value));
				break;
			case "class":
				Element =driver.findElement(By.className(value));
				break;
			case "id":
				Element =driver.findElement(By.id(value));
				break;
			default:
				System.out.println("Invalid Locator" + type);
				break;			
			}
			return Element; 
			
		}
		
		public static void AlertCCase(String alrtValue) {
			
			if(alrtValue == "Yes") {
				driver.switchTo().alert().accept();
				}
			if(alrtValue == "No" || alrtValue == "Cancel") {
				driver.switchTo().alert().dismiss();
				}
			if(alrtValue == "text") {
				driver.switchTo().alert().getText();
			}
		 		
		}
		public String  AlertText() {
			String alrtTest = driver.switchTo().alert().getText();
			return alrtTest;	 		
		}

}
