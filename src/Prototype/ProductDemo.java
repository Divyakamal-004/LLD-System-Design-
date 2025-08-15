package Prototype;

abstract class ProductPrototype{
    public abstract ProductPrototype clone();
    public abstract void display();
}

class Product extends ProductPrototype{
    private String name;
    private double price;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }
    public ProductPrototype clone(){
        return new Product(name, price);
    }
    public void display(){
        System.out.println("Product: " +name);
        System.out.println("Price: "+price);
    }
}
public class ProductDemo {
    public static void main(String[] args) {
        ProductPrototype product1 = new Product("Laptop", 112000);
        ProductPrototype product2 = new Product("Smartphone", 15000);

        ProductPrototype newpro1 = product1.clone();
        ProductPrototype newpro2 = product2.clone();

        System.out.println("Original Product");
        product1.display();
        product2.display();

        System.out.println("\nClones Product");
        newpro1.display();
        newpro2.display();
    }
}
