import java.awt.*;

public class CarTransportTruck extends Truck {
    public CarTransportFlak flak = null;

    public CarTransportTruck(String modelName, int capacity) {
        super(2, Color.CYAN, 70, modelName);
        this.flak = new CarTransportFlak(capacity);
        this.flak.attachToTruck(this);
    }

    @Override
    public void move() {
        super.move();
        if (flak != null)
            this.flak.updateAllTheCars();
    }
}
