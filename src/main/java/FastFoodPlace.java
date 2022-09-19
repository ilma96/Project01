import Model.Administrator;
import Model.Cart;
import Service.CartService;
import Service.LoginService;
import Service.MenuService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;


import java.sql.SQLException;


public class FastFoodPlace {
    public static void main(String[] args) throws SQLException {
        MenuService ms = new MenuService();
        CartService cs = new CartService();
        LoginService as = new LoginService();
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);
        app.start(9000);
        app.get("/view_menu/", ctx -> ctx.json(ms.getAllFoodItems()));
        app.put("/administrator_options/{productID}", ctx ->
            ctx.json(ms.updateAProduct(Integer.parseInt(ctx.pathParam("productID"))))
        );
        app.get("administrator_options", ctx -> ctx.json(as.getCredentials()));
        app.post("administrator_options", ctx ->{
            ObjectMapper mapper = new ObjectMapper();
            Administrator info = mapper.readValue(ctx.body(), Administrator.class);
            as.addLogins(info.getUsername(), info.getPassword());
        });

        app.post("advanced_options", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            Cart items = mapper.readValue(ctx.body(),Cart.class);
            cs.addItems(items.getItemID());
        });
        app.delete("advanced_options", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            Cart items = mapper.readValue(ctx.body(),Cart.class);
            cs.removeItems(items.getItemID());
        });
        app.get("/advanced_options/view_my_cart", ctx -> ctx.json(cs.getAllFoodItemsFromCart()));
        app.get("/advanced_options/view_total_price", ctx -> ctx.json(cs.getTotalPrice()));

    }
}
// ./gradlew shadowJar to build the jar file


