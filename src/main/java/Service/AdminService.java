package Service;

import DAO.AdminRepository;
import Model.Administrator;
import Util.ConnectionsUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AdminService {
    AdminRepository ar;
    Connection c = ConnectionsUtil.getConnection();
    public AdminService(){
        ar = new AdminRepository();
    }
    public List<Administrator> getCredentials(){
        return ar.getCredentials();
    }
    public void addCredentials(String username, String password) throws SQLException {
        Administrator info = new Administrator(username, password);
        ar.addCredentials(info);
        c.commit();
    }
}
