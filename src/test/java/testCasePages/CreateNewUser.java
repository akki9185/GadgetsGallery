package testCasePages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MethodsForTest.Methods_Perant;

public class CreateNewUser extends Methods_Perant  {
	
	
	WebDriver driver;
	
	@BeforeMethod
	public void LanuvhBroser() throws IOException {
		driver = launchBrowser("Chrome", "homepage");
	}
	
	
	@Test
	public void validationCheck() {
		locaterFind("linktxt", "create an account").click();
		locaterFind("id", "tdb1").click();
		System.out.println(AlertText());
 		AlertCCase("Yes");
 		System.out.println("df wnf sdkfb skdfskdf ksdnfkj ");
		
		
	}
	
	@AfterMethod
	public void CloseBrow() throws InterruptedException {
		Thread.sleep(5);
		driver.close();
	}

}
