package day15;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		field1.clear();
		field1.sendKeys("Selenium");
		
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		Actions doubleClickAction = new Actions(driver);
		doubleClickAction.doubleClick(button)
						.build()
						.perform();
		
		String field2 =	driver.findElement(By.xpath("//input[@id='field2']")).getAttribute("value");
		
		if(field2.equals("Selenium"))
		{
			System.out.println("Text Copied...!");
		}
		else
			System.out.println("Failed to copy text...!");
		
	}

}
