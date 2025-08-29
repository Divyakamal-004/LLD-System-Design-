package Iterator;

import javax.swing.*;
import java.util.ArrayList;

class Product{
    private String name;
    private double price;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
}

interface Iterator{
    Product first();
    Product next();
    boolean hasNext();
}

class productIterator implements Iterator{
    private ArrayList<Product> products;
    private int current;

    public productIterator(ArrayList<Product> products){
        this.products = products;
        this.current = 0;
    }

    public Product first(){
        if(products.isEmpty()) return null;

        current = 0;
        return products.get(current);
    }

    public Product next(){
        if(hasNext()){
            return products.get(++current);
        }
        return null;
    }

    public boolean hasNext(){
        return current < products.size() - 1;
    }
}

class Inventory{
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public Iterator createIterator(){
        return new productIterator(products);
    }
}
public class AmazonInventory {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop",999.99);
        Product product2 = new Product("Mobile", 599.50);
        Product product3 = new Product("Ipad", 1500);

        Inventory inventory = new Inventory();
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        Iterator iterator = inventory.createIterator();
        Product currentProduct = iterator.first();

        while(currentProduct != null){
            System.out.println("Product: " + currentProduct.getName() +", Price : " + currentProduct.getPrice());
            currentProduct = iterator.next();
        }

    }
}
