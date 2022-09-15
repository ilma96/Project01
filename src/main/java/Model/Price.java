package Model;

import java.text.DecimalFormat;

public class Price {
    private double foodPrice;

    public Price(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }


    @Override
    public String toString() {
        DecimalFormat prettyFormat = new DecimalFormat("#.00");
        return "The Total Price: " +
                " $" + prettyFormat.format(foodPrice);
    }
}
