package day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {

    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://www.deadlinkcity.com/");

        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links on the webpage: " + linksList.size());
        for(WebElement link:linksList)
        {
            String href = link.getAttribute("href");

            if (href == null || href.isEmpty()) {
                System.out.println("The link cannot be accessed because the href value is null or empty");
                continue;
            }

            URL url = new URL(href);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            if(conn.getResponseCode() >= 400) {
                System.out.println(href+ " ====> is broken");
            } else
                System.out.println(href+ " ====> is not broken");
        }
    }
}
