package com.training.selenium.base;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import com.training.selenium.utilities.Utilities;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Duration;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@Execution(ExecutionMode.CONCURRENT)
public class Page {

    public static ChromeDriver driver;
    private static final  Logger logger = LoggerFactory.getLogger(Page.class);

    protected final Utilities util = new Utilities();

 //   @BeforeEach
    static public void setup() {

   //     try {
   //         util.readORFile();
  //      } catch (IOException e) {

   //     }
        System.out.println(System.getProperty("browser"));
        System.out.println(System.getProperty("serverName"));
        System.out.println(System.getProperty("serverPort"));
        System.out.println(System.getProperty("driverDefaultWait"));
        System.out.println(System.getProperty("driverDefaultWait"));
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        System.out.println(ConfigurationWatchListUtil.getConfigurationWatchList(context).getCopyOfFileWatchList().get(0));

        String browser = System.getProperty("browser").replace("'", "");
        String serverName = System.getProperty("serverName").replace("'", "");
        String serverPort = System.getProperty("serverPort").replace("'", "");
        String driversPath = System.getProperty("driversPath").replace("'", "");
        Long driverDefaultWait = Long.parseLong(System.getProperty("driverDefaultWait").replace("'", ""));


        //System.out.println("starting logs");
        logger.info("Starting Setup  {}", Page.class.getSimpleName());

        //ChromeDriver driver;
        if (Constants.browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", driversPath + "chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.get(Constants.testSiteUrl);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(driverDefaultWait));
    }

    protected WebElement findByElement(String locator, String value) throws InterruptedException {
        WebElement we = null;
        if (locator.contains("id")) {
            try {
                we = driver.findElement(By.id(value));
            } catch (NoSuchElementException e) {
                //return false;
            }
        }

        if (locator.contains("linktext")) {
            try {
                we = driver.findElement(By.linkText(value));
            } catch (NoSuchElementException e) {
                //return false;
            }
        }

        if (locator.contains("name")) {
            try {
                we = driver.findElement(By.name(value));
            } catch (NoSuchElementException e) {
                //return false;
            }
        }

        if (locator.contains("css")) {
            try {
                we = driver.findElement(By.cssSelector(value));
            } catch (NoSuchElementException e) {
                //return false;
            }
        }
        if (locator.contains("xpath")) {
            try {
                we = driver.findElement(By.xpath(value));
            } catch (NoSuchElementException e) {
                //return false;
            }
        }

        //highlight the element
        String currentColor = we.getCssValue("background-color");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.background='yellow'", we);
        Thread.sleep(600);
        jsExecutor.executeScript("arguments[0].style.background= \"" + currentColor + "\"", we);

        return we;
    }


 //   @AfterEach
    static public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        logger.info("Closing driver");
        driver.close();
        driver.quit();
    }
}

