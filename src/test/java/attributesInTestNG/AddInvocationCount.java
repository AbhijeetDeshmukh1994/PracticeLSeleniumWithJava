package attributesInTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddInvocationCount {

	WebDriver driver;
		
	   @Test(priority=1)
		public void openbrowser() throws InterruptedException
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
			driver.manage().window().maximize();
			Thread.sleep(30000);
		}
		
		@Test(priority=2,invocationCount=5)
		public void loginValidCredential() throws InterruptedException
		{
			driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("deshmukhabhijeet332@gmail.com");
			driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Abhijeet@123");
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			Thread.sleep(30000);
			driver.navigate().back();
			
		}
	
	}

