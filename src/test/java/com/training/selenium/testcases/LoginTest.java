package com.training.selenium.testcases;

import com.training.selenium.base.Page;
import com.training.selenium.listeners.TestResultLoggerExtension;
import com.training.selenium.pages.HomePage;
import com.training.selenium.pages.LoginPage;
import com.training.selenium.utilities.UtilFastExcel;
import io.qameta.allure.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;


@Epic("Login Tests Epic")
@Feature("Login Features")
//@Execution(ExecutionMode.CONCURRENT)
public class LoginTest extends LoginPage {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    SoftAssertions softly = new SoftAssertions();

    public LoginTest() throws IOException {
    }


    @DisplayName("loginAsAdmin")
    @ParameterizedTest
    @MethodSource("loginData")
    @Story("User tries to login the system with valid username and valid password.")
    @Description("Valid Login Test with valid Username and valid Password.")
    @ExtendWith(TestResultLoggerExtension.class)
    @Step("Test the login page")
    @Tag("regression")
    void loginAsAdmin(ArrayList<String> parameters) throws InterruptedException, IOException {
        logger.info("Starting Test Login Test");

        HomePage hp = new HomePage();
        hp.goToLogin();
        super.doLogin(parameters.get(0),parameters.get(1));



    /*    HashMap<String, String> login = util.getORInfo("HomePage", "-login");
        HashMap<String, String> userTextBox = util.getORInfo("LoginPage", "-login_name");
        HashMap<String, String> userPassword = util.getORInfo("LoginPage", "-login_password");
        HashMap<String, String> loginButton = util.getORInfo("LoginPage", "-login_button");
        HashMap<String, String> user_name = util.getORInfo("AfterLoginPage", "-user_name");
        String user = parameters.get(0);
        String password = parameters.get(1);
        WebElement weLogin = findByElement(login.get("locator"), login.get("value"));
        Assertions.assertTrue(weLogin.isDisplayed());
        weLogin.click();
        WebElement weUserTextBox = findByElement(userTextBox.get("locator"), userTextBox.get("value"));
        WebElement weUserPassword = findByElement(userPassword.get("locator"), userPassword.get("value"));
        WebElement weloginButton = findByElement(loginButton.get("locator"), loginButton.get("value"));


        Assertions.assertTrue(weUserTextBox.isDisplayed());
        Assertions.assertTrue(weUserPassword.isDisplayed());
        weUserTextBox.sendKeys(user);
        weUserPassword.sendKeys(password);
        Assertions.assertTrue(weloginButton.isDisplayed());
        weloginButton.click();

        WebElement weUserName = findByElement(user_name.get("locator"), user_name.get("value"));
        softly.assertThat(weUserName.getText()).contains(user);
        softly.assertAll();
        System.out.println(weUserName.getText());
   //     Assertions.assertTrue(weUserName.getText().contains(validation));

*/
    }

    private static Stream<Arguments> loginData() throws IOException {
        int index = 0;
        UtilFastExcel fe = new UtilFastExcel();
        List<ArrayList<String>> allRows = fe.readAllRows(index);
        return Stream.of(Arrays.stream(allRows.stream().toArray()).toArray()).map(Arguments::of);
    }

}
