import java.util.ArrayDeque;
import java.util.Deque;

public class Flak {
    private int angle;
    private final int maxAngle;
    private double x;
    private double y;
    private double dx;
    private double dy;
    private Truck truck = null;


    public Flak(int maxAngle) {
        this.angle = 0;
        this.maxAngle = maxAngle;
    }
    /*
    public void currentLoad(){
        for (int x = 0; x<contents.size(); x++){
            System.out.println(contents.peek());
        }
        return ;
    }
    */
    public void attachToTruck(Truck newTruck) {
        if (this.truck == null) {
            this.truck = newTruck;
            updateLocationAndDirection();
        }
    }
    public void detachFromTruck(){
        updateLocationAndDirection();
        this.truck.flak=null;
        this.truck = null;
    }
    public void updateLocationAndDirection(){
        this.dx=truck.getDx();
        this.dy=truck.getDy();
        this.x=truck.getX();
        this.y=truck.getY();
    }

    public void lowerFlak(int amount){
        updateLocationAndDirection();
        if (angle-amount<0) {
            angle = 0;
            System.out.println("Max angle");
        }
        else
            angle-=amount;
    }
    public void raiseFlak(int amount){
        updateLocationAndDirection();
        if (angle+amount>maxAngle) {
            angle=maxAngle;
            System.out.println("Max angle");
        }
        else
            angle+=amount;
    }

    public int getAngle() {
        return angle;
    }
}
