package Telkom.Challenge.Model.Data.Process;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

import java.util.logging.Logger;

public class GlobalProcess {

    protected final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void printLog(String msg){
        logger.info(msg);
    }

    public void writeLog(String msgs){
        Logger.getLogger(msgs);
    }

    public void assertFail(String msgs){
        Assert.fail(msgs);
    }

    public void verifyString(String actual, String expected, String msgs){
        Assert.assertEquals(actual,expected,msgs);
    }

    public void verifyBoolean(boolean actual, boolean expected){
        Assert.assertEquals(actual,expected);
    }

    public void verifyIntegerVal(int actual, int expected){
        Assert.assertEquals(actual, expected,"Your integer value to be compare is invalid. Value should be ["+expected+"] instead of ["+actual+"]");
    }

    public void verifyIsNumeric(int target){
        String conversion = Integer.toString(target);
        verifyBoolean(StringUtils.isNumeric(conversion),true);
    }


}
