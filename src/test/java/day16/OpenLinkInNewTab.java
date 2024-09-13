package day16;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenLinkInNewTab {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		Actions act = new Actions(driver);
		
		WebElement loginLink = driver.findElement(By.xpath("//a[normalize-space()='orange HRM']"));
		
		act.keyDown(Keys.CONTROL).click(loginLink).keyUp(Keys.CONTROL).perform();
		
		Set<String> ids = driver.getWindowHandles();
		List<String> idsList = new ArrayList<String>(ids);
		
		driver.switchTo().window(idsList.get(1));
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		driver.switchTo().window(idsList.get(0));
	}

}
