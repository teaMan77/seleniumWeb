package day14;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatepickerDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(0);
		
		driver.findElement(By.id("datepicker")).click();
		
		String month = "September";
		String day = "29";
		String year = "2025";
		
		while(true)
		{
			String currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
			String currentYear = driver.findElement(By.className("ui-datepicker-year")).getText();
			
			if(currentMonth.equals(month) && currentYear.equals(year))
			{
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		List<WebElement> dates = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a"));
		
		for(WebElement date:dates)
		{
			if(date.getText().equals(day))
			{
				date.click();
				break;
			}
		}
		
		WebElement dateSelected = driver.findElement(By.id("datepicker"));
		System.out.println(dateSelected.getAttribute("value"));
		
		driver.quit();
	}

}
