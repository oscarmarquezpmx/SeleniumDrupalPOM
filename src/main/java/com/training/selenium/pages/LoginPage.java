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



    public void enterUserName(String username) {
        //HashMap<String, String> userTextBox = util.getORInfo("LoginPage", "-userTextBox");
        //WebElement weUserTextbox = findByElement(userTextBox.get("locator"), userTextBox.get("value"));
        loginloc.weUserTextBox.sendKeys(username);
    }

    public void enterPassword(String password) {
   //     HashMap<String, String> passwordTextBox = util.getORInfo("LoginPage", "-passwordTextBox");
  //      WebElement wePasswordTextBox = findByElement(passwordTextBox.get("locator"), passwordTextBox.get("value"));
        loginloc.wePasswordTextBox.sendKeys(password);
    }

    public void clickOnLogin() {
        //HashMap<String, String> loginButton = util.getORInfo("LoginPage", "-loginButton");
        //WebElement weloginButton = findByElement(loginButton.get("locator"), loginButton.get("value"));
        loginloc.weloginButton.click();
    }

    public void doLogin(String user, String password) {
        enterUserName(user);
        enterPassword(password);
        clickOnLogin();

    }

}
