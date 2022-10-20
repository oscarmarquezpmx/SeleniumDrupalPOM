package com.training.selenium.base;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import com.training.selenium.utilities.Utilities;
import io.cucumber.java.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Duration;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@Execution(ExecutionMode.CONCURRENT)
public class Page {

    public static WebDriver driver;
    private static final  Logger logger = LoggerFactory.getLogger(Page.class);

    protected final Utilities util = new Utilities();


    @BeforeEach
    @Before
    public void setup() {


        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        System.out.println(ConfigurationWatchListUtil.getConfigurationWatchList(context).getCopyOfFileWatchList().get(0));

        String os = System.getProperty("os.name");


        logger.info("Starting Setup  {}", Page.class.getSimpleName());


        //ChromeDriver driver;
        if (Constants.browser.equals("chrome")) {
            if(os.toLowerCase().contains("linux"))
                System.setProperty("webdriver.chrome.driver", "./Webdrivers/chromedriver");
            if(os.toLowerCase().contains("windows"))
                System.setProperty("webdriver.chrome.driver", "./Webdrivers/chromedriver.exe");
            driver = new ChromeDriver();
        }

        if (Constants.browser.equals("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
           firefoxOptions.setProfile(new FirefoxProfile());
            firefoxOptions.setLogLevel(FirefoxDriverLogLevel.FATAL);
            firefoxOptions.setAcceptInsecureCerts(true);
     //   firefoxOptions.setLogLevel(FirefoxDriverLogLevel.DEBUG);
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
            profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");


            firefoxOptions.setProfile(profile);


            if(os.toLowerCase().contains("linux"))
            {
                //firefoxOptions.setBinary("/home/oscar/Descargas/firefox/firefox");
                System.setProperty("webdriver.gecko.driver", "./Webdrivers/geckodriver");
            }
            if(os.toLowerCase().contains("windows"))
            {
                firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                System.setProperty("webdriver.gecko.driver", "./Webdrivers/geckodriver.exe");
            }
            this.driver = new FirefoxDriver(firefoxOptions);
        }
        this.driver.get(Constants.testSiteUrl);
        this.driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
    public static void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        logger.info("Closing driver");
        //driver.close();
        try {
            driver.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        //driver = null;
    }
}

