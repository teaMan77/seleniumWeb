package day13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingDynamicPaginationTable {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo-opencart.com/admin/index.php?route=common/login");
		
		driver.findElement(By.id("input-username")).sendKeys("demo");
		driver.findElement(By.id("input-password")).sendKeys("demo");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement close = driver.findElement(By.xpath("//button[@class='btn-close']"));
		
		if(close.isDisplayed()) {
			close.click();
		}
		
		driver.findElement(By.xpath("//div//ul//li[@id='menu-customer']")).click();
		driver.findElement(By.xpath("//div//ul//li[@id='menu-customer']//ul//*[contains(text(), 'Customers')]")).click();
		
		String text = driver.findElement(By.xpath("//div[contains(text(), 'Showing')]")).getText();
		
		int totalPages = Integer.parseInt(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1)); 
		System.out.println("Total Pages:" + totalPages);
		
		String customerName = null;
		String email = null;
		
		for(int p=1; p<=3; p++)
		{
			if(p>1)
			{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()='"+p+"']")))).click();
				
			}
			
			int rows = driver.findElements(By.xpath("//table//tbody/tr")).size();
			
			for(int r=1; r<=rows; r++)
			{
			customerName = driver.findElement(By.xpath("//table//tbody/tr["+r+"]//td[2]")).getText();
			email = driver.findElement(By.xpath("//table//tbody/tr["+r+"]//td[3]")).getText();
			
			System.out.println(customerName+"\t"+email);
			}
		}
		
		driver.quit();
	}

}
