package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class con1 {
    Statement statement;
    public con1(){
        Connection connection;
        try{
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root","Nshetty@6621");
            statement=connection.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
