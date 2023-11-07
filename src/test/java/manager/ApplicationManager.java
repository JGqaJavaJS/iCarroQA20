package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigProperties;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

  //  WebDriver driver;
  EventFiringWebDriver driver;

    UserHelper userHelper;
    CarHelper carHelper;
    String browser;
    String url = ConfigProperties.getProperty("url");
    public ApplicationManager() {
        browser = System.getProperty("browser", BrowserType.CHROME);
    }

    public void init() {
       // driver = new ChromeDriver();
       // driver = new EventFiringWebDriver(new ChromeDriver());

        if(browser.equals(BrowserType.CHROME)) {
            driver = new EventFiringWebDriver(new ChromeDriver());
            logger.info("created chrome browser");
        }else if (browser.equals(BrowserType.FIREFOX)) {
            driver = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("started tests in firefox driver");
        }

        driver.navigate().to(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.register(new WDListener());
        userHelper = new UserHelper(driver);
        carHelper = new CarHelper(driver);
        logger.info("navigated to the url: " + url);
    }

    public void navigateToMainPage() {
        driver.navigate().to(url);
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }
    public CarHelper getCarHelper() {
        return carHelper;
    }

    public EventFiringWebDriver getDriver() {
        if(driver == null) {
            init();
        }
        return driver;
    }

    public void tearDown() {
        driver.quit();
    }

}
