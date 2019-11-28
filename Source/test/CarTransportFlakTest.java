/*import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CarTransportFlakTest {

    CarTransportTruck CTT = new CarTransportTruck("BRummIs", 2);
    Volvo240 bil1 = new Volvo240();
    Saab95 bil2 = new Saab95();

    @Test
    void addCarToFlak() {
        CTT.flak.addCarToFlak(bil1);
        CTT.flak.addCarToFlak(bil2);
        assertEquals(CTT.flak.contents.size(), 2);
    }

    @Test
    void removeCarFromFlak() {
        CTT.flak.addCarToFlak(bil1);
        assertEquals(CTT.flak.contents.size(), 1);
        CTT.flak.removeCarFromFlak();
        assertEquals(CTT.flak.contents.size(), 0);
        assertNotEquals(CTT.getY(), bil1.getY());
    }

}*/

