package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		driver.manage().window().maximize();
		
		//isDisplayed()
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println(logo.isDisplayed());
		
		//isEnabled()
		System.out.println(driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled());
		
		//isSelected()
		WebElement male = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female = driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		//before selecting
		System.out.println("Before Selecting----------");
		System.out.println(male.isSelected()); //false
		System.out.println(female.isSelected()); //false

		male.click();
		
		//after selecting male
		System.out.println("After selecting male---------");
		System.out.println(male.isSelected()); //true
		System.out.println(female.isSelected()); //false
		
		female.click();
		
		//after selecting female
		System.out.println("After selecting female--------");
		System.out.println(male.isSelected()); //false
		System.out.println(female.isSelected()); //true
		
		
	}

}
