package day15;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Right click action is also known as context click
 *
 */
public class RightClickAction {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		WebElement rightClickButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		Actions contextClickAction = new Actions(driver);
		contextClickAction.contextClick(rightClickButton)
						.build()
						.perform();
		
		driver.findElement(By.xpath("//span[normalize-space()='Quit']")).click();
		
		Alert myAlert = driver.switchTo().alert();
		String alertMsg = myAlert.getText();
		myAlert.accept();
		
		if(alertMsg.contains("quit")) {
			System.out.println("Success...!");
		}
		else
			System.out.println("Failed...!");
		
	}

}
