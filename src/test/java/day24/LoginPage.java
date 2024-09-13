package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    //Driver allocation in constructor
    LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Locating the elements on the page
    By text_username = By.xpath("//input[@placeholder='Username']");
    By text_password = By.xpath("//input[@placeholder='Password']");
    By btn_login = By.xpath("//button[normalize-space()='Login']");

    //Action methods
    public void setUsername(String username)
    {
        driver.findElement(text_username).sendKeys(username);
    }

    public void setPassword(String password)
    {
        driver.findElement(text_password).sendKeys(password);
    }

    public void doLogin()
    {
        driver.findElement(btn_login).click();
    }
}
