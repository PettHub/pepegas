import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class view1 extends JPanel implements Observer {
    int number;
    Main main;

    public view1(int x, int y) {
        JLabel yeetos = new JLabel("yeetos");
        yeetos.setBounds(0,0, x, y);
        this.add(yeetos);
        this.setSize(x, y);
        this.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        number = main.number;
        System.out.println(number);
    }
}
