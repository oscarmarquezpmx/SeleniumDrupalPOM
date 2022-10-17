package com.training.selenium.steps;

import com.training.selenium.base.Page;
import com.training.selenium.steps.locators.HomePageLocators;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.training.selenium.base.Page.click;
import static com.training.selenium.base.Page.enterText;

public class HomePageSteps {
        //public WebDriver driver;

        public HomePageLocators homeloc;

        public HomePageSteps() throws IOException {
           // Page page = new Page();
            Page page = new Page();
            page.setup();
            //this.driver = Page.driver;
            this.homeloc = new HomePageLocators();
            PageFactory.initElements(page.driver,this.homeloc);

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
        @Given("user navigates to login")
        public void goToLogin() throws InterruptedException, IOException {
            click(homeloc.weLoginLink);
         //   return new LoginPageSteps();

    }

        public void doSearch(String searchParameter) throws InterruptedException {
            enterText(homeloc.weSearchTextBox,searchParameter);
            click(homeloc.weSearchButton);


        }




}
