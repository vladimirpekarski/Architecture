package github;
import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PageObject;

public class GitHubLoginTest extends TestBase {
    private PageObject pageObject;

    @BeforeMethod
    @Override
    public void setup() throws InterruptedException {
        super.setup();
        pageObject = new PageObject(driver);
    }

    @Test
    public void logginTest() {
        pageObject.login("vladimir.pekarski@gmail.com", "cannabis56783456");
        Assert.assertFalse(pageObject.singInLabel.getText().equals("Sign in"));
    }
}
