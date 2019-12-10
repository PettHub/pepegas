import javax.swing.*;
import java.awt.*;


public class combined extends JFrame {
    int x = 600;
    int y = 400;
    public combined(int x, int y) {
        this.setTitle("JFrameCenter Position");
        this.add(new JLabel("JFrame set to center of the screen", SwingConstants.CENTER), BorderLayout.CENTER);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        this.setVisible(true);
    }
    public static void main(String[] args) {
        view1 v1 = new view1(100, 100);
        view2 v2 = new view2(50, 200);
        combined comb = new combined(400, 500);
        comb.add(v1);
        comb.add(v2);
        comb.setVisible(true);
    }
}
