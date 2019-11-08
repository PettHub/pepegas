import java.awt.*;

public class Saab95 extends Car implements Movable {

    private boolean turboOn;

    public Saab95() {
        this.setNrDoors(2);
        this.setColor(Color.red);
        this.setEnginePower(125);
        this.turboOn = false;
        this.modelName = "Saab95";
        stopEngine();
    }


    //Mina grejer
    private double x;
    private double y;
    private int direction;

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }

    public void incrementSpeed(double amount) {
        this.setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    @Override
    public void decrementSpeed(double amount) {
        this.setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
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
