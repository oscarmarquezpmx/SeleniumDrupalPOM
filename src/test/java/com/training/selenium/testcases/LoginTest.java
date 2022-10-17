package com.training.selenium.testcases;

import com.training.selenium.listeners.TestResultLoggerExtension;
import com.training.selenium.steps.HomePageSteps;
import com.training.selenium.steps.LoginPageSteps;
import com.training.selenium.utilities.UtilFastExcel;
import io.qameta.allure.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//import static com.training.selenium.steps.LoginPageSteps.driver;


@Epic("Login Tests Epic")
@Feature("Login Features")
//@Execution(ExecutionMode.CONCURRENT)
public class LoginTest{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    SoftAssertions softly = new SoftAssertions();

    WebDriver driver;


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

  //      Page.setup();
   //     HomePageSteps homeSteps = new HomePageSteps();
  //      this.driver = homeSteps.driver;
   //     homeSteps.goToLogin();
        LoginPageSteps loginPage = new LoginPageSteps();
        //LoginPageSteps loginPage = home.goToLogin();
        loginPage.doLogin(parameters.get(0),parameters.get(1));
     //   home.tearDown();

    }

    private static Stream<Arguments> loginData() throws IOException {
        int index = 0;
        UtilFastExcel fe = new UtilFastExcel();
        List<ArrayList<String>> allRows = fe.readAllRows(index);
        return Stream.of(Arrays.stream(allRows.stream().toArray()).toArray()).map(Arguments::of);
    }

}
