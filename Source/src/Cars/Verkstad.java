package Cars;

import java.util.ArrayList;
import java.util.List;

public class Verkstad <A extends Car>{
    int maxLimit;
    List<A> currentCars = new ArrayList<>();
    public Verkstad(int maxLimit) {
        this.maxLimit = maxLimit;
    }
    public void leaveCarAtShop(A bil){
        if (currentCars.size()<maxLimit){
            currentCars.add(bil);
            bil.isOccupied = true;
        }
    }
    public A returnVehicle(A carYouWantToGet){
        for (A car : currentCars){
            if (car == carYouWantToGet) {
                carYouWantToGet.isOccupied = false;
                currentCars.remove(carYouWantToGet);
                return car;
            }
        }
        System.out.println("this car is not in the shop");
        return null;
    }
}
