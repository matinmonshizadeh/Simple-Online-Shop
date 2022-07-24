import java.util.ArrayList;

public class ShoppingList {

    ArrayList<Products> productsArraylist;
    int id;
    static int newID;
    static {
        newID = 0;
    }
    ShoppingStatus shoppingStatus;
    int numberOfProducts;


    ShoppingList(ArrayList<Products> productsArraylist){
        this.productsArraylist = productsArraylist;
        this.shoppingStatus = shoppingStatus.Processing;
        this.id = newID++;
    }

    void changeShoppingStatus(ShoppingStatus shoppingStatus) {
        this.shoppingStatus = shoppingStatus;
    }

    public String toString() {
        String data = "";
        double totalPrice = 0;
        int numberOfProducts = 0;
        for(Products  products : productsArraylist) {
            data += products.name + " ";
            totalPrice += products.price;
            numberOfProducts += 1;
        }
        return data + "\nID: " + id + "\nTotal Price: " + totalPrice + "\nNumber of products: "+ numberOfProducts + "\nShopping Status: " + shoppingStatus +"\n";
    }

}
