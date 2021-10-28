package Telkom.Challenge.Answer_number_3.Positives;

import Telkom.Challenge.Model.FrontEndTestObject.Base.UITestFramework;
import Telkom.Challenge.Model.FrontEndTestObject.PageObject.MidtransHomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ButtonBuyCantBeClickIfThereisPopupTest extends UITestFramework {

    @Test(priority = 0)
    public void goToWeb() throws InterruptedException {
        MidtransHomePage mdp = PageFactory.initElements(webDriver,MidtransHomePage.class);
        if(mdp.getWebTitle().isEmpty()){
            mdp.assertFail("Test step 1 failed!");
        }
        mdp.printLog("Successfully load web on "+mdp.getWebTitle());
    }

    @Test(priority = 1)
    public void clickBuyBtn(){
        MidtransHomePage mdp = PageFactory.initElements(webDriver,MidtransHomePage.class);
        mdp.clickBuyBtn();
        if(!mdp.checkOutCheck()){
            mdp.assertFail("Test step 2 failed - Your Checkoout button is missing!");
        }
    }

    @Test(priority = 2)
    public void checkBtnBuy(){
        MidtransHomePage mdp = PageFactory.initElements(webDriver,MidtransHomePage.class);
        if(!mdp.checkBuyBtnIsClickable()){
            mdp.assertFail("Test step 3 failed - Button Buy should not be clickable");
        }
    }
}
