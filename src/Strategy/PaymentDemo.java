package Strategy;

// Payment strategy interface
interface PaymentStrategy {
    void processPayment(double amount);
}

// Concrete payment strategy classes
class CreditCardPayment implements PaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of amount: " + amount);
    }
}

class PayPalPayment implements PaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of amount: " + amount);
    }
}

class CryptoCurrencyPayment implements PaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Processing cryptocurrency payment of amount: " + amount);
    }
}

// Payment processor (Context)
class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void processPayment(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.processPayment(amount);
        } else {
            System.out.println("Payment strategy not set");
        }
    }
}

// Demo
public class PaymentDemo {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        processor.setPaymentStrategy(new CreditCardPayment());
        processor.processPayment(1000.0);

        processor.setPaymentStrategy(new PayPalPayment());
        processor.processPayment(500.5);

        processor.setPaymentStrategy(new CryptoCurrencyPayment());
        processor.processPayment(250.75);
    }
}

