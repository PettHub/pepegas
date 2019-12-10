package Trucks;

import java.awt.*;
/**
 * A class for a Trucks.Scania truck, inherits the class Trucks.Truck
 *
 *@author pepegas
 */
public class Scania extends Truck<Flak>{

    public Scania() {
        super(2, Color.RED, 90, "Trucks.Scania");
        this.flak = new Flak(70);
    }
    @Override
    public void move() {
        super.move();
        if (this.flak != null) {
            updateLocationAndDirection();
        }
    }
    public void updateLocationAndDirection(){
        this.flak.setCurrentSpeed(this.getCurrentSpeed());
        this.flak.setDirection(this.getDirection());
        this.flak.setX(this.getX());
        this.flak.setY(this.getY());
    }
    void detachFromTruck(){
        this.flak=null;
    }
}
