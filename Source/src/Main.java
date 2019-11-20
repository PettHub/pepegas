public class Main {
    public static void main(String[] args) {
        Car bil = new Volvo240();
        CarTransportTruck brummis = new CarTransportTruck("brummis");
        brummis.flak = new CarTransportFlak(4);
        brummis.flak.attachToTruck(brummis);
        brummis.flak.addCarToFlak(bil);//ska inte kunna ladda sig själv
    }
}
