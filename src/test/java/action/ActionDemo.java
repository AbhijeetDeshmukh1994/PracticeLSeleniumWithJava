package action;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();
        
        //Create Action window
        Actions actions = new Actions(driver);
        
        //Right click button(Context click)
//       WebElement rightClickBtn= driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
//       actions.contextClick(rightClickBtn).perform();
        
        //Double click
//        WebElement doubleClickBtn= driver.findElement(By.xpath("//button[normalize-space()='Double-Click Me To See Alert']"));
//        actions.doubleClick(doubleClickBtn).perform();
        
        //houver the mouse
//        WebElement hoverMouse= driver.findElement(By.xpath("//a[normalize-space()='Selenium']"));
//        actions.moveToElement(hoverMouse).perform();
        
        // 4. Drag and Drop (example site: https://demoqa.com/droppable)
        Thread.sleep(300);
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        actions.dragAndDrop(drag, drop).perform();
        
        
	}

}
