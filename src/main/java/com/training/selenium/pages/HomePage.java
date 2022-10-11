package com.training.selenium.pages;

import com.training.selenium.base.Page;
import com.training.selenium.pages.locators.HomePageLocators;
import com.training.selenium.utilities.Utilities;
import org.checkerframework.framework.qual.UpperBoundFor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.HashMap;

public class HomePage extends Page{

        public HomePageLocators homeloc;
         //WebDriver driver;
         //Utilities util = new Utilities();
        public HomePage() throws IOException {
          //  this.driver = super.driver;
          //  util.readORFile();
            this.homeloc = new HomePageLocators();
            PageFactory.initElements(driver,this.homeloc);

        }

        public void goToHome() throws IOException, InterruptedException {

      //    HashMap<String, String> homeLink = util.getORInfo("HomePage", "-homeLink");
      //    WebElement weHomeLink = findByElement(homeLink.get("locator"), homeLink.get("value"));
          homeloc.weHomeLink.click();

        }

        public void goToArticles() throws InterruptedException {
          //  HashMap<String, String> articlesLink = util.getORInfo("HomePage", "-articlesLink");
          //  WebElement weHomeLink = findByElement(articlesLink.get("locator"), articlesLink.get("value"));
            homeloc.weArticlesLink.click();

        }

        public void goToRecipes() throws InterruptedException {
        //    HashMap<String, String> recipesLink = util.getORInfo("HomePage", "-recipesLink");
        //    WebElement weHomeLink = findByElement(recipesLink.get("locator"), recipesLink.get("value"));
            homeloc.weRecipesLink.click();

        }

        public LoginPage goToLogin() throws InterruptedException {
        //    HashMap<String, String> loginLink = util.getORInfo("HomePage", "-loginLink");
        //    WebElement weHomeLink = findByElement(loginLink.get("locator"), loginLink.get("value"));
            homeloc.weLoginLink.click();
            return new LoginPage();

    }

        public void doSearch(String searchParameter){
            homeloc.weSearchTextBox.sendKeys(searchParameter);
            homeloc.weSearchButton.click();


        }




}
