package com.training.selenium.steps;

import com.training.selenium.base.Page;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import com.training.selenium.steps.locators.LoginLocators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.training.selenium.base.Page.click;
import static com.training.selenium.base.Page.enterText;

public class LoginPageSteps {
    private static final Logger logger = LoggerFactory.getLogger(Page.class);

    //public static ChromeDriver driver;
    LoginLocators loginloc;
    //WebDriver driver;
    //static Page page = new Page();

    public LoginPageSteps() throws IOException, InterruptedException {
        HomePageSteps home = new HomePageSteps();
        //this.driver = home.driver;
        home.goToLogin();
        this.loginloc = new LoginLocators();
        PageFactory.initElements(Page.driver,this.loginloc);
    }



    @Given("Open Chrome and launch the application")
    public void startTheTest() throws InterruptedException {
        //page.setup();
      //  HomePageSteps home = new HomePageSteps();
     //   home.goToLogin();

        //LoginPageSteps loginPage = home.goToLogin();
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
        Thread.sleep(4000);
        logger.info("Closing driver");
        Page.driver.close();
       // Page.driver.quit();
    }

}
