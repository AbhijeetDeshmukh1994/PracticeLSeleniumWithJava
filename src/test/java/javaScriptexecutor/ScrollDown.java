package javaScriptexecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollDown {

	public static void main(String[] args) {
		   
		    WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fapparel");
	       
	        //1] scroll down pixcel number
	         
	        JavascriptExecutor js = (JavascriptExecutor) driver;
             //js.executeScript("window.scrollBy(0,1500)", "");
             //System.out.println(js.executeScript("return window.pageYOffset"));
	         
	        //2] scroll the page till element is visible.
            WebElement element = driver.findElement(By.xpath("//strong[normalize-space()='Your Password']"));
            js.executeScript("arguments[0].scrollIntoView();", element);
	        
	      
	         
	         
	         
	         
	}

}
