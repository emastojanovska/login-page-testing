package com.example.demo;

import com.example.demo.InsightTimerPage;
import com.example.demo.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
public class InsightTimerLoginPageTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = getDriver();
    }

    //Test if the login page is successfully loaded
    @Test
    public void shouldOpen() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
    }

    //Test the login page with invalid email
    @Test
    public void canNotLoginWithInvalidUserNameTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("lalala", "123.");
        String errorMessage = loginPage.getErrorMessage();
        assertTrue(errorMessage != null);
    }
    //Test the login page with empty email and password
    @Test
    public void emptyEmailAndPasswordTest() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("", "");
        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, "Your email address format is incorrect. Please check it and try again");
    }
    ////Test the login page with invalid password
    @Test
    public void invalidPasswordTest() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("emastojanovska52@gmail.com", "rdrftgyhj");
        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, "Unable to login. Please check your password and try again");
    }

    //Test successful login
    //These user and password parameters should be filled with valid email and password
    @Test
    public void successfulLoginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        InsightTimerPage insightTimerPage = new InsightTimerPage(driver);
        loginPage.login("emastojanovska52@gmail.com", "");
        assertTrue(insightTimerPage.isLoaded());
    }

    private WebDriver getDriver() {

        System.setProperty("webdriver.chrome.driver","/Users/Dell/Desktop/LoginPageTesting/src/main/resources/drivers/chromedriver.exe");
        return new ChromeDriver();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}
