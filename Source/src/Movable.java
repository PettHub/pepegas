/**
 * An interface for movable vehicles to implement (here volvo and saab)
 *
 * @author pepegas
 */

interface Movable{
    void move();
    void turnLeft();
    void turnRight();
    void incrementSpeed(double amount);
    void decrementSpeed(double amount);
}