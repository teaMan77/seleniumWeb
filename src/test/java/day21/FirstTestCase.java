package day21;

import org.testng.annotations.Test;

/**
 * 1)open app
 * 2)login
 * 3)logout
 *
 * TestNG will execute the methods based on alphabets by default
 * Order of method execution can be controlled using priorities
 */
public class FirstTestCase {

    @Test(priority = 1)
    void openapp() {
        System.out.println("Opening the application...");
    }

    @Test(priority = 2)
    void login() {
        System.out.println("Login to the application...");
    }

    @Test(priority = 3)
    void logout() {
        System.out.println("Logout from the application...");
    }
}
