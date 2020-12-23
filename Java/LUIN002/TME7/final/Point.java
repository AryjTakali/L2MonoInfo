public final class Point {

    private final double x , y ;
    private static int cpt = 0; 
    private int id ;

    public Point(double x , double y) {
    this.x = x; 
    this.y = y; 
    id = cpt++;
    }

    public double getX() { 
        return x; 
    }

    public double getY() { 
       return y; 
    } 

     // public void move(double dx, double dy){ 
        // x+=dx; 
        // y+=dy;
    // }

    public Point move(double dx, double dy){ 
        return new Point( x+dx, y+dy);
    }

    public String toString(){
        return "Point␣[x=" + x + ",␣y=" + y + "]";
    }

}