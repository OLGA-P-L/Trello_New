package manager;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    @Getter
    private WebDriver driver;
    private ChromeOptions chromeOptions;

    @BeforeMethod
    public void setUp(){
        chromeOptions = new ChromeOptions().addArguments("--lang=en");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

   /* @AfterMethod
    public void tearDown(){
        if (driver != null)
            driver.quit();
    }*/
}
