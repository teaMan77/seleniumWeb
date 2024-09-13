package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");
		
		//absolute Xpath
		/*WebElement searchBox = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[2]/form/input"));
		searchBox.sendKeys("Samsung");
		
		WebElement searchButton = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[2]/form/button"));
		searchButton.click();*/
		
		//relative Xpath
//		WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
//		searchBox.sendKeys("Samsung");
		
//		WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
//		searchButton.click();
		
		//xpath with text() --> innerText.
//		WebElement searchButton = driver.findElement(By.xpath("//button[text() = 'Search']"));
//		searchButton.click();
//		
		
		//Capturing text plain text
//		WebElement plaintext = driver.findElement(By.xpath("//h2[text()='Welcome to our store']"));
//		boolean status = plaintext.isDisplayed();
//		System.out.println(status);
//		
//		WebElement text = driver.findElement(By.xpath("//h2[text()='Welcome to our store']"));
//		String capture = text.getText();
//		
//		System.out.println(capture);
		
		//xpath with contains()
//		WebElement searchBox = driver.findElement(By.xpath("//input[contains(@placeholder, 'store')]"));
//		searchBox.sendKeys("Samsung");
//		
//		WebElement searchButton = driver.findElement(By.xpath("//button[contains(@type, 'sub')]"));
//		searchButton.click();
		
		//xpath with starts-with()
//		WebElement searchBox = driver.findElement(By.xpath("//input[starts-with(@placeholder, 'Sea')]"));
//		searchBox.sendKeys("Samsung");
//		
//		WebElement searchButton = driver.findElement(By.xpath("//button[starts-with(@type, 'sub')]"));
//		searchButton.click();
		
		//chained xpath -- combination of absolute and relative xpath
		// //div[@id='header-logo']/a/img
		boolean status = driver.findElement(By.xpath("//div[@class='header-logo']/a/img")).isDisplayed();
		System.out.println(status);
		
	}

}
