package models;

public class Product {
    String id;
    String name;
    double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int sales() {


        return 0;
    }
    public double getPrice() {
        return this.price;
    }
}
