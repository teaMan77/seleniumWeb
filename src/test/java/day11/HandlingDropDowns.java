package day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropDowns {

	public static void main(String[] args) {

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//capturing dropdown element
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='country']"));
		
		//Select object to access the list inside the dropdown menu
		Select dropDownList = new Select(dropDown);
		
		//Selecting france from the dropdown menu
		dropDownList.selectByVisibleText("France");
		
		//selecting united kingdom by value attribute
		dropDownList.selectByValue("uk");
		
		//selecting united states by index
		dropDownList.selectByIndex(0);
	}

}
