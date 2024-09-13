package day9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://practice.expandtesting.com/radio-buttons");
		
		List<WebElement> colorRadioButtons = driver.findElements(By.xpath("//input[@class='form-check-input'][@name='color']"));
		System.out.println("Number of radio buttons for color: "+ colorRadioButtons.size());
		
		List<WebElement> sportRadioButtons = driver.findElements(By.xpath("//input[@class='form-check-input'][@name='sport']"));
		System.out.println("Number of radio buttons for sport: "+ sportRadioButtons.size());
		
		for(WebElement rad:colorRadioButtons)
		{
			if(rad.isEnabled())
			{
				Thread.sleep(3000);
				rad.click();
			}
			else {
				System.out.println("The radio button is disabled.");
			}
		}
	}

}
