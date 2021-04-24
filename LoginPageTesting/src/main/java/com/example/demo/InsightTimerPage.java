package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InsightTimerPage extends BasePage {

    public InsightTimerPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/section/h1"))).isDisplayed();

    }
}