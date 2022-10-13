package com.training.selenium.pages;

import com.training.selenium.base.Page;
import com.training.selenium.pages.locators.HomePageLocators;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends Page{

        public HomePageLocators homeloc;
        public HomePage() throws IOException {
            this.homeloc = new HomePageLocators();
            PageFactory.initElements(driver,this.homeloc);

        }

        public void goToHome() throws IOException, InterruptedException {
          click(homeloc.weHomeLink);

        }

        public void goToArticles() throws InterruptedException {
            click(homeloc.weArticlesLink);

        }

        public void goToRecipes() throws InterruptedException {
            click(homeloc.weRecipesLink);

        }

        public LoginPage goToLogin() throws InterruptedException {
            click(homeloc.weLoginLink);
            return new LoginPage();

    }

        public void doSearch(String searchParameter) throws InterruptedException {
            enterText(homeloc.weSearchTextBox,searchParameter);
            click(homeloc.weSearchButton);


        }




}
