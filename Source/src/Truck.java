import java.awt.*;

public abstract class Truck extends Automobile {
    public Flak flak=null;
    public Truck(int nrDoors, Color color, int enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }
}
