import java.util.ArrayDeque;
import java.util.Deque;
/**
 * Flak is a Class that implements IsAttachableToTruck.
 *
 * Is made to allow trucks to have additioinal functions and is also a standard for future flak-designs
 * Contains coordinates and a variable for the truck it is currently attached to
 * Also contains a value for the angle of the flak. What this represents is up to the creator of the flak to decide
 * @author pepegas
 */
public class Flak implements IsAttachableToTruck{
    private int angle;
    private final int maxAngle;
    private int x;
    private int y;
    private double dx;
    private double dy;

    @Override
    public boolean readyForMoving() {
        return this.angle==0;
    }

    public Flak(int maxAngle) {
        this.angle = 0;
        this.maxAngle = maxAngle;
    }

    public void updateLocationAndDirection(){
        this.dx=truck.getDx();
        this.dy=truck.getDy();
        this.x=truck.getX();
        this.y=truck.getY();
    }

    public void lowerFlak(int amount){
        if (this.dx == 0 && this.dy ==0) {
            if (angle - amount < 0) {
                angle = 0;
                System.out.println("Max angle");
            } else
                angle -= amount;
        }
    }
    public void raiseFlak(int amount) {
        if (this.dx == 0 && this.dy==0) {
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
    

    int getAngle() {
        return angle;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    double getDx() {
        return dx;
    }

    double getDy() {
        return dy;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    void setDx(double dx) {
        this.dx = dx;
    }

    void setDy(double dy) {
        this.dy = dy;
    }
}
