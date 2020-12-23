public class Rectangle extends Shape{
    private double largeur;
    private double longueur;

    public Rectangle(){
        super();
        largeur = 1;
        longueur = 1;
    }

    public Rectangle(double x, double y, double largeur, double longueur){
        super(x, y);
        this.largeur = largeur;
        this.longueur = longueur;
    }

    public double surface(){
        return longueur * largeur;
    }

    public String toString(){
        return super.toString() + " Longueur : " + longueur + " Largeur : " + largeur ;
    }
}