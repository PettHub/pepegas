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
        JLabel tmp = new JLabel(assoc.getAutomobile().getModelName() + " : " + Math.round(assoc.getAutomobile().getCurrentSpeed()));
        label.add(tmp);
        this.add(tmp);
    }
    void updateCars(){
        for (int i = 0; i<world.associations.size(); i++){
            label.get(i).setText(world.associations.get(i).getAutomobile().getModelName() + " : " + Math.round(world.associations.get(i).getAutomobile().getCurrentSpeed()));
            //this.add(label.get(i));
        }
        //this.setPreferredSize(new Dimension(600, 100));
    }

    void PURGE() {
        for (JLabel labe : label){
            this.remove(labe);
        }
        while (label.size()>0){
            label.remove(0);
        }
        this.setVisible(false);
        System.out.print("DEBOG PURGE()");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (world.associations.size()>this.label.size()){
            addCar(world.associations.get(world.associations.size()-1));
            this.setVisible(true);
        }
        if (world.associations.size()<this.label.size()){
            PURGE();
        }
        updateCars();
        System.out.print("DEBOG UPDATECARS() ");
    }
}
