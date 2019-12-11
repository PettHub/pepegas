package CarModelViewController;

import javax.swing.*;

public class Widget extends JPanel {
    public Widget(Assoc assoc){
        this.add(new JLabel(assoc.automobile.getModelName() + " : " + (assoc.automobile.getCurrentSpeed())));
        this.setVisible(true);
    }
}
