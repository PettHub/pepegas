import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Automobile> cars = new ArrayList<>();


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Scania());
        cc.cars.add(new Saab95());


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int i = 0;
            for (Automobile car : cars) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(x, y, i);
                ifHitWallChangeDirection(car, frame.drawPanel.hitWall(i));
                //isAboutToHitWall(car, frame.drawPanel.aboutToHitWall());
                i++;
                // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();
                }
            }

            private void ifHitWallChangeDirection (Automobile car, String wallHit){
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
            private boolean isAboutToHitWall (Automobile car, String wallHit){
                switch (wallHit) {
                    case "Upper":
                        break;
                    case "Lower":
                        break;
                    case "Left":
                        break;
                    case "Right":
                        break;
                }
            return true;
        }

        }

        // Calls the gas method for each car once
        void gas(int amount) {
            double gas = ((double) amount) / 100;

                for (Automobile car : cars) {
                    car.gas(gas);
                }
            }

            void brake ( int amount){
                double brake = ((double) amount) / 100;
                for (Automobile car : cars) {
                    car.brake(brake);
                }
            }
            void setTurboOn () {
                for (Automobile car : cars) {
                    if (car instanceof Saab95) {
                        ((Saab95) car).setTurboOn();
                    }
                }
            }
            void setTurboOff () {
                for (Automobile car : cars) {
                    if (car instanceof Saab95) {
                        ((Saab95) car).setTurboOff();
                    }
                }
            }
            void lowerBed () {
                for (Automobile car : cars) {
                    if (car instanceof Scania) {
                        if (((Scania) car).flak != null)
                            ((Scania)car).flak.lowerFlak();
                    }
                }
            }
            void raiseBed () {
                for (Automobile car : cars) {
                    if (car instanceof Scania) {
                        if (((Scania) car).flak != null)
                            ((Scania)car).flak.raiseFlak();
                    }
                }
            }
        }
