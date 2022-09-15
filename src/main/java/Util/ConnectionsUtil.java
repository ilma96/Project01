package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionsUtil {
    private static Connection c;
    public static Connection getConnection(){
        if(c == null){
            try{
                String urlSQLServer = "jdbc:sqlserver://localhost:1433;TrustServerCertificate=True";
                String username = "sa";
                String password = "P@SSWORD123";
                c = DriverManager.getConnection(urlSQLServer, username, password);
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return c;
    }
}

