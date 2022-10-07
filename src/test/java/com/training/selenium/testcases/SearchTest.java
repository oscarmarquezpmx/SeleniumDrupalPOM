package com.training.selenium.testcases;

import com.training.selenium.base.Page;
import com.training.selenium.listeners.TestResultLoggerExtension;
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

@Epic("Search Tests Epic")
@Feature("Search Features")
//@Execution(ExecutionMode.CONCURRENT)
public class SearchTest extends Page {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    SoftAssertions softly = new SoftAssertions();


    @DisplayName("Search without Authentication")
    @ParameterizedTest
    @MethodSource("searchData")
    @Story("User tries to search in the search textbox and results are provided")
    @Description("A search term is provided and a list of results are presented")
    @ExtendWith(TestResultLoggerExtension.class)
    @Step("Test the search feature")
    @Tag("regression")
    void enterSearchTerm(ArrayList<String> parameters) throws InterruptedException {
 /*       logger.info("Starting Search Test");

        HashMap<String,String> searchTextbox = util.getORInfo("HomePage","-search");
        HashMap<String,String> searchButton = util.getORInfo("HomePage","-searchButton");

        WebElement weSearchTextbox   = findByElement(searchTextbox.get("locator"),searchTextbox.get("value"));
        Assertions.assertTrue(weSearchTextbox.isDisplayed());
        weSearchTextbox.click();
        WebElement wesearchButton   = findByElement(searchButton.get("locator"),searchButton.get("value"));

        Assertions.assertTrue(wesearchButton.isDisplayed());
        String searchTerm = parameters.get(0);
        weSearchTextbox.sendKeys(searchTerm);
        wesearchButton.click();      */

//        softly.assertThat(weUserName.getText()).contains("fail");
//        softly.assertAll();
 //       System.out.println(weUserName.getText());
 //       Assertions.assertTrue(weUserName.getText().contains(validation));



    }

    private Stream<Arguments> searchData() throws IOException {
        int index = 1;
        UtilFastExcel fe = new UtilFastExcel();
        List<ArrayList<String>> allRows = fe.readAllRows(index);
        return Stream.of(Arrays.stream(allRows.stream().toArray()).toArray()).map(Arguments::of);
    }


}
