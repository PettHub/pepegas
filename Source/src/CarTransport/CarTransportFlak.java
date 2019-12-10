package CarTransport;

import Cars.Car;
import Trucks.Flak;

import java.util.ArrayList;
import java.util.List;
/**
 * A class for the car transport flak. inherits flak
 *
 *
 * This is a special flak that comes with many additional methods to the original flak as well as an actuall capacity.
 * The capacity is for storing objects of the Class Cars.Car and is determined in the constructor call.
 * Contains checks for and methods to load and unload cars
 * @author pepegas
 */
public class CarTransportFlak extends Flak {
    List<Car> contents = new ArrayList<>();
    private final int capacity;
    CarTransportFlak(int capacity) {
        super(1);
        this.capacity = capacity;
    }

    void addCarToFlak(Car bil) {
        if (this.contents.size()<this.capacity && this.getAngle()==0 && czechIfCarIsCloseToFlak(bil)) {
            updateCarLocation(bil);
            this.contents.add(bil);
            bil.setOccupied(true);
        }
    }

    void removeCarFromFlak() {
        if (this.contents.size() > 0 && this.getAngle()==0) {
            Car bil = this.contents.remove(contents.size()-1);
            updateCarLocationUponCarRemoval(bil);
            bil.setOccupied(false);
        }
    }
    void updateAllTheCars(){
        for (Car bil : contents){
            updateCarLocation(bil);
        }
    }

    private void updateCarLocation(Car bil){
        bil.setX(this.getX());
        bil.setY(this.getY());
    }
    private void updateCarLocationUponCarRemoval(Car bil){
        bil.setX((int)(this.getX()-Math.cos(this.getDirection())*20));
        bil.setY((int)(this.getY()-Math.sin(this.getDirection())*20));
    }
    private boolean czechIfCarIsCloseToFlak(Car bil){
        return czechIfXOfCarIsInProximityToXOfFlak(bil) && czechIfYOfCarIsInProximityToYOfFlak(bil);
    }
    private boolean czechIfXOfCarIsInProximityToXOfFlak(Car bil){
        return (40>Math.sqrt(Math.pow(this.getX()-bil.getX(), 2)));
    }
    private Boolean czechIfYOfCarIsInProximityToYOfFlak(Car bil){
        return (40>Math.sqrt(Math.pow(this.getY()-bil.getY(), 2)));
    }
}
