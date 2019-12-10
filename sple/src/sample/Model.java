package sample;


import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Model {
    int x = 800;
    int y = 700;
    Timer timer = new Timer();
    ImageDisplay im;
    View view = new View(x, y);
    List<JPanel> widgets = new ArrayList<>();

    public Model(ImageDisplay im) {
        this.im = im;
    }

    void addToView(JPanel panel){
    widgets.add(panel);
    }
    void addAllViews(){
        for (JPanel panel : widgets){
            view.add(panel);
        }

    }
    public static void main(String[] args) {
    }
}
