import DAO.CartRepository;
import DAO.MenuRepository;
import Model.Cart;
import Model.Menu;
import Service.CartService;
import Service.MenuService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.sql.SQLException;
import static org.mockito.Mockito.never;
public class FoodManiaTest {

        @Test
        public void addFoodWhenFoodExistsDoNotAdd() throws SQLException {
            CartService cs;
            CartRepository cr;
            cs = Mockito.mock(CartService.class);
            cr = Mockito.mock(CartRepository.class);
            Cart c =new Cart(1);
            MenuService ms = new MenuService(cs, cr);
            Mockito.verify(cr, never()).addItems(c);
        }
        @Test
         public void removeFoodWhenFoodExistsDoNotRemove() throws SQLException {
            CartService cs;
            CartRepository cr;
            cs = Mockito.mock(CartService.class);
            cr = Mockito.mock(CartRepository.class);
            Cart c =new Cart(2);
            MenuService ms = new MenuService(cs, cr);
            Mockito.verify(cr, never()).removeItems(c);
        }

       @Test
       public void updateFoodWhenFoodExistsDoNotUpdate() throws SQLException {
           MenuRepository mr;;
           mr = Mockito.mock(MenuRepository.class);
           Menu m =new Menu(2);
           MenuService ms = new MenuService(mr);
           Mockito.verify(mr, never()).updateMenu(m);
       }
       /*
        Set up a fake CartRepository and a fake CartService or a fake MenuRepository:
        CartService/MenuService SHOULD not attempt to add/remove/update the item.
        Let mockito verify that adding/removing/updating the item was never attempted.
         */
    }

