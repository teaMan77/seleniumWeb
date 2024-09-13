package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

//@Listeners(day23.MyListener.class)  ===> this is an alternative to integrating listener via xml file(recommended).
public class ListenersDemo {

    WebDriver driver;

    @BeforeClass
    void setup() throws InterruptedException
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    void testLogo()
    {
        boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
        Assert.assertTrue(status);
    }

    @Test(priority = 2)
    void testTitle()
    {
        String title = driver.getTitle();
        Assert.assertEquals("PurpleHRM", title);
    }

    @Test(priority = 3, dependsOnMethods = "testTitle")
    void testUrl()
    {
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", url);
    }

    @AfterClass
    void tearDown()
    {
        driver.quit();
    }
}
