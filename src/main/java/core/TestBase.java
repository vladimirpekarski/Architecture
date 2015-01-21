package core;

import helpers.WebDriverSingelton;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected static final String BASE_URL = "https://github.com/login";

    @BeforeMethod
    public void setup() throws InterruptedException {
        String browser = System.getProperty("browser", "firefox");
        WebDriverSingelton.initDriver(browser).get(BASE_URL);
    }

    @AfterMethod
    public void teardown() {
        WebDriverSingelton.getDiver().close();
    }
}
