package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connecter {
    public static Connection getConnection(){
        Connection c=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","root");
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return c;
    }
    public boolean printConnectionStatus() {
        boolean b=false;
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            if (c.equals(getConnection())){
                b=true;
            }
        }catch (SQLException sql){
            System.out.println(sql);
        }
        return b;
    }


}
