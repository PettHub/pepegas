package CarModelViewController;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Cars.*;
import Trucks.*;

public class CarModel {

    public CarModel(CarView frame) {
        this.frame = frame;
        walls[0] = new Wall(-400, -400, getMapX()*2, 400); //tak
        walls[1] = new Wall(-400, getMapY(), getMapX()*2, 400);//botten
        walls[2] = new Wall(-400, 0, 400, getMapY());//vänster vägg
        walls[3] = new Wall(getMapX(), -400, 400, getMapY()*2);//höger vägg
    }
    Wall[] walls = new Wall[4];
    private static final int mapX = 800;
    private static final int mapY = 600;
    List<Widget> widgets = new ArrayList<>();
    CarView frame;
    List<Assoc> associations = new ArrayList<>();
    private final int delay = 50;
    Timer timer = new Timer(delay, new TimerListener());
    void addWidgetToView(Assoc assoc){
        //frame.add(new Widget(assoc));
        Widget tmp = new Widget(assoc);
        widgets.add(tmp);
        frame.add(tmp);
    }
   void updateSpeedWidgets() {
       for (Widget widget : widgets) {
           widget.update();
           frame.add(widget);
       }
   }
   private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Assoc association : associations) {
                association.automobile.move();
                frame.drawPanel.vehicle = associations;
                frame.drawPanel.moveit(association);
                ifHitWallChangeDirection(association.automobile, hitWall(association.rectangle));
                // repaint() calls the paintComponent method of the panel
            }
            updateSpeedWidgets();
            frame.drawPanel.repaint();

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

    void assocFactoryVolvo () throws IOException {
        if (associations.size()<10) {
            associations.add(new Assoc(new Volvo240(), new Rectangle(100, 60), ImageIO.read(CarModel.class.getResourceAsStream("/pics/Volvo240.jpg"))));
            addWidgetToView(associations.get(associations.size() - 1));
        }
    }
    void assocFactorySaab () throws IOException {
        if (associations.size()<10){
            associations.add(new Assoc(new Saab95(), new Rectangle(100, 60), ImageIO.read(CarModel.class.getResourceAsStream("/pics/Saab95.jpg"))));
            addWidgetToView(associations.get(associations.size()-1));
        }
    }
    void assocFactoryScania () throws IOException {
        if (associations.size() < 10) {
            associations.add(new Assoc(new Scania(), new Rectangle(100, 60), ImageIO.read(CarModel.class.getResourceAsStream("/pics/Scania.jpg"))));
            addWidgetToView(associations.get(associations.size() - 1));
        }
    }
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Assoc association : associations) {
            association.automobile.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Assoc association : associations) {
            association.automobile.brake(amount);
        }
    }

    void stop(){
        for (Assoc association : associations) {
            association.automobile.stopEngine();
        }
    }
    void start(){
        for (Assoc association : associations) {
            association.automobile.startEngine();
        }}

    public void setTurboOn() {
        for (Assoc association : associations) {
            if (association.automobile instanceof Saab95) {
                ((Saab95) association.automobile).setTurboOn();
            }
        }
    }

    void setTurboOff() {
        for (Assoc association : associations) {
            if (association.automobile instanceof Saab95) {
                ((Saab95) association.automobile).setTurboOff();
            }
        }
    }

    void lowerBed() {
        for (Assoc association : associations) {
            if (association.automobile instanceof Scania) {
                if (((Scania) association.automobile).flak != null)
                    ((Scania) association.automobile).flak.lowerFlak();
            }
        }
    }

    void raiseBed() {
        for (Assoc association : associations) {
            if (association.automobile instanceof Scania) {
                if (((Scania) association.automobile).flak != null)
                    ((Scania) association.automobile).flak.raiseFlak();
            }
        }
    }

    void PURGE() {

        /*int size = frame.drawPanel.vehicle.size();
        for (int i = 0; i < size; i++){
        frame.drawPanel.vehicle.remove(i);
        associations.remove(i);
        }*/
        for (Widget widget : widgets){
            widget.PURGE();
        }
        while (associations.size() > 0){
            frame.drawPanel.vehicle.remove(0);
            associations.remove(0);
            widgets.remove(0);
        }

    }

    public static int getMapX() {
        return mapX;
    }

    public static int getMapY() {
        return mapY;
    }


}
