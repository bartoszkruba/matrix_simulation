package matrix.figures;

public class Rectangle {

    private Point point1;

    private Point point2;

    public Rectangle(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public boolean collides(Point point) {
        return point.getX() >= point1.getX() && point.getX() <= point2.getX() &&
                point.getY() >= point1.getY() && point.getY() <= point2.getY();
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }
}
