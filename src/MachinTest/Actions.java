package MachinTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Actions {
	
	WebDriver driver;
	
	@BeforeMethod
	
	public void SetUP() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\viraj.madhavi\\Documents\\chromedriver-win64\\chromedriver.exe");//Set the Property
        driver = new ChromeDriver();// Set the ChromeDriver
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));//Set Pageload Tiemout
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );//Set Implicit wait because not all element load properly before throwing no such elemnet
		driver.get("https://www.facebook.com/");// launch the URl
	
	}

	@Test
	
	public void selectfilled() throws InterruptedException, IOException {
			   
			   driver.findElement(By.linkText("Create new account")).click();
				Thread.sleep(5000);
				driver.findElement(By.name("birthday_day")).click();
			   Select select = new Select(driver.findElement(By.name("birthday_day")));
			   select.selectByVisibleText("15");
			   Assert.assertTrue(true);
			   
			   Thread.sleep(3000);
			   Select selectmonth = new Select(driver.findElement(By.name("birthday_month")));
			   selectmonth.selectByVisibleText("Jun");
			   Assert.assertTrue(true);
			   
			   File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			   Files.copy(screenshotFile, new File("C:\\Users\\viraj.madhavi\\New Eclips\\Test\\bin\\TestNG\\W3SchoolMachinTest\\Testscreenshot.jpg"));
	}
	 
	 @AfterMethod
	 public void quite() {
		 
		 driver.quit();
	 }}
		
		
	