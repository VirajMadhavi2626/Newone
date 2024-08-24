package MachinTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class SignupPage {
	
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
	@Test(priority=1)
	public void siguplogin() {
		
		driver.findElement(By.linkText("Sign Up")).click();
		
		//Verify all filled is worked properly with valid data
		
		
		driver.findElement(By.xpath("//*[@placeholder='email']")).sendKeys("Smit@Test.com");
		driver.findElement(By.xpath("//*[@placeholder='password']")).sendKeys("Taylor@123");
		driver.findElement(By.xpath("//*[@placeholder='first name']")).sendKeys("Smit");
		driver.findElement(By.xpath("//*[@placeholder='last name']")).sendKeys("Taylor");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
	}
	
	@Test(groups = {"invalidtc"})
	public void invaliddata() throws IOException {
		
		driver.findElement(By.linkText("Sign Up")).click();
		
		driver.findElement(By.xpath("//*[@placeholder='email']")).sendKeys("Smit@Test.com");
		driver.findElement(By.xpath("//*[@placeholder='password']")).sendKeys();//this filled is not filled
		driver.findElement(By.xpath("//*[@placeholder='first name']")).sendKeys("Smit");
		driver.findElement(By.xpath("//*[@placeholder='last name']")).sendKeys("Taylor");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		   Files.copy(screenshotFile, new File("C:\\Users\\viraj.madhavi\\New Eclips\\Test\\bin\\TestNG\\W3SchoolMachinTest\\Testscreenshot.jpg"));

		//getting error with all filled is mandatory & Error messgae should displayed properly
		
	}
	
	@Test(dataProvider="getData")
	public void multipledatatest(String email, String password ,String name , String lastname) throws IOException {
		driver.findElement(By.linkText("Sign Up")).click();
		
		driver.findElement(By.xpath("//*[@placeholder='email']")).sendKeys(email);
		driver.findElement(By.xpath("//*[@placeholder='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@placeholder='first name']")).sendKeys(name);
		driver.findElement(By.xpath("//*[@placeholder='last name']")).sendKeys(lastname);
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		   Files.copy(screenshotFile, new File("C:\\Users\\viraj.madhavi\\New Eclips\\Test\\bin\\TestNG\\W3SchoolMachinTest\\Testscreenshot.jpg"));
		
		}
	
	
	 @DataProvider

	 public Object[][] getData() {
	     Object[] [] data = new Object[2][4];
	     
	     data[0][0] = "XYZ";
	     data[0][1] = "123566";
	     data[0][2] = "XYZ3";
	     data[0][3] = "XYZ4";
	     
	     data[1][0] = "ABCD";
	     data[1][1] = "ABCD2";
	     data[1][2] = "ABCD3";
	     data[1][3] = "ABCD4";
	     
	     return data;
	
}
	 
	 @AfterMethod
	 public void quite() {
		 
		 driver.quit();
	 }}
