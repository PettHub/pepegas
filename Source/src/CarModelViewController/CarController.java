package CarModelViewController;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CarController extends JPanel{
    CarModel model;
    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");
    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Trucks.Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");
    JButton addCarButton = new JButton("Create new car");
    JPanel carList = new JPanel();
    JButton addVolvo = new JButton("Volvo240");
    JButton addSaab = new JButton("Saab95");
    JButton addScania = new JButton("Scania");
    JButton PURGE = new JButton("PURGE");

    // Constructor

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initButtons() {
        this.setPreferredSize(new Dimension(CarModel.getMapX(),CarModel.getMapY()));
        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, //initial value
                0, //min
                100, //max
                1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        this.add(gasPanel);
        controlPanel.setLayout(new GridLayout(2,4));
        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((CarModel.getMapX()/3), 100));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(CarModel.getMapX()/6,100));
        this.add(startButton);
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(CarModel.getMapX()/6,100));
        this.add(stopButton);
        addCarButton.setBackground(Color.GREEN);
        addCarButton.setForeground(Color.black);
        addCarButton.setPreferredSize(new Dimension(CarModel.getMapX()/6,100));
        this.add(addCarButton);
        carList.add(addVolvo, 0);
        carList.add(addSaab, 1);
        carList.add(addScania, 2);
        carList.setPreferredSize(new Dimension((CarModel.getMapX()/3), 100));
        carList.setVisible(false);
        this.add(carList);
        PURGE.setBackground(Color.RED);
        PURGE.setForeground(Color.blue);
        PURGE.setPreferredSize(new Dimension(CarModel.getMapX(),100));
        this.add(PURGE);
        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary

        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gas(gasAmount);
            }
        });
        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.brake(gasAmount);
            }
        });
        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setTurboOn();
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setTurboOff();
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.raiseBed();
            }
        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.lowerBed();
            }
        });

        PURGE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.PURGE();
            }
        });

        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCarButton.setVisible(false);
                carList.setVisible(true);
            }
        });
        addVolvo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    model.assocFactoryVolvo();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                addCarButton.setVisible(true);
                carList.setVisible(false);
            }
        });
        addSaab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    model.assocFactorySaab();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                addCarButton.setVisible(true);
                carList.setVisible(false);
            }
        });
        addScania.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    model.assocFactoryScania();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                addCarButton.setVisible(true);
                carList.setVisible(false);
            }
        });

        // Get the computer screen resolution
        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        //this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
    }
    public CarController(CarModel model) {
        this.model = model;
        initButtons();
    }

    public static void main(String[] args) {
        // Instance of this class
        CarModel model = new CarModel(new CarView("Car sim 2.0", CarModel.getMapX(), CarModel.getMapY()));
        CarController cc = new CarController(model);
        cc.model.frame.add(cc);
        cc.model.frame.setVisible(true);
        // Start the timer
        model.timer.start();
    }
    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */

}
