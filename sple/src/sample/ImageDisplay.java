package sample;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageDisplay extends JPanel {
    BufferedImage image;
    public ImageDisplay() throws IOException {
        //image = ImageIO.read(ImageDisplay.class.getResourceAsStream("/pics/Smurf.jpg"));
        setImage("Smurf");
    }
    void setImage(String string) throws IOException {
        if (image != null)
            this.remove(0);
        this.setPreferredSize(new Dimension(800, 600));
        try {
            image = ImageIO.read(ImageDisplay.class.getResourceAsStream("/pics/" + string + ".jpg"));
        }
        catch (IOException e){ System.out.println("rekt");}
        JLabel picLabel = new JLabel(new ImageIcon(image));
        this.add(picLabel);
        this.setVisible(true);
    }
}