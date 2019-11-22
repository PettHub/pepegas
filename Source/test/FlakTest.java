import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlakTest {
    Scania truck = new Scania();

    @Test
    void raiseFlak() throws Exception{
        truck.flak.raiseFlak(50);
        assertEquals(truck.flak.getAngle(), 50);
    }

    @Test
    void lowerFlak() throws Exception{
        truck.flak.raiseFlak(50);
        truck.flak.lowerFlak(30);
        assertEquals(truck.flak.getAngle(),20);
    }


}
