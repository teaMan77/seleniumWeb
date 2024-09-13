package day16;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/slider/#range");
		
		driver.switchTo().frame(0);
		
		Actions SliderAction = new Actions(driver);
		
		//Minimum range slider
		WebElement minSlider = driver.findElement(By.xpath("//span[1]"));
		System.out.println(minSlider.getLocation());
		
		
		SliderAction.dragAndDropBy(minSlider, 100, 0)
					.build()
					.perform();
		
		System.out.println(minSlider.getLocation());
		
		//Maximum range slider
		WebElement maxSlider = driver.findElement(By.xpath("//span[2]"));
		System.out.println(maxSlider.getLocation());
		
		SliderAction.dragAndDropBy(maxSlider, -100, 0)
					.build()
					.perform();
		
		System.out.println(maxSlider.getLocation());
		
	}

}
