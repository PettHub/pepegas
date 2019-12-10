package CarModelViewController;

import java.awt.*;

public class Wall {
     Rectangle rectangle = new Rectangle();

    public Wall(int x, int y, int width, int height) {
        rectangle.x = x;
        rectangle.y = y;
        rectangle.width = width;
        rectangle.height = height;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
