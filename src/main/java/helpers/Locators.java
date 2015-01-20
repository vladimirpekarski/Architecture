package helpers;



import org.openqa.selenium.By;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Locators {
    public static final Properties LOCATORS;

    private enum LocatorType {
        css, id, name, Xpath, tag, linktext
    }

    static {
        LOCATORS = new Properties();
        InputStream in = Locators.class.getResourceAsStream("/Locators.properties");

        try {
            LOCATORS.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static By get(String elementName) {
        String locators = LOCATORS.getProperty(elementName);
        return getLocator(locators);
    }

    public static By get(String elementName, String value) {
        String locators = LOCATORS.getProperty(elementName);
        return getLocator(String.format(locators, value));
    }

    public static By getLocator(String elemntName) {
        String [] locatorItems = elemntName.split("=", 2);
        LocatorType locatorType = LocatorType.valueOf(locatorItems[0]);

        switch (locatorType) {
            case css: {
                return By.cssSelector(locatorItems[1]);
            }

            case id: {
                return By.id(locatorItems[1]);
            }

            case name: {
                return By.name(locatorItems[1]);
            }

            case Xpath: {
                return By.xpath(locatorItems[1]);
            }

            case tag: {
                return By.tagName(locatorItems[1]);
            }

            case linktext: {
                return By.linkText(locatorItems[1]);
            }

            default: {
                throw new IllegalArgumentException("Type " + locatorItems[0] + "is " +
                        "not supported");
            }
        }
    }
//
//    public static By get(String elemntName, String value) {
//        String [] locatorItem = LOCATORS.getProperty(elemntName).split("=", 2);
//        LocatorType locatorType = LocatorType.valueOf(locatorItem[0]);
//
//        switch (locatorType) {
//            case css: {
//                return By.cssSelector(String.format(locatorItem[1], value));
//            }
//
//            case id: {
//                return By.id(String.format(locatorItem[1], value));
//            }
//
//            case name: {
//                return By.name(String.format(locatorItem[1], value));
//            }
//
//            case Xpath: {
//                return By.xpath(String.format(locatorItem[1], value));
//            }
//
//            case tag: {
//                return By.tagName(String.format(locatorItem[1], value));
//            }
//
//            case linktext: {
//                return By.linkText(String.format(locatorItem[1], value));
//            }
//
//            default: {
//                throw new IllegalArgumentException("Type " + locatorItem[0] + "is " +
//                        "not supported");
//            }
//        }
//    }
}
