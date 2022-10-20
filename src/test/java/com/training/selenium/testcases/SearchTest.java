package com.training.selenium.testcases;

import com.training.selenium.steps.HomePageSteps;
import com.training.selenium.steps.LoginPageSteps;
import com.training.selenium.steps.SearchSteps;
import com.training.selenium.utilities.UtilFastExcel;

import io.cucumber.java.After;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;
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

import static com.training.selenium.base.Page.driver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SearchTest  {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    SoftAssertions softly = new SoftAssertions();


    @DisplayName("Search without Authentication")
    @ParameterizedTest
    @MethodSource("searchData")
    @Tag("regression")
    void enterSearchTerm(ArrayList<String> parameters) throws InterruptedException, IOException {
        logger.info("Starting Search Test");
        SearchSteps searchPage = new SearchSteps();
        searchPage.startTheTest();

        searchPage.doSearch(parameters.get(0));
        Thread.sleep(1500);
        searchPage.tearDown();

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

    @After
    public void tearDown() throws InterruptedException {
        try {
            driver.quit();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }


}
