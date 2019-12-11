package CarModelViewController;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    //BufferedImage = volvoImage;
    ArrayList<BufferedImage> vehicleImage = new ArrayList<>();
    Assoc vehicle;
    // To keep track of a singel cars position
    Rectangle volvoPoint = new Rectangle();
    Wall[] walls = new Wall[4];


    // TODO: Make this genereal for all cars
    ArrayList<Rectangle> vehiclePoint = new ArrayList<Rectangle>();

    public void setVehiclePoint() {
        this.vehiclePoint.add(new Rectangle());
    }

    // TODO: Make this general for all cars
    void moveit(Assoc assoc) {
        assoc.rectangle.x = assoc.automobile.getX();
        assoc.rectangle.y = assoc.automobile.getY();
    }

    String hitWall(Rectangle r) {
        if (walls[0].rectangle.intersects(r)) {
            return "Upper";
        }
        if (walls[1].rectangle.intersects(r)) {
            return "Lower";
        }
        if (walls[2].rectangle.intersects(r)) {
            return "Left";
        }
        if (walls[3].rectangle.intersects(r)) {
            return "Right";
        }
        return "none";
    }
    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {

        walls[0] = new Wall(-400, -400, 1600, 400);
        walls[1] = new Wall(-400, 800 - 240, 1600, 400);
        walls[2] = new Wall(-400, 0, 400, 800 - 240);
        walls[3] = new Wall(800, 0, 400, 800 - 240);

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
        for (BufferedImage image : vehicleImage) {
            setVehiclePoint();
            vehiclePoint.get(vehiclePoint.size()-1).width =image.getWidth();
            vehiclePoint.get(vehiclePoint.size()-1).height =image.getHeight();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(vehicle.bufferedImage, (int) vehicle.rectangle.getX() , (int) vehicle.rectangle.getY(), null); // see javadoc for more info on the parameters

    }
}
