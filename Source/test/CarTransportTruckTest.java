/*import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

public class CarTransportTruckTest {
    CarTransportTruck CTT = new CarTransportTruck("yeshello", 2);
    @Test
    void move() throws Exception{
        Volvo240 bil1 = new Volvo240();
        Saab95 bil2 = new Saab95();
        CTT.flak.addCarToFlak(bil1);
        CTT.flak.addCarToFlak(bil2);
        assertEquals(CTT.getX(), 0.0);
        assertEquals(CTT.getY(), 0.0);
        CTT.startEngine();
        CTT.turnLeft();
        CTT.gas(1);
        CTT.gas(1);
        CTT.gas(1);
        CTT.turnLeft();
        CTT.turnLeft();
        CTT.turnLeft();
        CTT.turnLeft();
        CTT.gas(1);
        CTT.gas(1);
        CTT.gas(1);
        CTT.gas(1);
        CTT.gas(1);
        CTT.move();
        assertNotEquals(CTT.getX(), 0.0);
        assertNotEquals(CTT.getY(), 0.0);
        assertEquals(CTT.flak.getCoordinates()[0], CTT.getX());
        assertEquals(CTT.flak.getCoordinates()[1], CTT.getY());
        assertEquals(CTT.flak.contents.get(0).getX(), CTT.getX());
        assertEquals(CTT.flak.contents.get(0).getY(), CTT.getY());
        assertEquals(CTT.flak.contents.get(1).getX(), CTT.getX());
        assertEquals(CTT.flak.contents.get(1).getY(), CTT.getY());
    }
}
*/