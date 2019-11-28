import org.hamcrest.core.Is;

import java.awt.*;
/**
 * An abstract class for the generic truck, inherits from the Automotive class. Overrides the "move" function for integration of flak
 * @author pepegas
 */
public abstract class Truck <A extends IsAttachableToTruck> extends Automobile {
    public A flak=null;
    public Truck(int nrDoors, Color color, int enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }
    /*
    Den är som en bil förutom 2 andra funktioner.
    Den kan inte röra sig förens flaket är nere. Detta är ytterligare abstraherat för framtidens skull
    den har tillgång till ett flak
    */
    void detachFlak(){
        this.flak=null;
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

    public void updateLocationAndDirection(){
        this.dx=truck.getDx();
        this.dy=truck.getDy();
        this.x=truck.getX();
        this.flak.=truck.getY();
    }
}
