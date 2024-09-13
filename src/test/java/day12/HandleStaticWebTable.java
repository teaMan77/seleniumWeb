package day12;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleStaticWebTable {

	public static void main(String[] args) {

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//find the total number of rows in the table
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Total Rows: "+ rows);
		
		//find the total number of columns in the table
		int columns = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("Total Columns: "+ columns);
		
		//read data from specific row and column (ex: 5th row and 1st column)
		String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]/td[1]")).getText();
		System.out.println("BookName: " + bookName);
		
		//read data from all rows and columns
//		for( int h=1; h <= columns; h++)
//		{
//		System.out.print(driver.findElement(By.xpath("//table[@name='BookTable']//th["+h+"]")).getText());
//		System.out.print("\t");
//		}
//		System.out.println();
//		for(int r=2; r <= rows; r++)
//		{
//			for(int c=1; c <= columns; c++)
//			{
//				System.out.print(driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td["+c+"]")).getText());
//				System.out.print("\t");
//			}
//			System.out.println();
//		}
		
		//print book name whose author is Mukesh
		
//		for(int r=2; r<=rows; r++)
//		{
//			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[2]")).getText();
//			
//			if (author.equals("Mukesh")) {
//				String bookname = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[1]")).getText();
//				System.out.println(bookname+"\t"+author);
//			}
//		}
		
		//find the total price of all the books in the table
		int total = 0;
		for(int r=2; r<=rows; r++)
		{
			int price = Integer.parseInt(driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[4]")).getText());
			total = total + price;
		}
	
		System.out.println("Total Price: " + total);
		
		driver.quit();
	}

}
