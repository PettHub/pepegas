import java.util.ArrayList;
import java.util.List;

public class Verkstad <A>{
    int maxLimit;
    List<A> currentCars = new ArrayList<>();
    public Verkstad(int maxLimit) {
        this.maxLimit = maxLimit;
    }
    public void leaveCarAtShop(A bil){
        if (currentCars.size()<maxLimit){
            currentCars.add(bil);
            Car tmp = (Car) bil;
            tmp.isOccupied = true;
        }
    }
    public A returnVehicle(A carYouWantToGet){
        for (A car : currentCars){
            if (car == carYouWantToGet) {
                Car tmp = (Car) car;
                tmp.isOccupied = false;
                return car;
            }
        }
        System.out.println("this car is not in the shop");
        return null;
    }
}
