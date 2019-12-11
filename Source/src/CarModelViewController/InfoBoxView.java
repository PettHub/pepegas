package CarModelViewController;
import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;


//i need dis in my life https://javatutorial.net/jframe-buttons-listeners-text-fields

public class InfoBoxView extends ABSTRACT_View {

    private String carNr;
    private String modelname;
    private int speed;

    public InfoBoxView(String carNr, String modelname, int speed) {
        this.carNr = carNr;
        this.modelname = modelname;
        this.speed = speed;
        this.setVisible(true);
        JLabel label = new JLabel(carNr + " (" + modelname + ") " + " : " + speed);
        label.setBounds(50,100,50,50);
        this.add(label);
    }

    public void updateInfoBox(int nrCars, String carNr, String modelname, int speed){
        this.setSize(100, 10*nrCars);

    }


}