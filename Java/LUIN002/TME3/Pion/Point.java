public class Point {
    private double x, y;

    public Point() {
        x = round(Math.random(), 2);
        y = round(Math.random(), 2);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double round(double nb, int decimal) {
        int div = 1;
        for (int i = 0; i < decimal; i++)
            div *= 10;
        nb = Math.round(nb * div);
        return nb / div;
    }

    public Point clone() {
        return new Point(x, y);
    }

    public void bouger() {
        x = Math.random();
        y = Math.random();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}