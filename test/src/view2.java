import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class view2 extends JPanel implements Observer {
    Observable main;

    public view2(int x, int y) {
        JLabel yeet = new JLabel("yeet");
        yeet.setBounds(100,100, x, y);
        this.add(yeet);
        this.setSize(x, y);
        this.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
    System.out.println(arg);
    }
}
