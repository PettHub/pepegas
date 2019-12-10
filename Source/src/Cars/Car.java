package Cars;

import java.awt.*;

/**
 * A class for Cars.Car.
 *
 * Only contains a constructor calling for the super (Cars.Automobile) constructor
 */

public abstract class Car extends Automobile {
    public Car(int nrDoors, Color color, int enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }
    boolean isOccupied = false;

    @Override
    public void move() {
        if (!isOccupied)
            super.move();
        else
            System.out.println("is pre-occupied and will not move");
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}