package CarModelViewController;

import javax.swing.*;
import java.awt.*;

public class Widget extends JPanel {
    Assoc assoc;
    JLabel label;
    public Widget(Assoc assoc){
        this.assoc = assoc;
        label = new JLabel(assoc.automobile.getModelName() + " : " + (assoc.automobile.getCurrentSpeed()));
        this.add(label);
        this.setVisible(true);
    }
    void update(){
        this.label.updateUI();
    }
}
