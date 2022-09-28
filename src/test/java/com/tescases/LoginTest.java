package com.tescases;

import com.base.TestBase;
import com.listeners.TestResultLoggerExtension;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.HashMap;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@Epic("Login Tests Epic")
@Feature("Login Features")
public class LoginTest extends TestBase {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    @DisplayName("loginAsAdmin")
    @ParameterizedTest
    @MethodSource("loginUsers")
    @Story("User tries to login the system with valid username and valid password.")
    @Description("Valid Login Test with valid Username and valid Password.")
    @ExtendWith(TestResultLoggerExtension.class)
    void loginAsAdmin(String user, String password, String validation) throws InterruptedException {
        logger.info("Starting Test Login Test");
        HashMap<String,String> login = util.getORInfo("HomePage","-login");
        HashMap<String,String> userTextBox = util.getORInfo("LoginPage","-login_name");
        HashMap<String,String> userPassword = util.getORInfo("LoginPage","-login_password");
        HashMap<String,String> loginButton = util.getORInfo("LoginPage","-login_button");
        HashMap<String,String> user_name = util.getORInfo("AfterLoginPage","-user_name");

        WebElement weLogin   = findByElement(login.get("locator"),login.get("value"));
        Assertions.assertTrue(weLogin.isDisplayed());
        weLogin.click();
        WebElement weUserTextBox   = findByElement(userTextBox.get("locator"),userTextBox.get("value"));
        WebElement weUserPassword   = findByElement(userPassword.get("locator"),userPassword.get("value"));
        WebElement weloginButton   = findByElement(loginButton.get("locator"),loginButton.get("value"));


        Assertions.assertTrue(weUserTextBox.isDisplayed());
        Assertions.assertTrue(weUserPassword.isDisplayed());
        weUserTextBox.sendKeys(user);
        weUserPassword.sendKeys(password);
        Assertions.assertTrue(weloginButton.isDisplayed());
        weloginButton.click();

        WebElement weUserName   = findByElement(user_name.get("locator"),user_name.get("value"));
        System.out.println(weUserName.getText());
        Assertions.assertTrue(weUserName.getText().contains(validation));

/*

        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.linkText("Articles")).click();
        driver.findElement(By.linkText("Recipes")).click();
        driver.findElement(By.linkText("Log out")).click();
        Assertions.assertTrue(isElementPresent(By.cssSelector(".site-logo > img")));
        Assertions.assertTrue(isElementPresent(By.cssSelector(".block-inner")));
        Assertions.assertTrue(isElementPresent (By.cssSelector("#edit-submit")));*/
    }

    private static Stream<Arguments> loginUsers() {
        return Stream.of(
                arguments("oscar", "Ogmp.12345os","oscar")
        );
    }


}
