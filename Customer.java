import java.util.ArrayList;

public class Customer {

    String userName;
    String pass;
    ArrayList<ShoppingList> shoppingListHistory;

    Customer(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
        this.shoppingListHistory = new ArrayList<>();

    }
    public String toString() {
        return userName ;
    }

}
