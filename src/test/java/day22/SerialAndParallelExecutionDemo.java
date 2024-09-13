package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class SerialAndParallelExecutionDemo {

    WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "url"})
    void setup(String browser, String url) throws InterruptedException {
        switch (browser.toLowerCase())
        {
            case "chrome" : driver = new ChromeDriver();
                            break;
            case "edge" : driver = new EdgeDriver();
                            break;
            case "firefox" : driver = new FirefoxDriver();
                            break;
            default : System.out.println("INVALID BROWSER");
                            return;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.manage().window().maximize();
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
        Assert.assertEquals("OrangeHRM", title);
    }

    @Test(priority = 3)
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
