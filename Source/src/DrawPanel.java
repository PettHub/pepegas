import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    //BufferedImage = volvoImage;
    ArrayList<BufferedImage> vehicleImage = new ArrayList<>();

    // To keep track of a singel cars position
    Rectangle volvoPoint = new Rectangle();
    Wall[] walls = new Wall[4];


    // TODO: Make this genereal for all cars
    ArrayList<Rectangle> vehiclePoint = new ArrayList<Rectangle>();

    public void setVehiclePoint() {
        this.vehiclePoint.add(new Rectangle());
    }

    // TODO: Make this general for all cars
    void moveit(int x, int y, int index) {
        vehiclePoint.get(index).x = x;
        vehiclePoint.get(index).y = y;
    }

    String hitWall(int index) {
        if (walls[0].rectangle.intersects(vehiclePoint.get(index))) {
            return "Upper";
        }
        if (walls[1].rectangle.intersects(vehiclePoint.get(index))) {
            return "Lower";
        }
        if (walls[2].rectangle.intersects(vehiclePoint.get(index))) {
            return "Left";
        }
        if (walls[3].rectangle.intersects(vehiclePoint.get(index))) {
            return "Right";
        }
        return "none";
    }
/*
    String aboutToHitWall(Automobile auto, int index) {
        for (int i = 0; i < 4; i++) {
//<<<<<<< HEAD
            Rectangle tmp = walls[i].rectangle;
            if (i == 0 && tmp.intersects(volvoPoint)) {
//=======
                Rectangle tmpWall = walls[i].rectangle;
                Rectangle tmpAuto = new Rectangle();
                tmpAuto.x = (int) Math.round(auto.getX() + auto.getDx());
                tmpAuto.y = (int) Math.round(auto.getX() + auto.getDx());
                tmpAuto.width = vehiclePoint.get(index).width;
                tmpAuto.height = vehiclePoint.get(index).height;


                if (i == 0 && tmpWall.intersects(tmpAuto)) {
//>>>>>>> c515501afffac0e6f88f7ea5fa91db443d41d75d
                    return "Upper";
                }
                if (i == 1 && tmpWall.intersects(tmpAuto)) {
                    return "Lower";
                }
                if (i == 2 && tmpWall.intersects(tmpAuto)) {
                    return "Left";
                }
                if (i == 3 && tmpWall.intersects(tmpAuto)) {
                    return "Right";
                }
            }
            return "none";
        }
    }
*/

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
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

            //volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            /*scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));*/
            vehicleImage.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            vehicleImage.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
            vehicleImage.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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

        for (int i = 0; i < vehicleImage.size(); i++) {
            g.drawImage(vehicleImage.get(i), vehiclePoint.get(i).x , vehiclePoint.get(i).y, null); // see javadoc for more info on the parameters
            //g.drawImage(vehicleImage.get(i), vehiclePoint.get(i).x, vehiclePoint.get(i).y, null); // see javadoc for more info on the parameters
        }
    }
}
