package Service;

import DAO.MenuRepository;
import Model.Menu;

import java.util.List;

public class MenuService {
    MenuRepository mr;
    public MenuService(){
        mr = new MenuRepository();
    }

    public List<Menu> getAllFoodItems(){
        return mr.getAllFoodItems();
    }

    public Menu updateAProduct(int id){
        Menu updatedRow = new Menu(id);
        return mr.updateMenu(updatedRow);
    }
}
