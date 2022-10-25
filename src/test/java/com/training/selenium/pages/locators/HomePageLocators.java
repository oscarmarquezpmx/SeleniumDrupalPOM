package com.training.selenium.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageLocators {
    @FindBy(how=How.CSS,using = ".menu-main__item > .is-active")
    public WebElement weHomeLink;

    @FindBy(how=How.CSS,using =  ".menu-main__item:nth-child(2) > .menu-main__link")
    public WebElement weArticlesLink;

    @FindBy(how=How.CSS,using =  ".menu-main__item:nth-child(3) > .menu-main__link")
    public WebElement weRecipesLink;

    @FindBy(how=How.CSS,using =  ".menu-account__link")
    public WebElement weLoginLink;

    @FindBy(how=How.CSS,using =  ".form-search")
    public WebElement weSearchTextBox;

    @FindBy(how=How.XPATH,using =  "//*[@id=\"edit-submit\"]")
    public WebElement weSearchButton;




}
