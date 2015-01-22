package helpers;

import org.testng.ITestResult;
import org.testng.reporters.ExitCodeListener;

import java.util.Date;

import static helpers.Actions.takeScreenshot;

public class CustomListener extends ExitCodeListener {
    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);
        System.out.println(result.getMethod().getTestClass().getName() + " - " +
                result.getMethod().getMethodName() + " started at " +
                new Date());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestStart(result);
        takeScreenshot("c:/Users/asus/Desktop/screen.png");
        System.out.println(result.getMethod().getTestClass().getName() + " - " +
                result.getMethod().getMethodName() + " failed at " +
                new Date());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        super.onTestSuccess(result);
        System.out.println(result.getMethod().getTestClass().getName() + " - " +
                result.getMethod().getMethodName() + " passed at " +
                new Date());
    }
}
