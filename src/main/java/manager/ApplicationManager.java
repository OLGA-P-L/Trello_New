package manager;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;
import manager.WDListener;

public class ApplicationManager {
    @Getter
    private WebDriver driver;
    private ChromeOptions chromeOptions;

    public Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    @BeforeMethod
    public void setUp(){
        chromeOptions = new ChromeOptions().addArguments("--lang=en");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverListener webDriverListener = new WDListener();
        driver = new EventFiringDecorator<>(webDriverListener).decorate(driver);
    }

   /* @AfterMethod
    public void tearDown(){
        if (driver != null)
            driver.quit();
    }*/
}
