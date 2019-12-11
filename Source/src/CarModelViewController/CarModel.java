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
    }

    void addAllTheWidgets() {
        for (JPanel panel : views) {
            this.frame.add(panel);
        }
    }

    private Random rm = new Random();
    private static final int mapX = 800;
    private static final int mapY = 800;
    Widget carCounter;
    CarView frame;
    List<JPanel> views = new ArrayList<>();
    List<Assoc> associations = new ArrayList<>();
    private final int delay = 50;
    Timer timer = new Timer(delay, new TimerListener());
    void addWidgetToView(Assoc assoc){
        frame.add(new Widget(assoc));
    };
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Assoc association : associations) {
                association.automobile.move();
                frame.drawPanel.vehicle = association;
                frame.drawPanel.moveit(association);
                ifHitWallChangeDirection(association.automobile, frame.drawPanel.hitWall(association.rectangle));
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
        //Tänker att man lägger in något här ovan så att den säger till att den i NewView skriver ut grejer. drawPanel?

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
                    } else {
                        difference = 1.5 * pi - car.getDirection();
                        car.setDirection(0.5 * pi + difference);
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
                    car.setY(800 - (240 + 60));
                    break;
                case "Left":
                    if (car.getDirection() >= 1 * pi) {
                        difference = car.getDirection() - 1 * pi;
                        car.setDirection(2 * pi - difference);
                    } else {
                        difference = 1 * pi - car.getDirection();
                        car.setDirection(difference);
                    }
                    car.setX(0);
                    break;
                case "Right":
                    if (car.getDirection() >= 0 * pi) {
                        difference = car.getDirection();
                        car.setDirection(1 * pi - difference);
                    } else if (car.getDirection() <= 2 * pi) {
                        difference = 2 * pi - car.getDirection();
                        car.setDirection(difference + pi);
                    }
                    car.setX(800 - 100);
                    break;
            }
        }
    }

    void assocFactoryVolvo () throws IOException {
        if (associations.size()<10)
            associations.add(new Assoc(new Volvo240(), new Rectangle(2, 4), ImageIO.read(CarModel.class.getResourceAsStream("/pics/Volvo240.jpg"))));
    }
    void assocFactorySaab () throws IOException {
        if (associations.size()<10)
            associations.add(new Assoc(new Saab95(), new Rectangle(2, 4), ImageIO.read(CarModel.class.getResourceAsStream("/pics/Saab95.jpg"))));
    }
    void assocFactoryScania () throws IOException {
        if (associations.size()<10)
            associations.add(new Assoc(new Scania(), new Rectangle(2, 4), ImageIO.read(CarModel.class.getResourceAsStream("/pics/Scania.jpg"))));
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

    public static int getMapX() {
        return mapX;
    }

    public static int getMapY() {
        return mapY;
    }
}
