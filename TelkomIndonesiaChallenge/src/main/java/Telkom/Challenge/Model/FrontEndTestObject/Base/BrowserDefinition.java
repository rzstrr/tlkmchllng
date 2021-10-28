package Telkom.Challenge.Model.FrontEndTestObject.Base;

import Telkom.Challenge.Model.Data.Process.GlobalProcess;
import Telkom.Challenge.Model.Data.Process.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserDefinition extends GlobalProcess {

    protected WebDriver driver;
    protected WebElement element;
    protected PropertiesReader reader = new PropertiesReader();
    String preferredDriver,driverSource,driverBehaviour;

    public WebDriver getWebDriverFromGeneric(String driverOption) {

        preferredDriver = reader.getProperties("driver.name");
        driverSource = reader.getProperties("driver.resource");
        driverBehaviour = reader.getProperties("driver.behavior");

        if(driverOption.equalsIgnoreCase("Chrome")){
            if(preferredDriver.isEmpty() && driverSource.isEmpty()){
                printLog("failure while retrieving driver preferred driver or driver source for Chrome driver");
            }else{
                System.setProperty(preferredDriver,driverSource);
                System.setProperty("webdriver.chrome.verboseLogging","true");
                ChromeOptions options = new ChromeOptions();
                if(driverBehaviour.isEmpty()){
                    printLog("failure while retrieving driver behavior for Chrome driver");
                }
                options.addArguments(driverBehaviour);
                driver = new ChromeDriver(options);
            }
        }else if(driverOption.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        }else if(driverOption.equalsIgnoreCase("Explorer")){
            driver = new InternetExplorerDriver();
        }
        return driver;
    }
}
