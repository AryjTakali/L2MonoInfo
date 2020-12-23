public class Point {
    private double x, y;

    public Point(double x1, double y1) {
        x = x1;
        y = y1;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
    public Point add(Point p1) {
        return new Point(x + p1.x, y + p1.y);
    }
}