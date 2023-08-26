package com.training.selenium.base;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import com.training.selenium.utilities.Utilities;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@Execution(ExecutionMode.CONCURRENT)
public class Page {

    public static ChromeDriver driver;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    protected final Utilities util = new Utilities();

    @BeforeEach
    public void setup() throws IOException {

        try {
            util.readORFile();
        } catch (IOException e) {

        }
        // set up new properties object
        // from file "myProperties.txt"
        FileInputStream propFile = new FileInputStream( System.getProperty("user.dir") + "/gradle.properties");
        Properties p = new Properties(System.getProperties());
        p.load(propFile);
        System.setProperties(p);
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("systemProp.browser"));
        System.out.println(System.getProperty("systemProp.serverName"));
        System.out.println(System.getProperty("systemProp.serverPort"));
        System.out.println(System.getProperty("systemProp.driverDefaultWait"));
        System.out.println(System.getProperty("systemProp.driverDefaultWait"));
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        System.out.println(ConfigurationWatchListUtil.getConfigurationWatchList(context).getCopyOfFileWatchList().get(0));

        String browser = System.getProperty("systemProp.browser").replace("'", "");
        String serverName = System.getProperty("systemProp.serverName").replace("'", "");
        String serverPort = System.getProperty("systemProp.serverPort").replace("'", "");
        String driversPath = System.getProperty("systemProp.driversPath").replace("'", "");
        Long driverDefaultWait = Long.parseLong(System.getProperty("systemProp.driverDefaultWait").replace("'", ""));


        //System.out.println("starting logs");
        logger.info("Starting Setup  {}", Page.class.getSimpleName());

        //ChromeDriver driver;
        if (browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            System.setProperty("webdriver.chrome.driver", driversPath + "chromedriver");
            driver = new ChromeDriver(options);
        }
        driver.get(serverName + ":" + serverPort);
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


    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        logger.info("Closing driver");
        driver.close();
        driver.quit();
    }
}

