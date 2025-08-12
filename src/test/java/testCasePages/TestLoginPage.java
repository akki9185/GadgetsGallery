package testCasePages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MethodsForTest.Methods_Perant;

public class TestLoginPage extends Methods_Perant {
	
	
	WebDriver driver;
	
	@BeforeMethod
	public void LanuvhBroser() throws IOException {
		driver = launchBrowser("Chrome", "homepage");
	}
	
	//Both Invalid
	@Test(priority = 1)
	public void Case1() throws IOException, InterruptedException {
		locaterFind("linktxt", "log yourself in").click();
		locaterFind("name", "email_address").sendKeys("ankitsapra");
		locaterFind("name", "password").sendKeys("ljnkjjk");
		locaterFind("id", "tdb1").click();
		String errMSG = locaterFind("xpath", "//td[@class='messageStackError']").getText().trim();
		assertEquals(errMSG, PropGet("loginErro"));		
		Thread.sleep(5);
		//driver.close();		 		
	}
	
	//Invalid Password
	@Test(priority = 2)
	public void emailPassInvalid() throws IOException, InterruptedException {
		locaterFind("linktxt", "log yourself in").click();
		locaterFind("name", "email_address").sendKeys("ankit.sapara2311@test.com");
		locaterFind("name", "password").sendKeys("ljnkjjk");
		locaterFind("id", "tdb1").click();
		String errMSG = locaterFind("xpath", "//td[@class='messageStackError']").getText().trim();
		assertEquals(errMSG, PropGet("loginErro"));		
		Thread.sleep(5);
		//driver.close();		
	}
	
	@AfterMethod
	public void closeBrow() {
		driver.close();	
	}

	


}
