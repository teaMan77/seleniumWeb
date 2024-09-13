package day17;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement phone = driver.findElement(By.xpath("//input[@id='phone']"));
		
		//Using JavascriptExecutor instead of sendKeys method
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].setAttribute('value', 'Adarsh')", name);
		js.executeScript("arguments[0].setAttribute('value', 'adarsh@email.com')", email);
		js.executeScript("arguments[0].setAttribute('value', '00000000000')", phone);
		
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='New Browser Window']"));
		
		//Using JavascriptExecutor instead of click method
		js.executeScript("arguments[0].click()", button);
		
		
		
		
		
	}

}
