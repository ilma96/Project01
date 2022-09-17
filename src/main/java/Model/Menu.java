package Model;

import java.text.DecimalFormat;

public class Menu {
    private int productID;
    private String productName;
    private String productCategory;
    private double productPrice;
    private String productUrl;


    public Menu(int productID) {
        this.productID = productID;
    }

    public Menu(int productID, String productName, String productCategory, double productPrice, String productUrl) {
        this.productID = productID;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productUrl = productUrl;
    }

    public Menu(int productID, String productName, double productPrice, String productUrl) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productUrl = productUrl;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }


    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        DecimalFormat prettyFormat = new DecimalFormat("#.00");
        return "Our Food Menu: " + "Product ID: " + productID + ", Product Name: " + productName + ", Category: "
                + productCategory + ", Price: $" + prettyFormat.format(productPrice)
                + "\n";
    }
}
