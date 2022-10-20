package com.training.selenium.steps.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {
    @FindBy(css = ".menu-main__item > .is-active")
    public WebElement weHomeLink;

    @FindBy(css = ".menu-main__item:nth-child(2) > .menu-main__link")
    public WebElement weArticlesLink;

    @FindBy(css = ".menu-main__item:nth-child(3) > .menu-main__link")
    public WebElement weRecipesLink;

    @FindBy(css = ".menu-account__link")
    public WebElement weLoginLink;




}
