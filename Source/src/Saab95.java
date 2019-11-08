import java.awt.*;

public class Saab95 extends Car implements Movable{

    public boolean turboOn;
    
    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }

    //Mina grejer
    private double x;
    private double y;
    private double dx;
    private double dy;
    private double direction = 270;

    private void setDxDy(){
        dx = Math.cos(direction)*currentSpeed;
        dy = Math.sin(direction)*currentSpeed;
    }

    public void move(){
    //currentSpeed = Math.sqrt(dy*dy + dx*dx);
        x += dx;
        y += dy;
    }
    public void changeDirection(int degreeChange){
        direction += degreeChange;
    }
    public void turnLeft(){ //Todo change direction after input
        changeDirection(20);
    }
    public void turnRight(){ //Todo change direction after input
        changeDirection(-20);
    }


    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
    
}
