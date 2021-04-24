package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://insighttimer.com/login");
    }

    public boolean isLoaded() throws InterruptedException {
        Thread.sleep(5000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).isDisplayed();
    }

    public void login(String user, String password) throws InterruptedException {
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(user);
        Thread.sleep(5000);
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/form/button/span[1]/span")).click();
        Thread.sleep(5000);

    }
    public String getErrorMessage() {
        WebElement errorPage = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/form/div[4]/p"));
        return errorPage.getText();
    }
}


