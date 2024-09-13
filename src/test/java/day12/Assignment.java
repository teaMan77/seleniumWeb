package day12;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://blazedemo.com/");
		
		//capturing dropdown
		WebElement fromDropDown = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select selectFrom = new Select(fromDropDown);
		
		selectFrom.selectByVisibleText("Boston");
		
		WebElement toDropDown = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select selectTo = new Select(toDropDown);
		
		selectTo.selectByVisibleText("New York");
		
		driver.findElement(By.cssSelector("input[value='Find Flights']")).click();
		
		//capturing list of prices
		List<String> priceList = new ArrayList<String>();
		int rows = driver.findElements(By.xpath("//table[@class='table']//tr")).size();
		for(int r=1; r<rows; r++)
		{
			String price = driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[6]")).getText();
			priceList.add(price);
			Thread.sleep(5000);
		}
		
		 Collections.sort(priceList);
		 String lowestPrice = priceList.get(0);
		 
		 for(int r=1; r<=rows; r++)
		 {
			 String price = driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[6]")).getText();
			 
			 if(price.equals(lowestPrice)) {
				 driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[1]")).click();
				 break;
			 }
		 }
		 
		 //filling the form data
		 driver.findElement(By.id("inputName")).sendKeys("Adarsh Hegde");
		 driver.findElement(By.id("address")).sendKeys("J P Nagar");
		 driver.findElement(By.id("city")).sendKeys("Bengaluru");
		 driver.findElement(By.id("state")).sendKeys("Karnataka");
		 driver.findElement(By.id("zipCode")).sendKeys("560076");
		 Select select = new Select(driver.findElement(By.id("cardType")));
		 select.selectByValue("amex");
		 driver.findElement(By.id("creditCardNumber")).sendKeys("34553242423425");
		 driver.findElement(By.id("creditCardMonth")).sendKeys("09");
		 driver.findElement(By.id("creditCardYear")).sendKeys("2025");
		 driver.findElement(By.id("nameOnCard")).sendKeys("Adarsh Hegde");
		 driver.findElement(By.id("rememberMe")).click();
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		 
		 String message = driver.findElement(By.xpath("//h1")).getText();
		 System.out.println(message);
		 
		 driver.quit();
	}

}
