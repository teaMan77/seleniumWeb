package day11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDynamicDropDown {

	/**
	 * Dynamic dropdowns are auto suggestion search box like google search
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		Thread.sleep(5000);
		
		List<WebElement> resultList = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
		
		System.out.println("Size: " + resultList.size());
		
		for(WebElement li:resultList)
		{
			System.out.println(li.getText());
		}
		

	}

}
