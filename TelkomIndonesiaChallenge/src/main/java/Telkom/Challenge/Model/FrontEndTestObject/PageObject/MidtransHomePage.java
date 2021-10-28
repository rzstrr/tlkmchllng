package Telkom.Challenge.Model.FrontEndTestObject.PageObject;

import Telkom.Challenge.Model.FrontEndTestObject.Base.PageIdentifier;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MidtransHomePage extends PageIdentifier {

    private String buyNowBtn = "//a[contains(@class,'buy')]";
    private String signUpBtn = "//div[contains(@class,'midtrans')]//a[contains(text(),'SIGN UP')]";
    private String carouselLeft = "//i[contains(@class,'left')]";
    private String getCarouselRight = "//i[contains(@class,'right')]";
    private String btnCheckout = "//div[contains(text(),'CHECKOUT')]";
    private String textArea = "//td[contains(@class,'input')]//textarea";
    private String shippinDetail = "//a[contains(@class,'actionable')]//span[contains(text(),'shipping')]";
    private String shippingValue = "//div[contains(@class,'text-block')]//div[contains(text(),'Target')]";
    private String continueBtn = "//div[contains(@class,'button-main')]//span[contains(text(),'Continue')]";
    private String nametxt = "//div[contains(@class,'cart-section')][2]//tr[1]//td[2]/input";
    private String emailtxt = "//div[contains(@class,'cart-section')][2]//tr[2]//td[2]/input";
    private String phonetxt = "//div[contains(@class,'cart-section')][2]//tr[3]//td[2]/input";
    private String citytxt = "//div[contains(@class,'cart-section')][2]//tr[4]//td[2]/input";
    private String qtyTxt = "//div[contains(@class,'cart-section')][1]//tr//td//input";
    private String warningBox = "//div[contains(@class,'notification-wrapper')]//div[contains(@class,'error')]";


    public MidtransHomePage(WebDriver driverParam){
        super(driverParam);
    }

    public void clickBuyBtn(){
        clickWebElement(buyNowBtn);
    }

    public void clickSignUpBtn(){
        clickWebElement(signUpBtn);
    }

    public void clickLeftCarrouselBtn(){
        clickWebElement(carouselLeft);
    }

    public void clickRightCarrouselBtn(){
        clickWebElement(getCarouselRight);
    }

    public void clickButtonCheckout(){
        clickWebElement(btnCheckout);
    }

    public String getHomepageTitle(){
        return getWebTitle();
    }

    public boolean checkOutCheck(){
        return isElementPresent(btnCheckout);
    }

    public boolean checkBuyBtnIsClickable(){
        return isWebElementEnabled(buyNowBtn);
    }

    public void inputAddress(String text){
        if(isElementPresent(textArea)){
            WebElement texts = getElementByXpath(textArea);
            texts.clear();
            texts.sendKeys(text);
        }
    }

    public void deleteNametxt(){
        if(isElementPresent(nametxt)){
            WebElement texts = getElementByXpath(nametxt);
            texts.sendKeys(Keys.CONTROL + "a");
            texts.sendKeys(Keys.DELETE);
        }
    }

    public void deleteEmailtxt(){
        if(isElementPresent(emailtxt)){
            WebElement texts = getElementByXpath(emailtxt);
            texts.sendKeys(Keys.CONTROL + "a");
            texts.sendKeys(Keys.DELETE);
        }
    }

    public void deletePhonetxt(){
        if(isElementPresent(phonetxt)){
            WebElement texts = getElementByXpath(phonetxt);
            texts.sendKeys(Keys.CONTROL + "a");
            texts.sendKeys(Keys.DELETE);
        }
    }

    public void deleteCitytxt(){
        if(isElementPresent(citytxt)){
            WebElement texts = getElementByXpath(citytxt);
            texts.sendKeys(Keys.CONTROL + "a");
            texts.sendKeys(Keys.DELETE);
        }
    }

    public void clickShippingDetail(){
        moveToIframe();
        clickWebElement(shippinDetail);
    }

    public String elementDetail(String text){
        String temp = shippingValue.replace("Target",text),
        result="";
        if(temp.isEmpty()){
            assertFail("Cant find any xpath for detail address");
        }else{
            WebElement elementDetail = getElementByXpath(temp);
            result = elementDetail.getText();
        }
        return result;
    }

    public void enterInvalidPrice(){
        if(isElementPresent(qtyTxt)){
            WebElement texts = getElementByXpath(qtyTxt);
            for(int a=0; a < 50; a++){
                texts.sendKeys("0");
            }
        }
    }

    public boolean checkWarningBox(){
        return isElementPresent(warningBox);
    }

    public void clickContinueBtn(){
        clickWebElement(continueBtn);
    }
}
