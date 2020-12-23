public class Couple {
    private int x, y;

    public Couple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Couple addition(Couple p) {
        return new Couple(x + p.getX(), y + getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}