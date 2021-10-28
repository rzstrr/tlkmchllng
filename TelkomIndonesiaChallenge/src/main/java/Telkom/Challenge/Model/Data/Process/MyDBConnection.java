package Telkom.Challenge.Model.Data.Process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyDBConnection {

    private Connection conns;
    private Statement stmt;
    private ResultSet rsl;

    GlobalProcess gbp = new GlobalProcess();

    private boolean connectionStatement;

    public void openConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conns = DriverManager.getConnection("jdbc:mysql://localhost:3306/TransactionDB","root","");
            if(conns !=null){
                gbp.writeLog("Connected to database..");
                setConnectionStatement(true);
            }else{
                gbp.writeLog("failed to connect to database..");
                setConnectionStatement(false);
            }
        }catch (Exception e){
            gbp.writeLog(e.getMessage());
        }
    }

    public String selectQueryWithCondition(String condition){
        openConnection();
        String temp="";
        try{
            stmt = conns.createStatement();
            rsl = stmt.executeQuery("select * from transaction_tbl where trx_id ='"+condition+"'");
            while(!rsl.next()){
                System.out.println("Data found : "+rsl.getString(1)+","+rsl.getString(5));
            }
            temp = rsl.getString(5);
            //conns.close();
        }catch (Exception e){
            gbp.writeLog("Failed to select data..");
        }
        return temp;
    }

    public boolean isConnectionStatement() {
        return connectionStatement;
    }

    public void setConnectionStatement(boolean connectionStatement) {
        this.connectionStatement = connectionStatement;
    }
}
