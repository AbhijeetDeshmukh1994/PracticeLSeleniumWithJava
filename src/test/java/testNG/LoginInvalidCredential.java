package testNG;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import extentManager.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginInvalidCredential {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	@BeforeSuite
	public void setupReport() {
		extent = ExtentManager.getExtentReports();
	}

	@Test(priority = 1)
	public void openBrowser() {
		test = extent.createTest("Open Browser");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		test.pass("Browser launched and URL opened");
	}

	@Test(priority = 2)
	public void loginPage() {
		test = extent.createTest("Login with Invalid Credentials");
		try {
			driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("eshmukhabhijeet332@gmail.com");
			test.pass("Entered email");
			driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("bhijeet@123");
			test.pass("Entered password");
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			test.pass("Clicked Login button");

			String warningText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
			Assert.assertTrue(warningText.contains("Warning"), "Expected warning message not displayed");
			test.pass("Warning message validated");
		} catch (Exception e) {
			test.fail("Login test failed: " + e.getMessage());
		}
	}

	@Test(priority = 3)
	public void tearDown() {
		test = extent.createTest("Close Browser");
		driver.quit();
		test.pass("Browser closed");
	}

	@AfterSuite
	public void flushReport() {
		extent.flush();
	}
}
