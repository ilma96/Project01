package DAO;

import Model.Cart;
import Model.Menu;
import Model.Price;
import Util.ConnectionsUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    Connection c = ConnectionsUtil.getConnection();

    public void addItems(Cart item) throws SQLException{
        try{
            PreparedStatement stmt = c.prepareStatement("insert into Cart(item_id)"
                    + "values (?)");
            stmt.setInt(1, item.getItemID());
            stmt.executeUpdate();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
    public void removeItems(Cart item) throws SQLException{
        try{
            PreparedStatement stmt = c.prepareStatement("Delete from Cart where item_id = ?");
            stmt.setInt(1, item.getItemID());
            stmt.executeUpdate();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
    public List<Menu> constructTheCart(){
        List<Menu> getItems = new ArrayList<>();
        try{
            Statement cartStatement = c.createStatement();
            ResultSet rs = cartStatement.executeQuery("select Menu.product_id, Menu.product_name, Menu.product_category, Menu.product_price, Menu.url from Menu inner join Cart on Menu.product_id = Cart.item_id");

            while(rs.next()) {
                Menu displayFood = new Menu(rs.getInt("product_id"),
                        rs.getString("product_name"), rs.getString("product_category"), rs.getDouble("product_price"), rs.getString("url"));
                getItems.add(displayFood);
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
        return getItems;
    }

    public List<Price> getTotalPrice(){
        List<Price> totalPrice = new ArrayList<>();
        try{
            Statement cartStatement = c.createStatement();
            ResultSet rs = cartStatement.executeQuery("Select sum(product_price) as product_price " +
                    "from Menu inner join Cart on Menu.product_id = Cart.item_id");
            while(rs.next()){
                Price displayPrice = new Price(rs.getDouble("product_price"));
                totalPrice.add(displayPrice);
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
        return totalPrice;
    }

}


