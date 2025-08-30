package genericMethods;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fapparel");
        driver.manage().window().maximize();
      
        //1] take full screenshot.
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
//        File targetFile = new File(System.getProperty("user.dir")+"\\screenshots\\FullPage.png");
//        sourceFile.renameTo(targetFile);
        
        //2] capture screenshot specific webelement.
//        WebElement logo =driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
//        File sourceFile = logo.getScreenshotAs(OutputType.FILE);
//        File targetFile = new File (System.getProperty("user.dir")+"\\screenshots\\Logo.png");
//        sourceFile.renameTo(targetFile);
        
        //3] capture screenshot specific area.
        WebElement headerMenu = driver.findElement(By.xpath("//div[@class='header-menu']"));
        File sourceFile =headerMenu.getScreenshotAs(OutputType.FILE);
        File tagetFile = new File(System.getProperty("user.dir")+"\\screenshots\\HeaderMenu.png");
        sourceFile.renameTo(tagetFile);
        
        
        
        
        
        

	}

}
