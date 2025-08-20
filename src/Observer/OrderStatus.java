package Observer;

import java.util.ArrayList;
import java.util.List;

interface observer{
    void update(Order order);
}

class customer implements observer{
    private String name;

    public customer(String name){
        this.name = name;
    }
    public void update(Order order){
        System.out.println("Hello " +name + "! order #" + order.getId() +"is now" + order.getStatus() +".");
    }
}

class Restaurants implements observer{
    private String restaurantName;

    public Restaurants(String name){
        this.restaurantName = name;
    }
    public void update(Order order){
        System.out.println("Restaurant" +restaurantName +": order #" +order.getId() +"is now" +order.getStatus() + ".");
    }
}

class DeliveryDriver implements observer{
    private String driverName;
    public DeliveryDriver(String name){
        this.driverName = name;
    }
    public void update(Order order){
        System.out.println("Driver" + driverName + ": order #" +order.getId() + "is now" + order.getStatus());
    }
}

class CallCenter implements observer{
    public void update(Order order){
        System.out.println("Call center :order #" + order.getId() +"is now" +order.getStatus());
    }
}

class Order{
    private int id;
    private String status;
    private List<observer> observers = new ArrayList<>();

    public Order(int id){
        this.id =  id;
        this.status = "Order placed";
    }
    public int getId(){
        return id;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String newStatus){
        status = newStatus;
        notifyObservers();
    }
    public void attach(observer observer){
        observers.add(observer);
    }
    public void detach(observer observer){
        observers.remove(observer);
    }
    public void notifyObservers(){
        for(observer observer : observers){
            observer.update(this);
        }
    }
}

public class OrderStatus {
    public static void main(String[] args) {
        Order order1 = new Order(123);

        customer customer1 = new customer("Customer 1");
        Restaurants restaurant1 = new Restaurants("Restro 1");
        DeliveryDriver driver1 = new DeliveryDriver("driver 1");
        CallCenter callCenter1 = new CallCenter();

        order1.attach(customer1);
        order1.attach(restaurant1);
        order1.attach(driver1);
        order1.attach(callCenter1);

        order1.setStatus("Out for delivery");
        order1.detach(callCenter1);
        order1.attach (customer1);

        order1.setStatus("Delivered");
    }
}
