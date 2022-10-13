package com.training.selenium.pages;

import com.training.selenium.base.Page;
import org.openqa.selenium.support.PageFactory;


import com.training.selenium.pages.locators.LoginLocators;
public class LoginPage extends Page {
    LoginLocators loginloc;

    public LoginPage() {
        this.loginloc = new LoginLocators();
        PageFactory.initElements(driver,this.loginloc);

    }

    public void doLogin(String username, String password) throws InterruptedException {
        enterText(loginloc.weUserTextBox,username);
        enterText(loginloc.wePasswordTextBox,password);
        click(loginloc.weloginButton);
    }

}
