package com.training.selenium.pages;

import com.training.selenium.base.Page;
import com.training.selenium.utilities.Utilities;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.HashMap;

public class LoginPage extends Page {

    Utilities util = new Utilities();
    public LoginPage() throws IOException {
        //  this.driver = super.driver;
        util.readORFile();

    }

    public void enterUserName(String username) throws InterruptedException {
        HashMap<String, String> userTextBox = util.getORInfo("LoginPage", "-userTextBox");
        WebElement weUserTextbox = findByElement(userTextBox.get("locator"), userTextBox.get("value"));
        weUserTextbox.sendKeys(username);
    }

    public void enterPassword(String password) throws InterruptedException {
        HashMap<String, String> passwordTextBox = util.getORInfo("LoginPage", "-passwordTextBox");
        WebElement wePasswordTextBox = findByElement(passwordTextBox.get("locator"), passwordTextBox.get("value"));
        wePasswordTextBox.sendKeys(password);
    }

    public void clickOnLogin() throws InterruptedException {
        HashMap<String, String> loginButton = util.getORInfo("LoginPage", "-loginButton");
        WebElement weloginButton = findByElement(loginButton.get("locator"), loginButton.get("value"));
        weloginButton.click();
    }

    public void doLogin(String user, String password) throws InterruptedException {
        enterUserName(user);
        enterPassword(password);
        clickOnLogin();

    }

}
