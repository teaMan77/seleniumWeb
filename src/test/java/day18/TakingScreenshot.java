package day18;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

public class TakingScreenshot {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        //Take a full page screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
//        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
//        File targetFile = new File("D:\\seleniumWeb\\screenshots\\fullpage.png");
//        sourceFile.renameTo(targetFile);

        //capture screenshot of specific section
//        WebElement pageTable = driver.findElement(By.xpath("//div[@id='HTML8']"));
//        File sourceFile = pageTable.getScreenshotAs(OutputType.FILE);
//        File targetFile = new File("D:\\seleniumWeb\\screenshots\\pageTable.png");
//        sourceFile.renameTo(targetFile);

        //capture screenshot of a specific web element
        WebElement title = driver.findElement(By.xpath("//h1[normalize-space()='Automation Testing Practice']"));
        File sourceFIle = title.getScreenshotAs(OutputType.FILE);
        File targetFile = new File("D:\\seleniumWeb\\screenshots\\title.png");
        sourceFIle.renameTo(targetFile);
    }
}
