package extentManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginInvalidCredential {
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
	public void loginPage() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("eshmukhabhijeet332@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("bhijeet@123");
		//button[normalize-space()='Login']
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(30000);
	}
	
	@Test(priority=3)
	public void tearDown() throws InterruptedException
	{
		driver.quit();
		Thread.sleep(30000);
	}
	
	

}
