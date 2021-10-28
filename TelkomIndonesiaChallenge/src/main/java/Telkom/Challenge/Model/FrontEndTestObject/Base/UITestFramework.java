package Telkom.Challenge.Model.FrontEndTestObject.Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UITestFramework {

    private BrowserLauncher launcher = new BrowserLauncher();
    private JavascriptExecutor jsp;
    protected WebDriver webDriver;

    public UITestFramework(){
        this.webDriver = launcher.enforceMyBrowsers();
        jsp = (JavascriptExecutor)this.webDriver;
        webDriver.get(launcher.goToDefaultUrl());
    }

    public void endTests(){
        webDriver.close();
    }

    public void assertBooleanResult(boolean actualResult, boolean expectedResult, String messages){
        Assert.assertEquals(actualResult,expectedResult,messages);
    }

    public void assertStringTestResult(String actualResult, String expectedResult, String messages){
        Assert.assertEquals(actualResult,expectedResult,messages);
    }

    public void terminateTestWithMessages(String msg){
        Assert.fail(msg);
    }

}
