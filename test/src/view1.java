import javax.swing.*;
import java.awt.*;

public class view1 extends JPanel {
    public view1(int x, int y) {
        this.add(new JLabel("yeetos", SwingConstants.CENTER), BorderLayout.CENTER);
        this.setSize(x, y);
        this.setVisible(true);
    }
}
