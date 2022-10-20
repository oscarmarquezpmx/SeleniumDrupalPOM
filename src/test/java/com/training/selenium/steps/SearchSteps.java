package com.training.selenium.steps;

import com.training.selenium.steps.locators.LoginLocators;
import com.training.selenium.steps.locators.SearchLocators;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import com.training.selenium.steps.HomePageSteps;
import java.io.IOException;

import static com.training.selenium.base.Page.*;

public class SearchSteps {
    HomePageSteps home;
    SearchLocators searchLoc;

    @Given("Open Chrome and launch the application and search")
    public void startTheTest() throws InterruptedException, IOException {
        home = new HomePageSteps();
        this.searchLoc = new SearchLocators();
        PageFactory.initElements(driver,this.searchLoc);
    }
    @When("^I enter a search value \"([^\"]*)\"$")
    public void doSearch(String searchParameter) throws InterruptedException {
        enterText(searchLoc.weSearchTextBox,searchParameter);
        click(searchLoc.weSearchButton);
    }
    @After
    public void tearDown() throws InterruptedException {
        try {
            driver.quit();
            driver = null;
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
