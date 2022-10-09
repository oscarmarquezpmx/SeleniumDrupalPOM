package com.training.selenium.testcases;

import com.training.selenium.pages.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class HomeNavigationTest   {

    public HomeNavigationTest() throws IOException {
    }

    @Test
    public void HomeTest() throws IOException, InterruptedException {

        String driversPath = System.getProperty("driversPath").replace("'", "");
        System.setProperty("webdriver.chrome.driver", driversPath + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://drupal.docker.localhost:8000/");

        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.goToHome();
        home.goToArticles();
        home.goToRecipes();

    }



}
