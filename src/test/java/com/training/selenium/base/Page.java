package com.training.selenium.base;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import com.training.selenium.utilities.Utilities;
import io.cucumber.java.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Duration;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@Execution(ExecutionMode.CONCURRENT)
public class Page {

    public static WebDriver driver = null;
    private static final  Logger logger = LoggerFactory.getLogger(Page.class);

    protected final Utilities util = new Utilities();


    @BeforeEach
    @Before
    public void setup() {

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
/*
        String browser = System.getProperty("browser").replace("'", "");
        String serverName = System.getProperty("serverName").replace("'", "");
        String serverPort = System.getProperty("serverPort").replace("'", "");
        String driversPath = System.getProperty("driversPath").replace("'", ""); */
        Long driverDefaultWait = Long.parseLong(System.getProperty("driverDefaultWait").replace("'", ""));


        //System.out.println("starting logs");
        logger.info("Starting Setup  {}", Page.class.getSimpleName());


        //ChromeDriver driver;
        if (Constants.browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./Webdrivers/chromedriver");
            driver = new ChromeDriver();
        }

        if (Constants.browser.equals("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setProfile(new FirefoxProfile());
            firefoxOptions.setLogLevel(FirefoxDriverLogLevel.FATAL);
            firefoxOptions.setAcceptInsecureCerts(true);
            firefoxOptions.setLogLevel(FirefoxDriverLogLevel.TRACE);
            firefoxOptions.setCapability("browserName", "Firefox");
            firefoxOptions.setCapability("browserVersion", "105.0.3");
   //         firefoxOptions.setHeadless(true);
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("browser.download.folderList", 1);
            profile.setPreference("browser.download.manager.showWhenStarting", false);
            profile.setPreference("browser.download.manager.focusWhenStarting", false);
            profile.setPreference("browser.download.useDownloadDir", true);
            profile.setPreference("browser.helperApps.alwaysAsk.force", false);
            profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
            profile.setPreference("browser.download.manager.closeWhenDone", true);
            profile.setPreference("browser.download.manager.showAlertOnComplete", false);
            profile.setPreference("browser.download.manager.useWindow", false);
            // You will need to find the content-type of your app and set it here.
            profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");


            firefoxOptions.setProfile(profile);
            firefoxOptions.setBinary("/usr/bin/firefox");
            //firefoxOptions.setBinary("/home/oscar/Descargas/firefox/firefox");
            System.setProperty("webdriver.gecko.driver", "./Webdrivers/geckodriver");

            driver = new FirefoxDriver(firefoxOptions);
        }
        driver.get(Constants.testSiteUrl);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(driverDefaultWait));
    }



    public static void highlightElement(WebElement webElement) throws InterruptedException {

        //highlight the element
        String currentColor = webElement.getCssValue("background-color");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.background='yellow'", webElement);
        Thread.sleep(600);
        jsExecutor.executeScript("arguments[0].style.background= \"" + currentColor + "\"", webElement);

    }
    public static void click(WebElement webelement) throws InterruptedException {
        highlightElement(webelement);
        webelement.click();
    }

    public static void enterText(WebElement webelement,String text) throws InterruptedException {
        highlightElement(webelement);
        webelement.sendKeys(text);
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        logger.info("Closing driver");
        driver.close();
        driver.quit();
    }
}

