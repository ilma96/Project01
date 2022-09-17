package Service;

import DAO.AdminRepository;
import Model.Administrator;
import Util.ConnectionsUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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
        List<Administrator> info = processCredentials(username, password);
        List<Administrator> existingCredential = ar.getCredentials();
        if(info.equals(existingCredential)){
            Administrator infoCheck = new Administrator(username, password);
            ar.addCredentials(infoCheck);
        }
        c.commit();
    }
    public List<Administrator> processCredentials(String u, String p){
        List<Administrator> getInfo = new ArrayList<>();
        Administrator login = new Administrator(u, p);
        getInfo.add(login);
        return getInfo;
    }
}
