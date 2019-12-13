package Cars;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


import CarView.Widget;
import Trucks.*;

public class CarModel extends Observable {


    //For adding single Observer upon creation.
    public CarModel() {
        walls[0] = new Wall(-400, -400, getMapX()*2, 400); //tak
        walls[1] = new Wall(-400, getMapY(), getMapX()*2, 400);//botten
        walls[2] = new Wall(-400, 0, 400, getMapY());//vänster vägg
        walls[3] = new Wall(getMapX(), -400, 400, getMapY()*2);//höger vägg
    }

    Wall[] walls = new Wall[4];
    private static final int mapX = 800;
    private static final int mapY = 600;
    //List<Widget> widgets = new ArrayList<>();
    //CarView frame;

    public void addAObserver(Observer o){
        this.addObserver(o);
    }
    public void startTimer(Observer o){
        this.timer = new Timer(delay, new TimerListener(o));
        this.timer.start();
    }

    List<JPanel> toBeAddedToObservers = new ArrayList<>();
    public List<Assoc> associations = new ArrayList<>();
    private final int delay = 50;
    Timer timer;
    void addWidgetToView(Assoc assoc){
        //frame.add(new Widget(assoc));
        //Widget tmp = new Widget(assoc);
        //toBeAddedToObservers.add(tmp);
        //frame.add(tmp);
        //this.setChanged();
    }
    void expandAssociations(Assoc assoc){
        associations.add(assoc);
        this.setChanged();
        this.notifyObservers();
    }

    void moveit(Assoc assoc) {
        assoc.getRectangle().x = assoc.getAutomobile().getX();
        assoc.getRectangle().y = assoc.getAutomobile().getY();
    }

   private class TimerListener extends Observable implements ActionListener {
       public TimerListener(Observer o){
           this.addObserver(o);
       }
       public void actionPerformed(ActionEvent e) {
            //frame.drawPanel.vehicle = associations;
            for (Assoc association : associations) {
                association.automobile.move();
                moveit(association);
                ifHitWallChangeDirection(association.automobile, hitWall(association.rectangle));
                // repaint() calls the paintComponent method of the panel
                this.setChanged();
                this.notifyObservers();
            }
            //updateSpeedWidgets();
            //frame.drawPanel.repaint();

        }
        //Tänker att man lägger in något här ovan så att den säger till att den i NewView skriver ut grejer. drawPanel?

        String hitWall(Rectangle r) {
            if (walls[0].rectangle.intersects(r)) {
                return "Upper";
            }
            if (walls[1].rectangle.intersects(r)) {
                return "Lower";
            }
            if (walls[2].rectangle.intersects(r)) {
                return "Left";
            }
            if (walls[3].rectangle.intersects(r)) {
                return "Right";
            }
            return "none";
        }
        private void ifHitWallChangeDirection(Automobile car, String wallHit) {
            double pi = Math.PI;
            double difference;
            switch (wallHit) {
                case "none":
                    break;
                case "Upper":
                    if (car.getDirection() >= 1.5 * pi) {
                        difference = car.getDirection() - 1.5 * pi;
                        car.setDirection(0.5 * pi - difference);
                                    car.setCurrentSpeed(0);
                    } else {
                        difference = 1.5 * pi - car.getDirection();
                        car.setDirection(0.5 * pi + difference);
                        car.setCurrentSpeed(0);
                    }
                    car.setY(0);
                    break;
                case "Lower":
                    if (car.getDirection() >= 0.5 * pi) {
                        difference = car.getDirection() - 0.5 * pi;
                        car.setDirection(1.5 * pi - difference);
                    } else {
                        difference = 0.5 * pi - car.getDirection();
                        car.setDirection(1.5 * pi + difference);
                    }
                    car.setCurrentSpeed(0);
                    //car.setY(800 - (240 + 60));
                    car.setY(800-260);
                    break;
                case "Left":
                    if (car.getDirection() >= 1 * pi) {
                        difference = car.getDirection() - 1 * pi;
                        car.setDirection(2 * pi - difference);
                        car.setCurrentSpeed(0);
                    } else {
                        difference = 1 * pi - car.getDirection();
                        car.setDirection(difference);
                        car.setCurrentSpeed(0);
                    }
                    car.setX(0);
                    break;
                case "Right":
                    if (car.getDirection() >= 0 * pi) {
                        difference = car.getDirection();
                        car.setDirection(1 * pi - difference);
                        car.setCurrentSpeed(0);
                    } else if (car.getDirection() <= 2 * pi) {
                        difference = 2 * pi - car.getDirection();
                        car.setDirection(difference + pi);
                        car.setCurrentSpeed(0);
                    }
                    //car.setX(800 - 100);
                    car.setX(800 - 100);
                    break;
            }
        }
    }

    public void assocFactoryVolvo() throws IOException {
        if (associations.size()<10) {
            expandAssociations(new Assoc(new Volvo240(), new Rectangle(100, 60), ImageIO.read(CarModel.class.getResourceAsStream("/pics/Volvo240.jpg"))));
            //addWidgetToView(associations.get(associations.size() - 1));
        }
    }

    public void assocFactorySaab() throws IOException {
        if (associations.size()<10){
            expandAssociations(new Assoc(new Saab95(), new Rectangle(100, 60), ImageIO.read(CarModel.class.getResourceAsStream("/pics/Saab95.jpg"))));
            //addWidgetToView(associations.get(associations.size()-1));
        }
    }

    public void assocFactoryScania() throws IOException {
        if (associations.size() < 10) {
            expandAssociations(new Assoc(new Scania(), new Rectangle(100, 60), ImageIO.read(CarModel.class.getResourceAsStream("/pics/Scania.jpg"))));
            //addWidgetToView(associations.get(associations.size() - 1));
        }
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Assoc association : associations) {
            association.automobile.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Assoc association : associations) {
            association.automobile.brake(amount);
        }
    }

    public void setTurboOn() {
        for (Assoc association : associations) {
            association.automobile.setTurboOn();/*
            if (association.automobile instanceof Saab95) {
                ((Saab95) association.automobile).setTurboOn();
            }*/
        }
    }

    public void setTurboOff() {
        for (Assoc association : associations) {
            association.automobile.setTurboOff();/*
            if (association.automobile instanceof Saab95) {
                ((Saab95) association.automobile).setTurboOff();
            }*/
        }
    }

    public void lowerBed() {
        for (Assoc association : associations) {
            association.automobile.lowerFlak();/*
            if (association.automobile instanceof Scania) {
                if (((Scania) association.automobile).flak != null)
                    ((Scania) association.automobile).flak.lowerFlak();
            }*/
        }
    }

    public void raiseBed() {
        for (Assoc association : associations) {
            association.automobile.raiseFlak();/*
            if (association.automobile instanceof Scania) {
                if (((Scania) association.automobile).flak != null)
                    ((Scania) association.automobile).flak.raiseFlak();
            }*/
        }
    }

    public void PURGE() {
        while (associations.size() > 0){
            associations.remove(0);
        }
        this.setChanged();
        this.notifyObservers();
    }

    public static int getMapX() {
        return mapX;
    }

    public static int getMapY() {
        return mapY;
    }
}
