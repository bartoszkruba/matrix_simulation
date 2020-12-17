package matrix.util;

import matrix.figures.Point;
import matrix.figures.Rectangle;

public class Collisions {

    public static boolean collides(Point point, Rectangle rectangle) {
        return point.getX() >= rectangle.getP1().getX() && point.getX() <= rectangle.getP2().getX() &&
                point.getY() >= rectangle.getP1().getY() && point.getY() <= rectangle.getP2().getY();
    }
}
