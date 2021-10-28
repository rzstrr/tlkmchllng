package Telkom.Challenge.Answer_number_2;

import Telkom.Challenge.Model.Data.Process.GlobalProcess;
import Telkom.Challenge.Model.Data.TestObject.Cart;
import Telkom.Challenge.Model.Data.TestObject.DetailProduct;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;

import java.util.Vector;

public class AnswerNumberTwos extends GlobalProcess {

    Cart ct;
    Gson g, builder;
    Vector<DetailProduct> vd = new Vector<>();

    String form="";
    int totalPrice=0, temp=0;

    @Test(priority = 0)
    public void setDefaultData(){

        ct = new Cart();
        ct.setName("sidik hadiwijaya");
        ct.setOrderNumber(76542019);
        ct.setCourier("JNE");
        vd.add(0,new DetailProduct("laptop asus",12000000));
        vd.add(1,new DetailProduct("laptop acer",10000000));
        vd.add(2,new DetailProduct("Macbook Pro",30000000));

        // count real price
        for(int a=0; a<vd.size(); a++){
            totalPrice = totalPrice+vd.get(a).getPrice();
        }

        ct.setTotal(20000000);
        ct.setProduct(vd);
        ct.setCode(200);
        ct.setSuccess("success");
    }

    @Test(priority = 1)
    public void formAJSONAndVerifyJSONObject(){
        g = new Gson();
        form = g.toJson(ct);

        if(form.isEmpty() && !form.contains("total")) {
            assertFail("Unfortunately the test is failed due to JSON is unable to have proper format!");
        }
    }

    @Test(priority = 2)
    public void comparePriceToJSON(){
        builder = new GsonBuilder().create();
        ct = builder.fromJson(form,Cart.class);
        temp = ct.getTotal();

        // assertion for wrong total output (a)
        if(temp==0){
            assertFail("Your cart TOTAL value couldnt be Zero");
        }else{
            verifyIntegerVal(temp,totalPrice);
        }
    }

    @Test(priority = 3)
    public void compareDataType(){
        temp = ct.getOrderNumber();

        // assertion for data type (b)
        if(temp==0){
            assertFail("Your cart ORDER NUMBER value couldnt be Zero");
        }else{
            verifyIsNumeric(temp);
        }
    }
}
