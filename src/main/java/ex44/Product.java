package ex44;

public class Product {

    private String name;

    private double price;

    private int quantity;

    public Product(String name, double price, int quantity){

        this.name = name;

        this.price = price;

        this.quantity = quantity;

    }

    public String get_Name(){

        return name;

    }

    public double get_Price(){

        return price;

    }

    public int get_Quantity(){

        return quantity;

    }

}
