import java.awt.*;

/**
 * A class for Car.
 *
 * Contains necessary methods to make a car move (speed up, slow down, turn). Assumes "forward" is up.
 *
 * @author pepegas
 */

public abstract class Car extends Automobile {
    public Car(int nrDoors, Color color, int enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }
}