package com.training.selenium.steps;

import com.training.selenium.base.Page;
import com.training.selenium.pages.actions.LoginPageActions;
import io.cucumber.java.After;
import io.cucumber.java.en.When;


import com.training.selenium.pages.locators.LoginPageLocators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.training.selenium.base.Page.*;

public class LoginPageSteps {
    private static final Logger logger = LoggerFactory.getLogger(Page.class);
    LoginPageActions loginPageActions = new LoginPageActions();
    //HomePageSteps home;

    @When("I enter Username as {string} and Password as {string}")
    public void userLogin(String username,String password)
    {
        loginPageActions.performLogin(username,password);
    }

}
