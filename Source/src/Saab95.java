import java.awt.*;

/**
 * A class for a Saab 95 car, inherits from the class Car
 *
 * Contains a constructor and methods to turn turbo off and on, a method to calculate the speed factor
 * and two methods which both use the speed factor to either increase or decrease the speed.
 * @pepegas
 */

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

    @Override
    public void incrementSpeed(double amount) {
        this.setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    @Override
    public void decrementSpeed(double amount) {
        this.setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }
}
