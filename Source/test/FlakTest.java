import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlakTest {
    Scania scania = new Scania();


    @Test
    void raiseFlak() throws Exception{
        scania.flak.raiseFlak(50);
        assertEquals(scania.flak.getAngle(), 50);
    }

    @Test
    void lowerFlak() throws Exception{
        scania.flak.raiseFlak(50);
        scania.flak.lowerFlak(30);
        assertEquals(scania.flak.getAngle(),20);
    }


}
