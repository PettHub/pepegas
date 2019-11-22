import java.awt.*;
/**
 * A class for a Scania truck, inherits the class Truck
 *
 *@author pepegas
 */
public class Scania extends Truck{
    public Flak flak = null;
    public Scania() {
        super(2, Color.black, 90, "Scania");
        this.flak = new Flak(70);
        this.flak.attachToTruck(this);
    }
    @Override
    public void move() {
        if (this.flak != null) {
            if (this.flak.readyForMoving()) {
                super.move();
                this.flak.updateLocationAndDirection();
            } else if (!this.flak.readyForMoving()) {
                System.out.println("Flaket är inte redo!");
            }
        }
        else
            super.move();
    }
    void detachFromTruck(){
        this.flak=null;
    }
}
