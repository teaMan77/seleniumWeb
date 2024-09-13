package day10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingLoginPopUp {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		driver.get("https://the-internet.herokuapp.com/basic_auth");
		
		//syntax for login popup
		//https://username:password@the-internet.herokuapp.com/javascript_alerts
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
	}

}
