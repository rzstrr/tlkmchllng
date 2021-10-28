package Telkom.Challenge.Model.Data.Process;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader extends GlobalProcess {

    public String getPropertiesFromCustomSource(String fileName, String value){
        ClassLoader loader =Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        String propertyName="";

        try {
            InputStream inputStream =loader.getResourceAsStream(fileName);
            if(inputStream==null){
                properties.load(new FileInputStream("src/main/resources/application.properties"));
                propertyName = properties.getProperty(value);
                printLog("Force to read properties..");
            }else{
                properties.load(inputStream);
                propertyName = properties.getProperty(value);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        if(propertyName.isEmpty()){
            printLog("Something went wrong while reading properties from source file! Terminate the process..");
            System.exit(0);
        }
        return propertyName;
    }

    public String getProperties(String propertiesName){
        String propertyVal = getPropertiesFromCustomSource("application.properties",propertiesName);
        if(propertyVal.isEmpty()){
            printLog("Terminate the process as your properties is not registered on the file yet..");
            System.exit(0);
        }
        printLog("Properties found!");
        return propertyVal;
    }
}
