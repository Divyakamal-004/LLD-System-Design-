package ChainOfResponsibility;

abstract class OrderHandler{
    protected OrderHandler nextHandler;

    public OrderHandler(OrderHandler nextHandler){
        this.nextHandler = nextHandler;
    }
    public abstract void processOrder(String order);
}

//Concrete handler for order verification
class orderValidationHandler extends OrderHandler{
    public orderValidationHandler(OrderHandler nextHandler){
        super(nextHandler);
    }
    public void processOrder(String order){
        System.out.println("Validation order: " + order);

        //If the order is valid pass it to the next handler
        if(nextHandler != null){
            nextHandler.processOrder(order);
        }
    }
}

//Concrete handler for payment processing
class paymentProcessingHandler extends OrderHandler{
    public paymentProcessingHandler(OrderHandler nextHandler){
        super(nextHandler);
    }
    public void processOrder(String order){
        System.out.println("Validation Payment process : " + order);

        //If the payment is done pass it to the next hanler
        if(nextHandler != null){
            nextHandler.processOrder(order);
        }
    }
}

//Concrete handler for order preparation
class orderPreparationHandler extends OrderHandler{
    public orderPreparationHandler(OrderHandler nextHandler){
        super(nextHandler);
    }
    public void processOrder(String order){
        System.out.println("Preparing order: " + order);

        //If the order is prepared pass it to the next handler
        if(nextHandler != null){
            nextHandler.processOrder(order);
        }
    }
}

//Concrete handler for delivery assignment
class deliveryHandler extends OrderHandler{
    public deliveryHandler(OrderHandler nextHandler){
        super(nextHandler);
    }
    public void processOrder(String order){
        System.out.println("Delivery assigner of order: " + order);

        //If the delivery is assigned pass it to the next handler
        if(nextHandler != null){
            nextHandler.processOrder(order);
        }
    }
}

//Concrete handler for tracking order
class trackingHandler extends OrderHandler{
    public trackingHandler(OrderHandler nextHandler){
        super(nextHandler);
    }

    public void processOrder(String order){
        System.out.println("Tracking order: " + order);
    }
}
public class SwiggyOrder {
    public static void main(String[] args) {
        OrderHandler orderProcessingChain = new orderValidationHandler(
                new paymentProcessingHandler(
                        new orderPreparationHandler(
                                new deliveryHandler(
                                        new trackingHandler(null)))));

        String order = "Pizza";
        orderProcessingChain.processOrder(order);
    }
}
