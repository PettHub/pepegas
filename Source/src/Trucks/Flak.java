package Trucks;

/**
 * Trucks.Flak is a Class that implements Trucks.IsAttachableToTruck.
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
    private double direction;
    private double currentSpeed;

    @Override
    public boolean readyForMoving() {
        return this.angle==0;
    }

    public Flak(int maxAngle) {
        this.angle = 0;
        this.maxAngle = maxAngle;
    }
    @Override
    public void setAngle(int angle) {
        this.angle = angle;
    }

    @Override
    public int getMaxAngle() {
        return this.maxAngle;
    }

    @Override
    public int getAngle() {
        return this.angle;
    }

    public int[] getCoordinates() {
        int[] coordinates = new int[2];
        coordinates[0] = this.x;
        coordinates[1] = this.y;
        return coordinates;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
}
