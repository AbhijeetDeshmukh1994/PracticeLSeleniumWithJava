package frame;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");
		WebElement frame1 =driver.findElement(By.cssSelector("frame[src='frame_1.html']"));
        driver.switchTo().frame(frame1);//webelement 
        //driver.switchTo().frame(0);//index
        //driver.switchTo().frame(null);// String name or id
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Abhijeet");
        Thread.sleep(3000);
	}

}
