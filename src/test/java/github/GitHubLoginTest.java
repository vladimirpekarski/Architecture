package github;

import core.TestBase;
import helpers.CustomListener;
import helpers.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.PageObject;

@Listeners(CustomListener.class)
public class GitHubLoginTest extends TestBase {
    private PageObject pageObject;

    @BeforeMethod
    @Override
    public void setup() throws InterruptedException {
        super.setup();
        pageObject = new PageObject();
    }

    @Test(dataProvider = "users", dataProviderClass = DataProviders.class)
    public void logginTest(String userName, String userPass) {
        pageObject.login(userName, userPass);
        Assert.assertFalse(pageObject.singInLabel.getText().equals("Sign in"));
    }
}

