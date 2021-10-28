package Telkom.Challenge.Answer_number_3.Negatives;

import Telkom.Challenge.Model.FrontEndTestObject.Base.UITestFramework;
import Telkom.Challenge.Model.FrontEndTestObject.PageObject.MidtransHomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CantProcessToCheckoutIfAmountInvalidTest extends UITestFramework {

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
    public void enterInvalidPrice(){
        MidtransHomePage mdp = PageFactory.initElements(webDriver,MidtransHomePage.class);
        mdp.enterInvalidPrice();
        mdp.clickButtonCheckout();
    }

    @Test(priority = 3)
    public void verifyWarningBox(){
        MidtransHomePage mdp = PageFactory.initElements(webDriver,MidtransHomePage.class);
        mdp.verifyBoolean(mdp.checkWarningBox(),true);
    }
}
