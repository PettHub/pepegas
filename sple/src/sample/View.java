package sample;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    public View(int x, int y) throws HeadlessException {
        this.setPreferredSize(new Dimension(x, y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void printOut(){
        this.setTitle("test");

    }
}
