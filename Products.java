public class Products {

    String name;
    double price;

    Products(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "name: " + name + " price: " + price;

    }

}
