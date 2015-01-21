package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingelton {
    private static WebDriver driver;

    private WebDriverSingelton() {};

    public static WebDriver getDiver() {
        if (driver != null) {
            return driver;
        } else {
            return new FirefoxDriver();
        }
    }

    public static WebDriver initDriver(String browser) {
        switch (browser) {
            case "firefox": {
                driver = new FirefoxDriver();
                break;
            }

            case "chrome": {
                driver = new ChromeDriver();
                break;
            }

            case "ie": {
                driver = new InternetExplorerDriver();
                break;
            }

            case "htmlunit": {
                driver = new HtmlUnitDriver();
            }

            default: {
                driver = new FirefoxDriver();
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(4, TimeUnit.SECONDS);

        return driver;
    }
}
