import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlakTest {
    Flak flak = new Flak(70);

    @Test
    void raiseFlak() throws Exception{
        flak.raiseFlak(50);
        assertEquals(flak.getAngle(), 50);
    }

    @Test
    void lowerFlak() throws Exception{
        flak.raiseFlak(50);
        flak.lowerFlak(30);
        assertEquals(flak.getAngle(),20);
    }


}
