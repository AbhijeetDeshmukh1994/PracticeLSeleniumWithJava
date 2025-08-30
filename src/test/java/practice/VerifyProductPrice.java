package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyProductPrice {
    @Test
	public void validateProductPrice() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Home page
		//scroll down from macbook
		WebElement element = driver.findElement(By.linkText("MacBook"));
		 // Scroll into view
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView();", element);
		Thread.sleep(3000);
		
		String homepagePrice = driver.findElement(By.xpath("(//p[@class='price'])[1]")).getText();
		System.out.println(homepagePrice);
		element.click();
		
		//MacBook page
		String macbookPagePrice = driver.findElement(By.xpath("//div[@class='col-sm-4']//ul[2]")).getText();
		System.out.println(macbookPagePrice);
		
		Assert.assertEquals(homepagePrice, macbookPagePrice);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
