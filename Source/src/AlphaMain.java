/**
 * Early stage main method
 *
 * Used to test certain features, amongst them the feature that a truck transporting cars shouldn't be able to load itself onto itself.
 *
 */

public class AlphaMain {
    public static void main(String[] args) {
        Car bil = new Volvo240();
        Verkstad<Volvo240> volvoVerkstad = new Verkstad<Volvo240>(4);
        CarTransportTruck biltransport = new CarTransportTruck("bil", 2);
        biltransport.detachFlak();
        biltransport.attachFlak(new CarTransportFlak(5));
    }
}
