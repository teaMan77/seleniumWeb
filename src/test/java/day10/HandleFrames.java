package day10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		//switching to frame 1
		WebElement frame1 = driver.findElement(By.cssSelector("frame[src='frame_1.html']"));
		
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.cssSelector("input[name='mytext1']")).sendKeys("Welcome To");
		
		driver.switchTo().defaultContent(); //switch to main page before switching to other frames
		
		//switching to frame 2
		WebElement frame2 = driver.findElement(By.cssSelector("frame[src='frame_2.html']"));
		
		driver.switchTo().frame(frame2);
		
		driver.findElement(By.cssSelector("input[name='mytext2']")).sendKeys("Automation");
		
		driver.switchTo().defaultContent();
		
		//switching to inner frames or nested frames
		
		//switch to frame 3
		WebElement frame3 = driver.findElement(By.cssSelector("frame[src='frame_3.html']"));
		
		driver.switchTo().frame(frame3);
		
		driver.findElement(By.cssSelector("input[name='mytext3']")).sendKeys("Programming");
		
		//switch to inner frame
		WebElement iframe = driver.findElement(By.cssSelector("iframe[src='https://docs.google.com/forms/d/1yfUq-GO9BEssafd6TvHhf0D6QLDVG3q5InwNE2FFFFQ/viewform?embedded=true']"));
//		driver.switchTo().frame(iframe);
		
		//or use indexing to switch
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div[1]/div/span/div/div[1]/label/div/div[1]")).click();
		
		driver.switchTo().defaultContent();
		
		//switching to frame 5
		WebElement frame5 = driver.findElement(By.cssSelector("frame[src='frame_5.html']"));
		
		driver.switchTo().frame(frame5);
		
		driver.findElement(By.cssSelector("a[href='https://a9t9.com']")).click();
		
		//checking if the logo is displayed or not
		boolean status = driver.findElement(By.cssSelector("img[alt='UI Vision by a9t9 software - Image-Driven Automation']")).isDisplayed();
		System.out.println("Logo is displayed: " + status);
		
		driver.switchTo().defaultContent();
		
	}

}
