package Telkom.Challenge.Model.FrontEndTestObject.Base;

import org.openqa.selenium.WebDriver;

public class BrowserLauncher extends BrowserDefinition {

    String webProtocol, webUrl;

    public String goToDefaultUrl(){
        String validUrl="";
        webProtocol = reader.getProperties("driver.protocol");
        webUrl = reader.getProperties("driver.url");

        if(webProtocol.isEmpty() && webUrl.isEmpty()){
            printLog("Empty Variables are ["+preferredDriver+","+driverSource+"]");
        }else{
            validUrl = webProtocol+"://"+webUrl;
            printLog("Has been successfully retireve url ["+validUrl+"]");
        }
        return validUrl;
    }

    public WebDriver enforceMyBrowsers(){
        WebDriver drivers = getWebDriverFromGeneric("Chrome");
        return drivers;
    }
}
