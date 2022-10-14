package com.training.selenium.steps.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginLocators {
    @FindBy(id = "edit-name")
    public WebElement weUserTextBox;
    @FindBy(id = "edit-pass")
    public WebElement wePasswordTextBox;

    @FindBy(name = "op")
    public WebElement weloginButton;
}
