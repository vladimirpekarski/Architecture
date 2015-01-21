package github;

import core.TestBase;
import helpers.CustomListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.PageObject;

import java.io.File;
import java.io.IOException;

import static helpers.Actions.takeScreenshot;
import static helpers.DataProviders.provideUsers;

@Listeners(CustomListener.class)
public class GitHubLoginTest extends TestBase {
    private PageObject pageObject;
    private static Object[][] user;

    @BeforeMethod
    @Override
    public void setup() throws InterruptedException {
        super.setup();
        pageObject = new PageObject();
        user = provideUsers();
    }

    @DataProvider(name = "users")
    public static Object[][] primeNumber() {
        return user;
    }

    @Test(dataProvider = "users")
    public void logginTest(String userName, String userPass) {
        pageObject.login(userName, userPass);
        takeScreenshot("c:/Users/asus/Desktop/screen.png");
        Assert.assertFalse(pageObject.singInLabel.getText().equals("Sign in"));
    }

}

