package helpers;
import static helpers.Creds.getUser;

public class DataProviders {
    public static Object[][] provideUsers() {
        Object users[][] = {{"vladimir"}, {"pekarski"}};

        return users;
    }
}
