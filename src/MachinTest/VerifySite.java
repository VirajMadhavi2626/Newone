package MachinTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class VerifySite {
	
	WebDriver driver; //Defind the Driver
	
	@BeforeMethod
	
	public void SetUP() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\viraj.madhavi\\Documents\\chromedriver-win64\\chromedriver.exe");//Set the Property
        driver = new ChromeDriver();// Set the ChromeDriver
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));//Set Pageload Tiemout
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );//Set Implicit wait because not all element load properly before throwing no such elemnet
		driver.get("https://www.w3schools.com/");// launch the URl
		
	}
	
	@Test
	public void VerifyURlTest () {
		
		//Verify URL is Valid CurrentUrl  Launch 
		
		System.out.println(driver.getCurrentUrl());
		
		String testurl = driver.getCurrentUrl();
		Assert.assertEquals(testurl, "https://www.w3schools.com/");
		
	}
	
	@Test
	public void Verifyurltitle() throws IOException {
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "W3Schools Online Web Tutorials");
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		   Files.copy(screenshotFile, new File("C:\\Users\\viraj.madhavi\\New Eclips\\Test\\bin\\TestNG\\W3SchoolMachinTest\\Testscreenshot.jpg"));
	}
	
	@Test
	public void link() throws IOException {
		
		 List<WebElement> links = driver.findElements(By.tagName("a"));
		 System.out.println(links);
		 Assert.assertTrue(links.size() > 0, "No links found on the page.");
		 
		 File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		   Files.copy(screenshotFile, new File("C:\\Users\\viraj.madhavi\\New Eclips\\Test\\bin\\TestNG\\W3SchoolMachinTest\\Testscreenshot.jpg"));

	}
	
	 @AfterMethod
	 public void quite() {
		 
		 driver.quit();
	 }}

