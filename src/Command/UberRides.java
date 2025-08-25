package Command;

class RideService{
    public void requestRide(String passenger, String srcLoc, String destLoc){
        System.out.println("Requesting a ride for passenger: " +passenger +"from " +srcLoc +"to " +destLoc);
    }
    public void cancelRide(String passenger){
        System.out.println("cancelling the ride of passenger: " +passenger);
    }
}

interface Command{
    void execute();
}

class RideRequestCommand implements Command{
    private RideService receiver;
    private String passenger;
    private String srcLoc;
    private String destLoc;

    public RideRequestCommand(RideService receiver, String passenger, String srcLoc, String destLoc){
        this.receiver = receiver;
        this.passenger = passenger;
        this.srcLoc = srcLoc;
        this.destLoc = destLoc;
    }
    public void execute(){
        receiver.requestRide(passenger,srcLoc,destLoc);
    }
}
class CancelRideCommand implements Command{
    private RideService receiver;
    private String passenger;

    public CancelRideCommand (RideService receiver, String passenger){
        this.receiver = receiver;
        this.passenger = passenger;
    }
    public void execute(){
        receiver.cancelRide(passenger);
    }
}

class RideRequestInvoker{
    public void processRequest(Command command){
        command.execute();
    }
}
public class UberRides {
    public static void main(String[] args) {
        RideService rideService = new RideService();
        RideRequestInvoker invoker = new RideRequestInvoker();
        Command request1 = new RideRequestCommand(rideService, "kamal","Giridih", "Ranchi");
        Command request2 = new RideRequestCommand(rideService ,"Harshika", "Bhubaneswar", "Dhanbad");
        Command cancel1 = new CancelRideCommand(rideService, "Harshika");

        invoker.processRequest(request1);
        invoker.processRequest(request2);
        invoker.processRequest(cancel1);
    }
}
