/**
 * Early stage main method
 *
 * Used to test certain features, amongst them the feature that a truck transporting cars shouldn't be able to load itself onto itself.
 *
 */

public class AlphaMain {
    public static void main(String[] args) {
        Car bil = new Volvo240();
        CarTransportTruck brummis = new CarTransportTruck("brummis");
        brummis.flak = new CarTransportFlak(4);
        brummis.flak.attachToTruck(brummis);
        brummis.flak.addCarToFlak(bil);//ska inte kunna ladda sig själv
        brummis.gas(1);
        brummis.gas(1);
        brummis.gas(1);
        brummis.move();
    }
}
