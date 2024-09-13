package day6;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
//		System.out.println(driver.getPageSource());
		
		//getWindowHandle() --> returns the ID of the single browser window -- id is different every time the window is opened.
		System.out.println(driver.getWindowHandle());
		
		driver.findElement(By.cssSelector("a[href='https://www.nopcommerce.com/']")).click();
		
		Set<String> windowIds = driver.getWindowHandles();
		
		System.out.println(windowIds);
		
	}

}
