package com.training.selenium.pages.actions;

import com.training.selenium.base.Page;
import com.training.selenium.pages.locators.HomePageLocators;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.training.selenium.base.Page.click;
import static com.training.selenium.base.Page.enterText;

public class HomePageActions {

    HomePageLocators homePageLocators = null;

    public HomePageActions() {
        this.homePageLocators = new HomePageLocators();
        PageFactory.initElements(Page.driver, this.homePageLocators);
    }

   public void goToHome(){

       homePageLocators.weHomeLink.click();
   }
    public void goToArticles() throws InterruptedException {
        homePageLocators.weArticlesLink.click();

    }

    public void goToRecipes() throws InterruptedException {
        homePageLocators.weRecipesLink.click();

    }
    public void goToLogin() throws InterruptedException, IOException {
        homePageLocators.weLoginLink.click();
    }

    public void doSearch(String searchParameter) throws InterruptedException {
        homePageLocators.weSearchTextBox.sendKeys(searchParameter);
        homePageLocators.weSearchButton.click();
    }
}
