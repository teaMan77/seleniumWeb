package day9;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCheckboxes {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");

		//select the checkbox
		WebElement checkBox = driver.findElement(By.xpath("//*[@id='sunday']"));

		System.out.println("Before selection: "+ checkBox.isSelected());
		checkBox.click();
		System.out.println("After selection: "+ checkBox.isSelected());
		
		//capturing all the checkboxes
		List<WebElement> checkBoxList = driver.findElements(By.xpath("//input[@class='form-check-input'][@type='checkbox']"));
		System.out.println("Number of checkboxes: "+ checkBoxList.size());
		
		for(WebElement e:checkBoxList)
		{
			e.click();
		}
		
	}

}
