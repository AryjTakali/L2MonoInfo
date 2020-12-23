public class PointNomme{
    private Point p;
    public final String nom;

    public PointNomme(String nom){
        p = new Point(1,1);
        this.nom = nom;
    }

    public PointNomme(double x, double y, String nom){
        p = new Point(x,y);
        this.nom = nom;
    }
 
    public double getX() { 
        return p.getX(); 
    }

    public double getY() { 
       return p.getY(); 
    } 

    public String getNom(){
        return nom;
    }

    
     // public void move(double dx, double dy){ 
        // x+=dx; 
        // y+=dy;
    // }

    public Point move(double dx, double dy){ 
        return p.move( x+dx, y+dy);
    }

    public String toString(){
        return "nom : " + nom + p.toString();
    }


}