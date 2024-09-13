package day11;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingHiddenDropDown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		//login
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		//navigate to PIM
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		
		//click on the dropdown
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[7]/div/div[2]/div")).click();
		Thread.sleep(5);
		
		//capture all the options from dropdown and find the size
		List<WebElement> dropDownList = driver.findElements(By.xpath("//div[@role='listbox']//span"));
		
		System.out.println("Number of options in dropdown: "+ dropDownList.size());
		
		//selecting option
		driver.findElement(By.xpath("//span[normalize-space()='Quality Assurance']")).click();
	}

}
