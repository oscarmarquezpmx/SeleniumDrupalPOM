package com.training.selenium.steps.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchLocators {
    @FindBy(css = ".form-search")
    public WebElement weSearchTextBox;

    @FindBy(xpath = "//*[@id=\"edit-submit\"]")
    public WebElement weSearchButton;
}
