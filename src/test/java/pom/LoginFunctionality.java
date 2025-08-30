package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class LoginFunctionality {
WebDriver driver;
	
	@BeforeClass
	void setup()throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@Test
	void login() throws InterruptedException
	{
		//LoginPageWithoutUsingPageFactory loginpage = new LoginPageWithoutUsingPageFactory(driver);
		LginPage loginpage = new LginPage(driver);
		loginpage.setUsername("Admin");
		loginpage.setPassword("admin123");
		loginpage.click();
		Thread.sleep(3000);
	}
	
	@AfterClass
	void teardown()
	{
		driver.quit();
	}
}
