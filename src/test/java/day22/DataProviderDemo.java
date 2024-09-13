package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderDemo {

    WebDriver driver;
    @BeforeClass
    void setup()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(dataProvider = "dp")
    void testLogin(String email, String pwd) throws InterruptedException {
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(1000);

        boolean status = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();

        if (status)
        {
            driver.findElement(By.linkText("Logout"));
            Assert.assertTrue(true);
        }
        else
            Assert.fail();
    }

    @AfterClass
    void tearDown()
    {
        driver.quit();
    }

    @DataProvider(name = "dp", indices = {0, 4}) //indices --> Only the 1st and 5th elements of creds array are passed to testLogin method.
    Object[][] loginData()
    {
        Object[][] creds = {
                {"abc@gmail.com", "123"},
                {"pqr@gmail.com", "657"},
                {"AAA@gmail.com", "123"},
                {"lmnop@gmail.com", "%%%"},
                {"tester77@gmail.com", "1234"},
                {"xyz@gmail.com", "123"},
        };

        return creds;
    }
}
