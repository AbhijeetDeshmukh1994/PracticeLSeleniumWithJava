package practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddWishList {
    @Test()
	public void verifyWishList() throws InterruptedException
	{
    	WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
	   // Locate "Add to Wish List" button for iPhone
		WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[2]"));
		 // Scroll into view
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView();", element);
		// Click on Wish List button
		element.click();
		
	     // ✅ Wait for success message to appear
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(15));
		WebElement successMsg = wait.until (
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']"))
		);
	    // Print and validate message
	   String msgText =successMsg.getText();
	   System.out.println(msgText);
	   Assert.assertTrue(msgText.contains("You must login or create an account to save MacBook to your wish list!"),"Msg is not display");
	   driver.quit();
		
	}
	
	
}
