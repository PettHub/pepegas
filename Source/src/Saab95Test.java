import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {
    Saab95 bil = new Saab95();
    @Test
    void startEngine() throws Exception{
    }

    @Test
    void gas() throws Exception{
        bil.gas(1);
        assertNotEquals(bil.getCurrentSpeed(), 0.1);
    }

    @Test
    void brake() throws Exception{
        bil.brake(1);
        assertEquals(bil.getCurrentSpeed(), 0);
    }

    @Test
    void setTurboOn() throws Exception{
        bil.setTurboOn();
        assertTrue(bil.isTurboOn());
    }

    @Test
    void setTurboOff() throws Exception{
        bil.setTurboOff();
        assertFalse(bil.isTurboOn());
    }

    @Test
    void turnLeft() throws Exception{
        bil.turnLeft();
        assertEquals(bil.getDirection(), 290);
    }

    @Test
    void move() throws Exception{
        bil.startEngine();
        bil.setDxDy();
        bil.move();
        assertEquals(bil.getX(), 0);
        assertNotEquals(bil.getY(), 0.0);
    }

    @Test
    void turnRight() throws Exception{
        bil.turnRight();
        assertEquals(bil.getDirection(), 250);
    }

    @Test
    void stopEngine() throws Exception{
        bil.stopEngine();
        assertEquals(bil.getCurrentSpeed(), 0);
    }
}