import java.awt.*;

public class Scania extends Truck{
    public Scania() {
        super(2, Color.black, 90, "Scania");
        this.flak = new Flak(70);
    }
}
