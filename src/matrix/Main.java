package matrix;

import matrix.figures.Point;
import matrix.figures.Rectangle;
import matrix.util.Collisions;

public class Main {

    public static void main(String[] args) {
        runProgram();
    }

    private static void runProgram() {
        Point point = new Point(0, 0);
        Rectangle rectangle = new Rectangle(new Point(0, 0), new Point(10, 10));

        Collisions.collides(point, rectangle);
    }
}
