import java.awt.*;

/**
 * A class for Car.
 *
 * Contains necessary methods to make a car move (speed up, slow down, turn). Assumes "forward" is up.
 *
 * @author pepegas
 */

public abstract class Car {

    private final static double trimFactor = 1.25;
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    public String modelName; // The car model name
    //Uppgift b START
    private double x;
    private double y;
    private double dx;
    private double dy;
    private double direction = 270;

    /**
     * Method setDxDy sets the speed for x and y
     * @author Toast
     */

    private void setDxDy(){
        dx = Math.cos(direction)*getCurrentSpeed();
        dy = Math.sin(direction)*getCurrentSpeed();
    }

    /**
     * Method move uses the speeds for x and y to change the car's coordinates
     * @author Toast
     */

    public void move(){
        //currentSpeed = Math.sqrt(dy*dy + dx*dx);
        x += dx;
        y += dy;
    }

    /**
     * Increases or decreases direction based on input
     * @param degreeChange
     * @author pepegas
     */
    public void changeDirection(int degreeChange){
        direction += degreeChange;
    }

    /**
     * If turnLeft is activated, this method will change the car's direction to the left
     * @author pepegas
     */
    public void turnLeft(){ //changes direction after input
        changeDirection(20);
    }

    /**
     * If turnRight is activated, this method will change the car's direction to the right
     * @author pepegas
     */
    public void turnRight(){ //changes direction after input
        changeDirection(-20);
    }//Uppgift b SLUT


    //Start setters and getters

    public void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setCurrentSpeed(double speed) {
        currentSpeed = speed;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        double tmpSpeed = currentSpeed;
        incrementSpeed(changeSpeed(amount));
        if(currentSpeed < tmpSpeed){currentSpeed = tmpSpeed; System.out.println("speed was not changed");}
        if (currentSpeed >= enginePower) { currentSpeed = enginePower;}
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        double tmpSpeed = currentSpeed;
        decrementSpeed(changeSpeed(amount));
        if(currentSpeed > tmpSpeed){
            currentSpeed = tmpSpeed;
            System.out.println("speed was not changed");
        }
    }

    private double changeSpeed(double amount){
        if (amount <= 1 && amount >= 0)
            return amount;
        else {
            System.out.println("parameter out of range");
            return 0;
        }
    }

    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
}
