package Cars;

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

    public Automobile getAutomobile() {
        return automobile;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }
    /*
    void updateAllLocations(){
        rectangle.x = this.automobile.getX();
        rectangle.y = this.automobile.getY();
    }*/
}
