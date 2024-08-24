package MachinTest;

	
	import java.io.File;


	import java.io.IOException;
	import java.time.Duration;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import com.google.common.io.Files;

	public class Actiontestcases {
		WebDriver driver;
		
		
		 @BeforeMethod
		    public void setUP() throws IOException {
		        System.setProperty("webdriver.chrome.driver", "C:\\Users\\viraj.madhavi\\Documents\\chromedriver-win64\\chromedriver.exe");
		        driver = new ChromeDriver();
		        driver.manage().deleteAllCookies();
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        driver.get("https://www.icicibank.com/");
		       
	}
		 
		 @Test
		 
		 public void radiobutton() throws InterruptedException, IOException {
			 
			 Thread.sleep(4000);
			WebElement newone=  driver.findElement(By.linkText("Loans"));
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			Thread.sleep(2000);
			
			action.moveToElement(newone).build().perform();
			
			Thread.sleep(2000);
			
			driver.findElement(By.linkText("Home Loans")).click();
			Thread.sleep(20000);

}
		 @AfterMethod
		 public void quite() {
			 
			 driver.quit();
		 }}
		 
		 
	
	
