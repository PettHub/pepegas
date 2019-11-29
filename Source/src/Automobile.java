import java.awt.*;

/**
     * A class for Automobiles.
     *
     * Contains necessary methods to make a Automobile move (speed up, slow down, turn). Assumes "forward" is up.
     *
     */

    public abstract class Automobile implements Movable{

        public Automobile(int nrDoors, Color color, int enginePower, String modelName) {
            this.nrDoors=nrDoors;
            this.color = color;
            this.enginePower = enginePower;
            this.modelName = modelName;
            stopEngine();
        }

        private final static double trimFactor = 1.25;
        private int nrDoors; // Number of doors on the Automobile
        private double enginePower; // Engine power of the Automobile
        private double currentSpeed; // The current speed of the Automobile
        private Color color; // Color of the Automobile
        private String modelName; // The Automobile model name
        private int x;
        private int y;
        private double dx;
        private double dy;
        private double direction = Math.PI*1.5;

        public double getDirection() {
            return direction;
        }

        /**
         * Method setDxDy sets the speed for x and y, based on direction and current speed
         */

        private void updateDirectionalVelocity(){
            dx = Math.cos(direction)*getCurrentSpeed();
            dy = Math.sin(direction)*getCurrentSpeed();
        }

        /**
         * Method move uses the speeds for x and y to change the Automobile's coordinates
         */

        public void move(){
            updateDirectionalVelocity();
            x += dx;
            y += dy;
        }

        /**
         * Increases or decreases direction based on input
         * @param degreeChange
         */
        private void changeDirection(double degreeChange){
            direction += degreeChange;
        }

        /**
         * If turnLeft is activated, this method will change the Automobile's direction to the left
         */
        public void turnLeft(){ //changes direction after input
            changeDirection(Math.PI*20/360);
        }

        /**
         * If turnRight is activated, this method will change the Automobile's direction to the right
         */
        public void turnRight(){ //changes direction after input
            changeDirection(-Math.PI*20/360);
        }

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
         */
        private boolean isBetween0And1(double amount){
            return (amount <= 1 && amount >= 0);
        }

        /**
         * increases speed
         * @param amount double value for increasing speed
         */
        private void incrementSpeed(double amount) {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        }

        /**
         * decreases speed
         * @param amount
         */
        private void decrementSpeed(double amount) {
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public String getModelName() {
        return modelName;
    }
}