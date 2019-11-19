import java.util.ArrayDeque;
import java.util.Deque;

public class Flak {
    protected Deque<Object> contents = new ArrayDeque<>();
    private final int capacity;
    private int angle;
    private final int maxAngle;
    private double x;
    private double y;
    private double dx;
    private double dy;
    public Truck truck;


    public Flak(int capacity, int maxAngle, Truck truck) {
        this.capacity = capacity;
        this.angle = 0;
        this.maxAngle = maxAngle;
        this.truck = truck;
        updateLocationAndDirection();
    }
    /*
    public void currentLoad(){
        for (int x = 0; x<contents.size(); x++){
            System.out.println(contents.peek());
        }
        return ;
    }
    */
    private void updateLocationAndDirection(){
        this.dx=truck.getDx();
        this.dy=truck.getDy();
        this.x=truck.getX();
        this.y=truck.getY();
    }

    public int getCapacity() {
        return capacity;
    }

    public void lowerFlak(int amount){
        if (angle-amount<0) {
            angle = 0;
            System.out.println("Max angle");
        }
        else
            angle-=amount;
    }
    public void raiseFlak(int amount){
        if (angle+amount>maxAngle) {
            angle=maxAngle;
            System.out.println("Max angle");
        }
        else
            angle+=amount;
    }
}
