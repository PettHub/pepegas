import java.util.ArrayDeque;
import java.util.Deque;

public class Flak implements IsAttachableToTruck{
    private int angle;
    private final int maxAngle;
    private int x;
    private int y;
    private double dx;
    private double dy;
    private Truck truck = null;

    @Override
    public boolean readyForMoving() {
        return this.angle==0;
    }

    public Flak(int maxAngle) {
        this.angle = 0;
        this.maxAngle = maxAngle;
    }

    public void attachToTruck(Truck newTruck) {
        if (this.truck == null) {
            this.truck = newTruck;
        }
    }

    public void detachFromTruck(){
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
        if (truck.getCurrentSpeed()==0) {
            if (angle - amount < 0) {
                angle = 0;
                System.out.println("Max angle");
            } else
                angle -= amount;
        }
    }
    public void raiseFlak(int amount) {
        if (truck.getCurrentSpeed() == 0) {
            if (angle + amount > maxAngle) {
                angle = maxAngle;
                System.out.println("Max angle");
            } else
                angle += amount;
        }
    }

    @Override
    public int[] getCoordinates() {
        int[] coordinates = new int[2];
        coordinates[0] = this.x;
        coordinates[1] = this.y;
        return coordinates;
    }
    

    public int getAngle() {
        return angle;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public Truck getTruck() {
        return truck;
    }
}
