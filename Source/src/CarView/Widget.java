package CarView;

import Cars.Assoc;
import Cars.CarModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Widget extends JPanel implements Observer {
    List<Assoc> assocs = new ArrayList<>();
    List<JLabel> label = new ArrayList<>();
    CarModel world;
    CarView frame;

    public Widget(CarModel world, CarView frame){
        this.world = world;
        this.frame = frame;
        //this.setForeground(Color.green);
        //this.setBackground(Color.BLACK);
        this.setVisible(true);
        frame.add(this);
    }
    void addCar(Assoc assoc){
        assocs.add(assoc);
        JLabel tmp = new JLabel(assoc.getAutomobile().getModelName() + " : " + Math.round(assoc.getAutomobile().getCurrentSpeed()));
        label.add(tmp);
        this.add(tmp);
    }
    void updateCars(){
        for (int i = 0; i<assocs.size(); i++){
            label.get(i).setText(assocs.get(i).getAutomobile().getModelName() + " : " + Math.round(assocs.get(i).getAutomobile().getCurrentSpeed()));
            this.add(label.get(i));
        }
        //this.setPreferredSize(new Dimension(600, 100));
    }

    /*void PURGE() {
        this.removeAll();
        System.out.print("DEBOG PURGE()");
    }*/

    @Override
    public void update(Observable o, Object arg) {
        if (world.associations.size()>0){addCar(world.associations.get(world.associations.size()-1));}
        updateCars();
        System.out.print("DEBOG UPDATECARS() ");
    }
}
