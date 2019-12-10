import javax.swing.*;
import java.awt.*;

public class view2 extends JPanel {
    public view2(int x, int y) {
        this.add(new JLabel("yeet", SwingConstants.CENTER), BorderLayout.CENTER);
        this.setSize(x, y);
        this.setVisible(true);
    }
}
