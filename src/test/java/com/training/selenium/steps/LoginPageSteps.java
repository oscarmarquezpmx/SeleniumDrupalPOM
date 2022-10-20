package com.training.selenium.steps;

import com.training.selenium.base.Page;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;


import com.training.selenium.steps.locators.LoginLocators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.training.selenium.base.Page.*;

public class LoginPageSteps {
    private static final Logger logger = LoggerFactory.getLogger(Page.class);
    LoginLocators loginloc;
    HomePageSteps home;

    public LoginPageSteps() throws InterruptedException, IOException {
    }



    @Given("Open browser and launch the application")
    public void startTheTest() throws InterruptedException, IOException {
        home = new HomePageSteps();
        home.goToLogin();
        this.loginloc = new LoginLocators();
        PageFactory.initElements(driver,this.loginloc);
    }


    @Then("user enters username")
    public void enterUser(String username) throws InterruptedException {
        enterText(loginloc.weUserTextBox,username);

    }
    @And("user enters password")
    public void enterPassword(String password) throws InterruptedException {
        enterText(loginloc.weUserTextBox,password);

    }
    @When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
    public void doLogin(String username, String password) throws InterruptedException {
        enterText(loginloc.weUserTextBox,username);
        enterText(loginloc.wePasswordTextBox,password);
        click(loginloc.weloginButton);
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
