package com.training.selenium.testcases;

import com.training.selenium.base.Page;
import com.training.selenium.listeners.TestResultLoggerExtension;
//import io.qameta.allure.*;
import com.training.selenium.pages.actions.HomePageActions;
import com.training.selenium.steps.HomePageSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@Epic("Home Navigation")
@Feature("Navigation")
public class HomeNavigationTest   {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @DisplayName("Home Navigation")
    @Story("User navigates on HomePage")
    @Description("User Basic Navigation")
    @ExtendWith(TestResultLoggerExtension.class)
    @Step("Test the home page upper links")
    @Tag("smoke")
    @Test
    public void homeTest() throws IOException, InterruptedException {
        logger.info("Starting Test Login Test");
        Page.setup();
        HomePageActions homePageActions = new HomePageActions();

        homePageActions.goToHome();
        homePageActions.goToArticles();
        homePageActions.goToRecipes();

        Page.tearDown();
    }



}
