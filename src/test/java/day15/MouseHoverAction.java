package day15;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://stqatools.com/demo/MouseHover.php");
		
		WebElement menu = driver.findElement(By.xpath("//button[normalize-space()='Mouse Hover DropDown']"));
		
		
		Actions hover = new Actions(driver);
		
		hover.moveToElement(menu)
			.moveToElement(driver.findElement(By.xpath("//a[normalize-space()='Link 2']")))
			.click()
			.build()
			.perform();
	
		driver.quit();
	}

}
