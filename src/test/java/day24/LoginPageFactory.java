package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

    WebDriver driver;

    //Driver allocation in constructor
    LoginPageFactory(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Locating the elements on the page
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement text_username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement text_password;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement btn_login;

    //Action methods
    public void setUsername(String username)
    {

        text_username.sendKeys(username);
    }

    public void setPassword(String password)
    {

        text_password.sendKeys(password);
    }

    public void doLogin()
    {

        btn_login.click();
    }
}
