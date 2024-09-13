package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cssSelectorsDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");
		
		//tag#id -- tag is optional
//		driver.findElement(By.cssSelector("select#customerCurrency")).click();
		//tag.className -- tag is optional
		driver.findElement(By.cssSelector("a.ico-login")).click();
		//tag[attribute='value']
		System.out.println("The image is displayed: " + driver.findElement(By.cssSelector("img[alt='nopCommerce demo store']")).isDisplayed());
		//tag.className[attribute='value']
		

	}

}
