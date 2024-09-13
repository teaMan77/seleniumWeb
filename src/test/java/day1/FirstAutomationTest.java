package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstAutomationTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");

		String title = driver.getTitle();
		
		if(title.equals("nopCommerce demo store")) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		
		//driver.close();
		driver.quit();
	}

}
