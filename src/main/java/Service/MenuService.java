package Service;

import DAO.MenuRepository;
import Model.Menu;
import Util.ConnectionsUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MenuService {
    MenuRepository mr;
    Connection c = ConnectionsUtil.getConnection();
    public MenuService(){
        mr = new MenuRepository();
    }

    public List<Menu> getAllFoodItems(){
        return mr.getAllFoodItems();
    }

    public Menu updateAProduct(int id) throws SQLException {
        Menu updatedRow = new Menu(id);
        c.commit();
        return mr.updateMenu(updatedRow);
    }
}
