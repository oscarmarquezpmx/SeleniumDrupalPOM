package com.training.selenium.steps;

import com.training.selenium.pages.actions.HomePageActions;
import com.training.selenium.pages.locators.HomePageLocators;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.IOException;

import static com.training.selenium.base.Page.*;


public class HomePageSteps {
        //public WebDriver driver;
    public HomePageLocators homeloc;
    HomePageActions homePageActions = new HomePageActions();

    @Given("Open browser and launch the application")
    public void startTheTest() throws InterruptedException, IOException {
        HomePageActions homePageActions = new HomePageActions();
    }

    @When("Open the login page")
    public void openLoginPage() throws IOException, InterruptedException {
        homePageActions.goToLogin();
    }

    @When("I enter a search value {string}")
    public void performSearch(String searchTerm) throws InterruptedException {
        homePageActions.doSearch(searchTerm);
    }

    @After
    public void tearDown() throws InterruptedException {
        try {
            driver.quit();
            driver = null;
        }
        catch(Exception e){
            System.out.println(e);
        }
    }







}
