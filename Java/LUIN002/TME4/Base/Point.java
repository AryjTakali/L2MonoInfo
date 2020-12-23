import java.util.Random;

public class Point {
    private double x, y;

    public Point() {
        x = Math.round(Math.random() * 10);
        y = Math.round(Math.random() * 10);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        double[] d = new double[10];
        Point[] p = new Point[10];
        int[] t1 = { 1, 2, 3 };

        for (int i = 0; i < d.length; i++) {
            d[i] = Math.random();
            p[i] = new Point();
        }

        for (int i = 0; i < d.length; i++) {
            System.out.println("double : " + d[i]);
            System.out.println("Point : " + p[i].toString());
        }

        int[] t2 = { 1, 2, 3 };
        int[] t3 = t1;
        System.out.println(t1 == t2);// false
        System.out.println(t1 == t3);// true
        // l'egalite entre tableau est identique a celle des objets
        // elle test l'egalite des references != valeurs
    }
}