package DAO;

import Model.Administrator;
import Util.ConnectionsUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginRepository {
    Connection c;
    public LoginRepository(){
        c = ConnectionsUtil.getConnection();
    }
    public void addLogin(Administrator a){
        try{
            PreparedStatement stmt = c.prepareStatement("insert into Logins(username, password)"
                    + "values (?,?)");
            stmt.setString(1, a.getUsername());
            stmt.setString(2, a.getPassword());
            stmt.executeUpdate();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
    public List<Administrator> viewIfExists(){
        List<Administrator> itemExists = new ArrayList<>();
        try{
            Statement loginStatement = c.createStatement();
            ResultSet rs = loginStatement.executeQuery("Select * From Logins l Where exists (Select * " +
                    "From Administrator a Where a.username = l.username and a.password = l.password)");
            // SQL statement to check if an item added in Cart exists in the Menu or not
            while(rs.next()) {
                Administrator credentials = new Administrator(rs.getString("username"),
                        rs.getString("password"));
                itemExists.add(credentials);
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
        return itemExists;
    }
}
