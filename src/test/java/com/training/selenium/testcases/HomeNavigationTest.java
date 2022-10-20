package com.training.selenium.testcases;

import com.training.selenium.steps.HomePageSteps;
//import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

//@Epic("Home Navigation")
//@Feature("Navigation")
public class HomeNavigationTest   {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public HomeNavigationTest() throws IOException {
    }
    @DisplayName("Home Navigation")
   // @Story("User navigates on HomePage")
  //  @Description("User Basic Navigation")
    //@ExtendWith(TestResultLoggerExtension.class)
   // @Step("Test the home page upper links")
    @Tag("regression")
    @Test
    public void HomeTest() throws IOException, InterruptedException {
        logger.info("Starting Test Login Test");
        //Page.setup();
        HomePageSteps home = new HomePageSteps();
        home.goToHome();
        home.goToArticles();
        home.goToRecipes();
       // Page.tearDown();
    }



}
