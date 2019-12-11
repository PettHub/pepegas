import javax.swing.*;
import java.awt.*;

public class view2 extends JPanel {
    public view2(int x, int y) {
        JLabel yeet = new JLabel("yeet");
        yeet.setBounds(100,100, x, y);
        this.add(yeet);
        this.setSize(x, y);
        this.setVisible(true);
    }
}
