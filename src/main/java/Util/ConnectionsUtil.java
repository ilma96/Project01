package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionsUtil {
    private static Connection c;
    public static Connection getConnection(){
        if(c == null){
            try{
                String urlSQLServer = "jdbc:sqlserver://foodmaniaserver.database.windows.net:1433;database=dbfood;user=foodmania@foodmaniaserver;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
                String username = System.getenv("dbusername");
                String password = System.getenv("dbpassword");
                c = DriverManager.getConnection(urlSQLServer, username, password);
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return c;
    }
}

