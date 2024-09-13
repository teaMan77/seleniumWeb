package day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.demoblaze.com/index.html");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links on the page: " +links.size());
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total number of images found on the page: "+ links.size());
		
		driver.findElement(By.linkText("Contact")).click();
		
//		Thread.sleep(5000);
//		driver.quit();
	}

}
