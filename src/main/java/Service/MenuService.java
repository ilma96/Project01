package Service;

import DAO.CartRepository;
import DAO.MenuRepository;
import Model.Menu;
import Util.ConnectionsUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MenuService {
    MenuRepository mr;
    CartService cs;
    CartRepository cr;
    Connection c = ConnectionsUtil.getConnection();
    public MenuService(){
        mr = new MenuRepository();
    }
    public MenuService(CartService cs, CartRepository cr) throws SQLException {
        this.cs = cs;
        this.cr = cr;
    }
    public MenuService(MenuRepository mr) throws SQLException {
        this.mr = mr;
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
