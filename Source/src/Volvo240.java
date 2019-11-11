import java.awt.*;

public class Volvo240 extends Car implements Movable {

    public final static double trimFactor = 1.25;

    public Volvo240() {
        this.setNrDoors(4);
        this.setColor(Color.black);
        this.setEnginePower(100);
        modelName = "Volvo240";
        stopEngine();
    }

    private double x;
    private double y;
    private int direction;

    @Override
    public void incrementSpeed(double amount) {
        this.setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    @Override
    public void decrementSpeed(double amount) {
        this.setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }

    @Override
    public void move() {
    }
    @Override
    public void turnLeft() {
    }
    @Override
    public void turnRight() {
    }
}
