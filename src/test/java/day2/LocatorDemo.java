package day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");
		
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		
		//name
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Samsung");
		
		//id
//		WebElement currencyDropdDown = driver.findElement(By.id("customerCurrency"));
//		currencyDropdDown.click();
		
		//linkText and partialLinkText
//		WebElement link = driver.findElement(By.linkText("Computers"));
//		link.click();
		
		//partialLinkText
//		WebElement link = driver.findElement(By.partialLinkText("puters"));
//		link.click();
		
		//for click on search
//		driver.findElements(By.tagName("button")).get(0).click();
		
//		driver.quit();
	}

}
