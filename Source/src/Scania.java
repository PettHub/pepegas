import java.awt.*;

public class Scania extends Truck{
    public Scania() {
        super(2, Color.black, 90, "Scania", 70);
    }
    @Override
    public void move() {
        if (flak.getAngle()==0)
            super.move();
        else
            stopEngine();
    }
}
