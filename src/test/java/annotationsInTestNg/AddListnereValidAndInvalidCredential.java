package annotationsInTestNg;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class AddListnereValidAndInvalidCredential {
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
		
		@Test(priority=2)
		public void loginValidCredential() throws InterruptedException
		{
			driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("deshmukhabhijeet332@gmail.com");
			driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Abhijeet@123");
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			Thread.sleep(30000);
			
		}
		
		@Test(priority=3)
		public void loginInValidCredential() throws InterruptedException
		{
			driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=account/login");
			Thread.sleep(30000);
			WebElement emailField=driver.findElement(By.xpath("//input[@id='input-email']"));
			emailField.sendKeys("eshmukhabhijeet332@gmail.co");
			WebElement passwordField=driver.findElement(By.xpath("//input[@id='input-password']"));
			passwordField.sendKeys("bhijeet@1");
			//button[normalize-space()='Login']
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			Thread.sleep(30000);
			WebElement dismissMsg = driver.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible"));
			Assert.assertEquals(dismissMsg, "Warning: No match for E-Mail Address and/or Password.");
			
			
		}
		
		@Test(priority=4)
		public void tearDown() throws InterruptedException
		{
			driver.quit();
			Thread.sleep(30000);
		}
		
		

	}



