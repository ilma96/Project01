package Service;

import DAO.CartRepository;
import Model.Cart;
import Model.Menu;
import Model.Price;
import Util.ConnectionsUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CartService {
    CartRepository cr;

    Connection c = ConnectionsUtil.getConnection();
    public CartService(){
        cr = new CartRepository();
    }

    public List<Menu> getAllFoodItemsFromCart(){
            return cr.constructTheCart();
    }
    public List<Price> getTotalPrice(){
        return cr.getTotalPrice();
    }
    public void addItems(int itemID) throws SQLException {
            Cart newItem = new Cart(itemID);
            cr.addItems(newItem);
            c.commit();
    }
    public void removeItems(int cartID) throws SQLException {
            Cart removeItem = new Cart(cartID);
            cr.removeItems(removeItem);
            c.commit();
    }
}

