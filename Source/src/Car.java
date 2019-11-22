import java.awt.*;

/**
 * A class for Car.
 *
 * Only contains a constructor calling for the super (Automobile) constructor
 */

public abstract class Car extends Automobile {
    public Car(int nrDoors, Color color, int enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }
    boolean isOccupied = false;
}