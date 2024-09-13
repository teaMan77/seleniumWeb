package day11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropDown {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		
		driver.findElement(By.xpath("//button[contains(@class, 'multiselect')]")).click(); //opens dropdown
		
		//Select single option
//		driver.findElement(By.xpath("//label[normalize-space()='MySQL']")).click();
		
		//capture all the options and find out the size
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//div//ul//label[@class='checkbox']"));
		System.out.println("Number of clickable options present in the dropdown: " + checkBoxes.size());
		
		String option = null;
		//printing options from the dropdown
		for(WebElement element:checkBoxes) {
			option = element.getText();
			System.out.println(option);
			
			//select multiple options from the dropdown
			if(option.equals("Java") || option.equals("jQuery") || option.equals("Oracle"))
			{
				element.click();
			}
		}
		
		
		
		
		
	}

}
