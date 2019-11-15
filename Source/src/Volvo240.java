import java.awt.*;

/**
 * A class for a Volvo 240 car, inherits from the Car class. Doesn't override anything, as the Car class' methods are based on this.
 *
 *
 * @author pepegas
 */


public class Volvo240 extends Car {

    public Volvo240() {
        super(4,Color.black,100,"Volvo240");
    }
/*
    @Override
    public void incrementSpeed(double amount) {
        this.setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    @Override
    public void decrementSpeed(double amount) {
        this.setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }
    /*
    @Override
    public void move() {
    }
    @Override
    public void turnLeft() {
    }
    @Override
    public void turnRight() {
    }*/
}
