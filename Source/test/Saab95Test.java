/*import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {
    Saab95 bil = new Saab95();
    @Test
    void startEngine() throws Exception{
        bil.startEngine();
        assertEquals(bil.getCurrentSpeed(), 0.1);
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
        assertEquals(bil.getDirection(), Math.PI*1.5+Math.PI*20.0/360);
    }

    @Test
    void move() throws Exception{
        assertEquals(bil.getX(), 0.0);
        assertEquals(bil.getY(), 0.0);
        bil.startEngine();
        bil.turnLeft();
        bil.turnLeft();
        bil.turnLeft();
        bil.turnLeft();
        bil.turnLeft();
        bil.gas(1);
        bil.gas(1);
        bil.gas(1);
        bil.gas(1);
        bil.gas(1);
        bil.move();
        assertNotEquals(bil.getX(), 0.0);
        assertNotEquals(bil.getY(), 0.0);
    }

    @Test
    void turnRight() throws Exception{
        bil.turnRight();
        assertEquals(bil.getDirection(), Math.PI*1.5-Math.PI*20.0/360);
    }

    @Test
    void stopEngine() throws Exception{
        bil.stopEngine();
        assertEquals(bil.getCurrentSpeed(), 0);
    }
}*/