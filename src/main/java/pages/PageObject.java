package pages;

import core.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.Locators.get;

public class PageObject extends PageBase{
    private final By USER_NAME_FIELD = get("loginPage.userNameField");
    private final By PASSWORD_FIELD = get("loginPage.passwordField");
    private final By LOGIN_BUTTON = get("loginPage.loginButton");
    private final By REMEBER_CHECKBOX_LOCATOR = get("loginPage.rememberCheckbox", "value");
    public final By SING_IN_LABEL = get("loginPage.SignInLabel");
    public WebElement singInLabel;

    public PageObject(WebDriver driver) {
        super(driver);
    }


    public void login(String userName, String pass) {
        driver.findElement(USER_NAME_FIELD).clear();
        driver.findElement(USER_NAME_FIELD).sendKeys(userName);

        driver.findElement(PASSWORD_FIELD).clear();
        driver.findElement(PASSWORD_FIELD).sendKeys(pass);

        driver.findElement(LOGIN_BUTTON).click();
        singInLabel = driver.findElement(SING_IN_LABEL);
    }
}
