package DAO;

import Model.Administrator;
import Util.ConnectionsUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminRepository {
    Connection c;
    public AdminRepository(){
        c = ConnectionsUtil.getConnection();
    }
    public List<Administrator> getCredentials(){
       List <Administrator> credentials = new ArrayList<>();
        try{
            Statement menuStatement = c.createStatement();
            ResultSet rs = menuStatement.executeQuery("Select * From Administrator");
            while(rs.next()){
                Administrator displayFood = new Administrator(rs.getString("username"), rs.getString("password"));
                credentials.add(displayFood);
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
        return credentials;
    }
    public void addCredentials(Administrator info){
        try{
            PreparedStatement stmt = c.prepareStatement("insert into Administrator(username, password)"
                    + "values (?,?)");
            stmt.setString(1, info.getUsername());
            stmt.setString(2, info.getPassword());
            stmt.executeUpdate();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
}
