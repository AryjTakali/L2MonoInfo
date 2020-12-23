public class Point {
private int x , y ; // coordonnees

    public Point(int a, int b) {
        x=a;
        y=b;
    }
 
    public Point(){
        x=0;
        y=0;
    }

    public Point(Point p){
        x=p.x;
        y=p.y;
    }

    public boolean equals(Object o){
        if (o == null)
            return false;
        if (this == o)
            return true;
        if (o instanceof Point){
            Point e = (Point)o;
            return (x == e.x) && (y == e.y);

        }
        return false;
    }

    public static void main(String args[]){
        Point p1 = new Point(5, 2);
        Point p2 = new Point(5, 2);
        Point p3 = p1;
        Point p4 = new Point(1, 1);
    
        System.out.println("p1=p2 : " + p1.equals(p2));
        System.out.println("p1=p3 : " + p1.equals(p3));
        System.out.println("p1=p4 : " + p1.equals(p4));
        String s1 = new String("Bonjour");
        System.out.println("p1=s1 : " + p1.equals(s1));
    }

}
