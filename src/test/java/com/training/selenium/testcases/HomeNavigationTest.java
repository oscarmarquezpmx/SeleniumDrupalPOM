package com.training.selenium.testcases;

import com.training.selenium.base.Page;
import com.training.selenium.listeners.TestResultLoggerExtension;
import com.training.selenium.pages.HomePage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Set;
@Epic("Home Navigation")
@Feature("Navigation")
public class HomeNavigationTest   {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public HomeNavigationTest() throws IOException {
    }
    @DisplayName("Home Navigation")
    @Story("User navigates on HomePage")
    @Description("User Basic Navigation")
    @ExtendWith(TestResultLoggerExtension.class)
    @Step("Test the home page upper links")
    @Tag("regression")
    @Test
    public void HomeTest() throws IOException, InterruptedException {
        logger.info("Starting Test Login Test");
        Page.setup();
        HomePage home = new HomePage();
        home.goToHome();
        home.goToArticles();
        home.goToRecipes();
        Page.tearDown();
    }



}
