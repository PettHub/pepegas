import java.awt.*;
/**
 * An abstract class for the generic truck, inherits from the Automotive class. Overrides the "move" function for integration of flak
 * @author pepegas
 */
public abstract class Truck extends Automobile {
    public IsAttachableToTruck flak=null;
    public Truck(int nrDoors, Color color, int enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }
    /*
    Den är som en bil förutom 2 andra funktioner.
    Den kan inte röra sig förens flaket är nere. Detta är ytterligare abstraherat för framtidens skull
    den har tillgång till ett flak
    */
    @Override
    public void move() {
        if (this.flak != null && this.flak.readyForMoving()) {
            super.move();
            this.flak.updateLocationAndDirection();
        }
        else if (this.flak != null && !this.flak.readyForMoving()){
            System.out.println("Flaket är inte redo!");
        }
        else
            super.move();
    }
}
