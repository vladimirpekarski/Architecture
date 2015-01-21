package pages;

import core.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static helpers.Locators.get;
import static helpers.WebDriverSingelton.getDiver;


public class PageObject extends PageBase{
    private final By USER_NAME_FIELD = get("loginPage.userNameField");
    private final By PASSWORD_FIELD = get("loginPage.passwordField");
    private final By LOGIN_BUTTON = get("loginPage.loginButton");
    private final By REMEBER_CHECKBOX_LOCATOR = get("loginPage.rememberCheckbox", "value");
    public final By SING_IN_LABEL = get("loginPage.SignInLabel");
    public WebElement singInLabel;



    public void login(String userName, String pass) {
        getDiver().findElement(USER_NAME_FIELD).clear();
        getDiver().findElement(USER_NAME_FIELD).sendKeys(userName);

        getDiver().findElement(PASSWORD_FIELD).clear();
        getDiver().findElement(PASSWORD_FIELD).sendKeys(pass);

        getDiver().findElement(LOGIN_BUTTON).click();
        singInLabel = getDiver().findElement(SING_IN_LABEL);
    }
}
