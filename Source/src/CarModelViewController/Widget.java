package CarModelViewController;

import javax.swing.*;
import java.awt.*;

public class Widget extends JPanel {
    Assoc assoc;
    JLabel label;
    public Widget(Assoc assoc){
        this.assoc = assoc;
        label = new JLabel(assoc.automobile.getModelName() + " : " + Math.round(assoc.automobile.getCurrentSpeed()));
        //label.setSize(100,20);
        label.setForeground(Color.green);
        this.add(label);
        this.setVisible(true);
    }
    void update(){
        label.setText(assoc.automobile.getModelName() + " : " + Math.round(assoc.automobile.getCurrentSpeed()));
    }

    void PURGE() {
    this.setVisible(false);
    }
}
