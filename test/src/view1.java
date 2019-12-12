import javax.swing.*;
import java.awt.*;

public class view1 extends JPanel {
    public view1(int x, int y) {
        JLabel yeetos = new JLabel("yeetos");
        yeetos.setBounds(0,0, x, y);
        this.add(yeetos);
        this.setSize(x, y);
        this.setVisible(true);
    }
}
