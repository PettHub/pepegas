package CarModelViewController;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    List<Assoc> vehicle = new ArrayList<>();


    // TODO: Make this genereal for all cars

    // TODO: Make this general for all cars
    void moveit(Assoc assoc) {
        assoc.rectangle.x = assoc.automobile.getX();
        assoc.rectangle.y = assoc.automobile.getY();
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {



        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.black);
        // Print an error message in case file is not found with a try/catch block
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Cars.Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

            //volvoImage = ImageIO.read(CarModelViewController.DrawPanel.class.getResourceAsStream("pics/Cars.Volvo240.jpg"));
            /*scaniaImage = ImageIO.read(CarModelViewController.DrawPanel.class.getResourceAsStream("pics/Trucks.Scania.jpg"));
            volvoImage = ImageIO.read(CarModelViewController.DrawPanel.class.getResourceAsStream("pics/Cars.Saab95.jpg"));*/
        }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Assoc assoc : vehicle){
        g.drawImage(assoc.bufferedImage, (int) assoc.rectangle.getX() , (int) assoc.rectangle.getY(), null); // see javadoc for more info on the parameters
        }
    }
}
