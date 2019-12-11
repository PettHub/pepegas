package CarModelViewController;

import Cars.Automobile;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Assoc {
    Automobile automobile;
    Rectangle rectangle;
    BufferedImage bufferedImage;

    public Assoc(Automobile automobile, Rectangle rectangle, BufferedImage bufferedImage) {
        this.automobile = automobile;
        this.rectangle = rectangle;
        this.bufferedImage = bufferedImage;
    }
    void updateAllLocations(){
        rectangle.x = this.automobile.getX();
        rectangle.y = this.automobile.getY();
    }
}
