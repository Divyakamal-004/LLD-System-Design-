package Singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PaymentGatewayManager{
    private PaymentGatewayManager(){
        System.out.println("Payment Gateway Manager initialized: ");
    }

    private static PaymentGatewayManager instance;
    private static Lock mtx = new ReentrantLock();

    public static PaymentGatewayManager getInstance(){
        if(instance == null){ //this is the first check without locking
            mtx.lock(); //Acquire the lock before creating the instance
            try{
                if(instance == null){ //Double-checked locking so that it will resolve multithreading
                    instance = new PaymentGatewayManager();
                }
            }finally {
                mtx.unlock(); //release the lock
            }
        }
        return instance;
    }
    public void processPayment(double amount){
        System.out.println("Processing payment of " +amount +"through the payment gateway");
    }
}
public class PaymentGateway {
    public static void main(String[] args) {
        PaymentGatewayManager paymentGateway = PaymentGatewayManager.getInstance();
        paymentGateway.processPayment(100.00);

        //Trying to create new instance and should return the existing instance
        PaymentGatewayManager anotherPayment = PaymentGatewayManager.getInstance();

        if(paymentGateway == anotherPayment){
            System.out.println("Both instances are same. Singleton pattern is working");
        }else {
            System.out.println("singleton pattern is not working");
        }
    }
}
