package genericMethods;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchTo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		String parentWindow =driver.getWindowHandle();
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		Thread.sleep(3000);
		Set <String> allWindows = driver.getWindowHandles();
		for(String windowHandle:allWindows) {
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		WebElement emailField = driver.findElement(By.id("Form_submitForm_EmailHomePage"));
		emailField.sendKeys("qa.abhijeetdeshmukh@gmail.com");
		//driver.close();
		driver.switchTo().window(parentWindow);
//		driver.switchTo().frame(0);
//		driver.switchTo().alert();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Abhijeet");
		
		Thread.sleep(3000);

	}

}
