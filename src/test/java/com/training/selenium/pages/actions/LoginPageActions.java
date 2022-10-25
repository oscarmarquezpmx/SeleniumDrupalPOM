package com.training.selenium.pages.actions;

import com.training.selenium.base.Page;
import com.training.selenium.pages.locators.HomePageLocators;
import com.training.selenium.pages.locators.LoginPageLocators;
import org.openqa.selenium.support.PageFactory;

public class LoginPageActions {

    LoginPageLocators loginPageLocators = null;

    public LoginPageActions() {
        this.loginPageLocators = new LoginPageLocators();
        PageFactory.initElements(Page.driver, this.loginPageLocators);
    }

    public void performLogin(String username, String password){
        loginPageLocators.weUserTextBox.sendKeys(username);
        loginPageLocators.wePasswordTextBox.sendKeys(password);
        loginPageLocators.weloginButton.click();

    }
}
