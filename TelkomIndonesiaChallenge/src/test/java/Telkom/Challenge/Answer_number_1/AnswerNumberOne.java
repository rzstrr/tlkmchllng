package Telkom.Challenge.Answer_number_1;

import Telkom.Challenge.Model.Data.Process.GlobalProcess;
import Telkom.Challenge.Model.Data.Process.MyDBConnection;
import Telkom.Challenge.Model.Data.TestObject.Transaction;
import org.testng.annotations.Test;

public class AnswerNumberOne extends GlobalProcess {

    Transaction trx;

    @Test(priority = 0)
    public void createTestObject(){
        trx = new Transaction();
        trx.setTransaction_id("01023A9AC");
        trx.setAddress_ship("Jalan Gurney");
        trx.setDate_order("21/08/2016");
        trx.setSeller_name("Furhan");
        trx.setDelivery_service("TIKI");

        // object verification
        verifyString(trx.getTransaction_id(),"01023A9AC","Your testing is failed due to invalid data");
    }

    @Test(priority = 1)
    public void checkDatabaseConnection(){
        MyDBConnection mdb = new MyDBConnection();
        mdb.openConnection();
        verifyBoolean(mdb.isConnectionStatement(),true);
    }

    @Test(priority = 2)
    public void verifyCreatedDataToDatabase(){
        MyDBConnection mdb = new MyDBConnection();
        String mdbResult = mdb.selectQueryWithCondition(trx.getTransaction_id());

        // data verification
        verifyString(mdbResult,trx.getDelivery_service(),"Delivery service should follow from database ["+mdbResult+"] instead of UI ["+trx.getDelivery_service()+"]");
    }
}
