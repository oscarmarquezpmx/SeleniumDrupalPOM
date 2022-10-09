package com.training.selenium.pages;

import com.training.selenium.base.Page;
import com.training.selenium.utilities.Utilities;
import org.checkerframework.framework.qual.UpperBoundFor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.HashMap;

public class HomePage extends Page {
         @FindBy(css = ".menu-main__item > .is-active")
         public WebElement weHomeLink;

        @FindBy(css = ".menu-main__item:nth-child(2) > .menu-main__link")
        public WebElement weArticlesLink;

        @FindBy(css = ".menu-main__item:nth-child(3) > .menu-main__link")
        public WebElement weRecipesLink;

        @FindBy(css = ".menu-account__link")
        public WebElement weLoginLink;


         //WebDriver driver;
         Utilities util = new Utilities();
        public HomePage() throws IOException {
          //  this.driver = super.driver;
            util.readORFile();

        }

        public void goToHome() throws IOException, InterruptedException {

      //    HashMap<String, String> homeLink = util.getORInfo("HomePage", "-homeLink");
      //    WebElement weHomeLink = findByElement(homeLink.get("locator"), homeLink.get("value"));
          weHomeLink.click();

        }

        public void goToArticles() throws InterruptedException {
          //  HashMap<String, String> articlesLink = util.getORInfo("HomePage", "-articlesLink");
          //  WebElement weHomeLink = findByElement(articlesLink.get("locator"), articlesLink.get("value"));
            weArticlesLink.click();

        }

        public void goToRecipes() throws InterruptedException {
        //    HashMap<String, String> recipesLink = util.getORInfo("HomePage", "-recipesLink");
        //    WebElement weHomeLink = findByElement(recipesLink.get("locator"), recipesLink.get("value"));
            weRecipesLink.click();

        }

        public void goToLogin() throws InterruptedException {
        //    HashMap<String, String> loginLink = util.getORInfo("HomePage", "-loginLink");
        //    WebElement weHomeLink = findByElement(loginLink.get("locator"), loginLink.get("value"));
            weLoginLink.click();

    }




}
