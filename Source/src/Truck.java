import java.awt.*;

public abstract class Truck extends Car {
    public Flak flak;

    public Truck(int nrDoors, Color color, int enginePower, String modelName, int maxAngle) {
        super(nrDoors, color, enginePower, modelName);
        this.flak = new Flak(maxAngle);
    }
}
