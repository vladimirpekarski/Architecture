package github;
import core.TestBase;
import helpers.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PageObject;
import static helpers.DataProviders.provideUsers;

public class GitHubLoginTest extends TestBase {
    private PageObject pageObject;
    private static Object[][] user;

    @BeforeMethod
    @Override
    public void setup() throws InterruptedException {
        super.setup();
        pageObject = new PageObject(driver);
        user = provideUsers();
    }

    @DataProvider(name = "users")
    public static Object[][] primeNumber() {
        return user;
    }

    @Test(dataProvider = "users")
    public void logginTest(String userName, String userPass) {
        pageObject.login(userName, userPass);
        Assert.assertFalse(pageObject.singInLabel.getText().equals("Sign in"));
    }
}
