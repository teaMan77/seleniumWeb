package day15;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropActions {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement dragSource = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropTarget = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions dragAndDropAction = new Actions(driver);
		dragAndDropAction.dragAndDrop(dragSource, dropTarget)
						.build()
						.perform();
		
		System.out.println(driver.findElement(By.xpath("//p[normalize-space()='Dropped!']")).getText());
		
	}

}
