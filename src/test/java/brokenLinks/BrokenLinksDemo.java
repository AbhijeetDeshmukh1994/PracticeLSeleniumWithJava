package brokenLinks;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksDemo {

    @Test
    public void brokenLinks() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links found: " + links.size());

        for (int i = 0; i < links.size(); i++) {
            WebElement element = links.get(i);
            String url = element.getDomAttribute("href");

            // Skip null or javascript links
            if (url == null || url.isEmpty() || url.startsWith("javascript")) {
                continue;
            }

            try {
                URL link = new URL(url); // Convert string to URL
                HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
                httpConn.setConnectTimeout(5000); // timeout after 5 sec
                httpConn.connect();

                int responseCode = httpConn.getResponseCode();

                if (responseCode >= 400) {
                    System.out.println(url + " --> is a Broken Link (HTTP " + responseCode + ")");
                } else {
                    System.out.println(url + " --> is a Valid Link (HTTP " + responseCode + ")");
                }

            } catch (Exception e) {
                System.out.println(url + " --> Exception: " + e.getMessage());
            }
        }

        driver.quit();
    }
}
