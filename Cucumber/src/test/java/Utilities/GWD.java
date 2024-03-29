package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {

    public static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver == null){

            Logger.getLogger("").setLevel(Level.SEVERE);
            System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

      //  WebDriverManager.firefoxdriver().setup();
      //  driver = new FirefoxDriver();

        return driver;
    }

    public static void quitDriver() throws InterruptedException {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver != null ) {
            driver.quit();
            driver = null;
        }
    }
}
