package Model;



public class Cart {
    private int itemID;

    public Cart(){

    }
    public Cart(int itemID){
        this.itemID = itemID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

}
