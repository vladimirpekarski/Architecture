package helpers;
import org.testng.annotations.DataProvider;

import static helpers.Creds.getUser;

public class DataProviders {
    private static Object[][] provideUsers() {
        Object users[][] = {
                getUser("realcreds"),
                getUser("administrator"),
                getUser("simpleuser"),
                getUser("someotherrole")
        };

        return users;
    }

    @DataProvider(name = "users")
    public static Object[][] primeNumber() {
        return provideUsers();
    }
}
