import java.awt.*;

/**
 * A class for a car transport truck. inherits the truck class
 *
 *
 * Contains a different flak type that is specific flak for car transport and further overrides the "move function"
 * Contains 2 constructors, 1 for creating a Truck with a flak and 1 for creating a "flak-less" truck
 */

public class CarTransportTruck extends Truck {
    CarTransportFlak flak = null;

    public CarTransportTruck(String modelName, int capacity) {
        super(2, Color.CYAN, 70, modelName);
        this.flak = new CarTransportFlak(capacity);
        this.flak.attachToTruck(this);
    }

    public CarTransportTruck(String modelName) {
        super(2, Color.CYAN, 70, modelName);
    }

    @Override
    public void move() {
        super.move();
        if (flak != null)
            this.flak.updateAllTheCars();
    }
}
