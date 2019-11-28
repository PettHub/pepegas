/*import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScaniaTest {
    Scania scania = new Scania();
    @Test
    void startEngine() throws Exception{
        scania.startEngine();
        assertEquals(scania.getCurrentSpeed(), 0.1);
    }


    @Test
    void gas() throws Exception{
        assertTrue(scania.flak.readyForMoving()); //Kollar att flak är i rätt position för att flyttas
        scania.gas(1);
        assertNotEquals(scania.getCurrentSpeed(), 0.1);
    }


    @Test
    void brake() throws Exception{
        scania.brake(1);
        assertEquals(scania.getCurrentSpeed(), 0);
    }

    @Test
    void turnLeft() throws Exception{
        scania.turnLeft();
        assertEquals(scania.getDirection(), Math.PI*1.5+Math.PI*20.0/360); //Byter flaket riktning?
    }

    @Test
    void move() throws Exception{
        assertEquals(scania.getX(), 0.0);
        assertEquals(scania.getY(), 0.0);
        scania.startEngine();
        scania.turnLeft();
        scania.turnLeft();
        scania.turnLeft();
        scania.turnLeft();
        scania.turnLeft();
        scania.gas(1);
        scania.gas(1);
        scania.gas(1);
        scania.gas(1);
        scania.gas(1);
        scania.move();
        assertNotEquals(scania.getX(), 0.0);
        assertNotEquals(scania.getY(), 0.0);
        assertEquals(scania.flak.getCoordinates()[0], scania.getX());
        assertEquals(scania.flak.getCoordinates()[1], scania.getY()); //Kollar så att flaket och trucken är på samma ställe. Borde man kolla Dx också?
    }

    @Test                               //Borde vi kolla att flaket har samma riktning?
    void turnRight() throws Exception{
        scania.turnRight();
        assertEquals(scania.getDirection(), Math.PI*1.5-Math.PI*20.0/360);
    }

    @Test
    void stopEngine() throws Exception{
        scania.stopEngine();
        assertEquals(scania.getCurrentSpeed(), 0);
    }

    @Test
    void detachFromTruck() throws Exception{
        scania.flak.detachFromTruck();
        assertEquals(scania.flak, null);
    }

    @Test
    void attachToTruck() throws Exception{
        scania.flak.detachFromTruck();
        assertEquals(scania.flak, null);
        scania.flak = new Flak(70);
        scania.flak.attachToTruck(scania);
        assertNotEquals(scania.flak, null);
    }

}*/
