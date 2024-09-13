package day8;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		List<WebElement> searchResultList = driver.findElements(By.xpath("//*[@id='wikipedia-search-result-link']/a"));
		System.out.println(searchResultList.size());
		
		for(WebElement link:searchResultList)
		{
			link.click();
		}
		
		Set<String> windowIds = driver.getWindowHandles();
		for(String winId:windowIds)
		{
			String title = driver.switchTo().window(winId).getTitle();
			
			if(title.equals("Selenium - Wikipedia") || title.equals("Selenium dioxide - Wikipedia"))
			{
				System.out.println("Closing: " + driver.getTitle());
				driver.close();
			}
		}
	}

}
