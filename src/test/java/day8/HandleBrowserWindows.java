package day8;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");
		
		driver.findElement(By.cssSelector("a[href='https://www.nopcommerce.com/']")).click();
		
		Set<String> windowIds = driver.getWindowHandles();
		
		//Approach 1
		/*
		 * List<String> windowList = new ArrayList(windowIds);
		 * 
		 * String parentId = windowList.get(0); String childId = windowList.get(1);
		 * 
		 * System.out.println(driver.getTitle());
		 * 
		 * //switching to child window driver.switchTo().window(childId);
		 * System.out.println(driver.getTitle());
		 * 
		 * //switching to parent window driver.switchTo().window(parentId);
		 * System.out.println(driver.getTitle());
		 */
		
		//Approach 2
		for(String winId:windowIds)
		{
			String title = driver.switchTo().window(winId).getTitle();
			
			if(title.equals("Free and open-source eCommerce platform. ASP.NET Core based shopping cart. - nopCommerce"))
			{
				System.out.println(driver.getCurrentUrl());
				driver.close();
			}
		}
	}

}
