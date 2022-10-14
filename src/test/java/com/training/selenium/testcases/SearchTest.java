package com.training.selenium.testcases;

import com.training.selenium.base.Page;
import com.training.selenium.listeners.TestResultLoggerExtension;
import com.training.selenium.steps.HomePageSteps;
import com.training.selenium.utilities.UtilFastExcel;
import io.qameta.allure.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
    void enterSearchTerm(ArrayList<String> parameters) throws InterruptedException, IOException {
        logger.info("Starting Search Test");
        //Page.setup();
        HomePageSteps home = new HomePageSteps();

        home.doSearch(parameters.get(0));
        Thread.sleep(1500);
        //Page.tearDown();

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
