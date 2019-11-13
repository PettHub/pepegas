import java.awt.*;

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

    private void setDxDy(){
        dx = Math.cos(direction)*getCurrentSpeed();
        dy = Math.sin(direction)*getCurrentSpeed();
    }

    public void move(){
        //currentSpeed = Math.sqrt(dy*dy + dx*dx);
        x += dx;
        y += dy;
    }
    public void changeDirection(int degreeChange){
        direction += degreeChange;
    }
    public void turnLeft(){ //changes direction after input
        changeDirection(20);
    }
    public void turnRight(){ //changes direction after input
        changeDirection(-20);
    }//Uppgift b SLUT

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

        /*if (isBetweenZeroAndOne(amount) && currentSpeed < enginePower) {
            double tmpSpeed = currentSpeed;
            incrementSpeed(amount);
            if(currentSpeed < tmpSpeed){
                currentSpeed = tmpSpeed;
            }

        } else if (isBetweenZeroAndOne(amount) && currentSpeed >= enginePower) {
            currentSpeed = enginePower;
        } else {
            System.out.println("gas() parameter out of range ");
        }*/
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
