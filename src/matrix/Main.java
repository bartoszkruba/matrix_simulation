package matrix;

import matrix.figures.Point;
import matrix.figures.Rectangle;
import matrix.io.InputReader;
import matrix.util.Collisions;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            runProgram(scanner);
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    private static void runProgram(Scanner scanner) {
        InputReader inputReader = new InputReader(scanner);
        long[] header = inputReader.readHeader();

        Rectangle rectangle = new Rectangle(new Point(0, 0), new Point(header[0] - 1, header[1] - 1));
        Point point = new Point(header[2], header[3]);

        // direction in degrees
        double direction = 0;
        int command;

        while (Collisions.collides(point, rectangle) && (command = inputReader.readCommand()) != 0) {

            switch (command) {
                case 1:
                    point.setX((point.getX() + Math.sin(Math.toRadians(direction))));
                    point.setY((point.getY() - Math.cos(Math.toRadians(direction))));
                    break;
                case 2:
                    point.setX((point.getX() - Math.sin(Math.toRadians(direction))));
                    point.setY((point.getY() + Math.cos(Math.toRadians(direction))));
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

        if (!Collisions.collides(point, rectangle)) {
            System.out.println("[-1, -1]");
        } else {
            System.out.println("[" + ((int) Math.round(point.getX())) + ", " + ((int) Math.round(point.getY())) + "]");
        }
    }

}
