
public class TestPoint {
    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(2, 3);
        Point p4 = p1;
        Point p5 = null;
        Point p6 = p5;
        p6 = new Point(3,4);
        p3 = p1;
        p1 = p4;

        System.out.println(p5);
        // System.out.println(p5.toString());
         System.out.println(p6);
         System.out.println(p6.toString());
        if (p1 == p2)
            System.out.println("p1 egale p2");
        if (p1 == p3)
            System.out.println("p1 egale p3");
        if (p1 == p4)
            System.out.println("p1 egale p4");
        if (p5 == null)
            System.out.println("p5 egale null");
        if (p6 == null)
            System.out.println("p6 egale null");
        if (p5 == p6)
            System.out.println("p5 egale p6");
        if (p1.equals(p2))
            System.out.println("p1 egale p2 (2)");
        if (p1.equals(p4))
            System.out.println("p1 egale p4 (2)");
    }
}