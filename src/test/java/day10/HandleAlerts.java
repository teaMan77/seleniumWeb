package day10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//Normal alert with OK button
		/*
		 * driver.findElement(By.
		 * xpath("//button[normalize-space()='Click for JS Alert']")).click();
		 * Thread.sleep(5000);
		 * 
		 * Alert myAlert = driver.switchTo().alert(); myAlert.accept();
		 */
		
		//Alert with ok and cancel button
		/*
		 * driver.findElement(By.
		 * xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		 * Thread.sleep(5000);
		 * 
		 * // driver.switchTo().alert().accept(); //for clicking ok
		 * driver.switchTo().alert().dismiss(); //for clicking cancel
		 */	
	
		//Prompt alert -- input box
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(5000);
		
		Alert myAlert = driver.switchTo().alert();
		System.out.println("Message displayed on alert: " + myAlert.getText());
		
		myAlert.sendKeys("Adarsh");
		Thread.sleep(5000);
		myAlert.accept();
		
		String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
		
		if(result.contains("Adarsh"))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
	}
}
