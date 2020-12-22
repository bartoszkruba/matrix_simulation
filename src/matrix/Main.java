package matrix;

import matrix.figures.Point;
import matrix.figures.Rectangle;
import matrix.io.InputReader;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            runProgram(scanner);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void runProgram(Scanner scanner) {
        InputReader inputReader = new InputReader(scanner);
        long[] header = inputReader.readHeader();

        Rectangle rectangle = new Rectangle(new Point(0, 0), new Point(header[0] - 1, header[1] - 1));
        Point point = new Point(header[2], header[3]);

        // direction in degrees
        double direction = 0;

        int[] commands = inputReader.readCommands();

        for (int command : commands) {
            switch (command) {
                case 1:
                    point.setX(roundToInt(point.getX() + Math.sin(Math.toRadians(direction))));
                    point.setY(roundToInt(point.getY() - Math.cos(Math.toRadians(direction))));
                    if (!rectangle.collides(point)) break;
                    break;
                case 2:
                    point.setX(roundToInt(point.getX() - Math.sin(Math.toRadians(direction))));
                    point.setY(roundToInt(point.getY() + Math.cos(Math.toRadians(direction))));
                    if (!rectangle.collides(point)) break;
                    break;
                case 3:
                    direction += 90;
                    break;
                case 4:
                    direction -= 90;
                    break;
            }

            direction %= 360;
        }

        if (!rectangle.collides(point)) {
            System.out.println("[-1, -1]");
        } else {
            System.out.println("[" + (point.getX()) + ", " + point.getY() + "]");
        }
    }

    private static int roundToInt(double value) {
        return (int) Math.round(value);
    }

}
