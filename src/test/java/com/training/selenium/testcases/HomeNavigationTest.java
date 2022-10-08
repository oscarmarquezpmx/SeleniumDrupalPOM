package com.training.selenium.testcases;

import com.training.selenium.pages.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class HomeNavigationTest extends HomePage  {

    public HomeNavigationTest() throws IOException {
    }

    @Test
    public void HomeTest() throws IOException, InterruptedException {

        super.goToHome();
        super.goToArticles();
        super.goToRecipes();
        super.goToLogin();

    }



}
