import java.awt.*;

public abstract class Truck extends Car {
    private Flak flak;

    public Truck(int nrDoors, Color color, int enginePower, String modelName, int capacity, int maxAngle) {
        super(nrDoors, color, enginePower, modelName);
        this.flak = new Flak(capacity, maxAngle);
    }

}
