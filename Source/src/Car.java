import java.awt.*;

/**
 * A class for Car.
 *
 * Contains necessary methods to make a car move (speed up, slow down, turn). Assumes "forward" is up.
 *
 * @author pepegas
 */

public abstract class Car implements Movable{

    public Car(int nrDoors, Color color, int enginePower, String modelName) {
        this.nrDoors=nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
    }


    private final static double trimFactor = 1.25;
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x;
    private double y;
    private double dx;
    private double dy;
    private double direction = Math.PI*1.5;

    public double getDirection() {
        return direction;
    }

    /**
     * Method setDxDy sets the speed for x and y
     * @author Toast
     */

    private void updateDirectionalVelocity(){
        dx = Math.cos(direction)*getCurrentSpeed();
        dy = Math.sin(direction)*getCurrentSpeed();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    /**
     * Method move uses the speeds for x and y to change the car's coordinates
     * @author Toast
     */

    public void move(){
        //currentSpeed = Math.sqrt(dy*dy + dx*dx);
        updateDirectionalVelocity();
        x += dx;
        y += dy;
    }

    /**
     * Increases or decreases direction based on input
     * @param degreeChange
     * @author pepegas
     */
    private void changeDirection(double degreeChange){
        direction += degreeChange;
    }

    /**
     * If turnLeft is activated, this method will change the car's direction to the left
     * @author pepegas
     */
    public void turnLeft(){ //changes direction after input
        changeDirection(Math.PI*20/360);
    }

    /**
     * If turnRight is activated, this method will change the car's direction to the right
     * @author pepegas
     */
    public void turnRight(){ //changes direction after input
        changeDirection(-Math.PI*20/360);
    }//Uppgift b SLUT

    //Start getters & setters

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    //End getters and setters

    /**
     * Starts the engine by setting currentSpeed to 0.1
     */

    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Stops the engine by setting currentSpeed to 0
     */

    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Sets the speedFactor
     * @return double value speed factor
     */
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

    /**
     * Makes car speed up if gas is used
     * @param amount
     * @author Toast and Oliver
     */
    public void gas(double amount) {
        if (isBetween0And1(amount)) {
            //double tmpSpeed = currentSpeed;
            incrementSpeed(amount);
            /*if (currentSpeed < tmpSpeed) {
                currentSpeed = tmpSpeed;
                System.out.println("speed was not changed");
            }
            if (currentSpeed >= enginePower) {
                currentSpeed = enginePower;
            }*/
        }
    }

    /**
     * Makes car slow down if brake is used
     * @param amount
     * @author Toast and Oliver
     */

    public void brake(double amount) {
        double tmpSpeed = currentSpeed;
        if (isBetween0And1(amount)) {
            decrementSpeed(amount);
            /*if (currentSpeed > tmpSpeed) {
                currentSpeed = tmpSpeed;
                System.out.println("speed was not changed");
            }
            if (currentSpeed < 0)
                currentSpeed = 0;*/
        }
    }


    /**
     * Checks if the amount is between 0 and 1
     * @param amount value between 0 and 1
     * @author pepegas
     */
    private boolean isBetween0And1(double amount){
        return (amount <= 1 && amount >= 0);
    }
/*
    private double changeSpeed(double amount){
        if (isBetween0And1(amount))
            return amount;
        else {
            System.out.println("parameter out of range");
            return 0;
        }
    }
*/
    /**
     * increases speed
     * @param amount double value for increasing speed
     * @author pepegas
     */
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     * decreases speed
     * @param amount
     * @author pepegas
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

}
