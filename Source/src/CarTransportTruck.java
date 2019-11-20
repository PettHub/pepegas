import java.awt.*;

public class CarTransportTruck extends Truck {
    public CarTransportFlak flak = null;
    public CarTransportTruck(String modelName) {
        super(2, Color.CYAN, 70, modelName);
        this.flak = new CarTransportFlak(4);
    }

}
