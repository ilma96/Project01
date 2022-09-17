package Service;

import DAO.LoginRepository;
import Model.Administrator;
import Util.ConnectionsUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LoginService {
    Connection c = ConnectionsUtil.getConnection();
    LoginRepository lr;
    public LoginService(){
        lr = new LoginRepository();
    }
    public List<Administrator> getCredentials(){
        return lr.viewIfExists();
    }
    public void addLogins(String username, String password) throws SQLException {
        Administrator newItem = new Administrator(username, password);
        lr.addLogin(newItem);
        c.commit();
    }
}
