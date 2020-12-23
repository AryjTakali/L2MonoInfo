/*
    Probleme au niveau d'arrondis lors du calcul des rotations et problemes au niveau d'importation des packets
    J'essayerais de trouver une solution au plus vite et l'enverrai d'ici la fin de semaine fini.
*/
public class Vecteur {
    private double x;
    private double y;

    public Vecteur(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vecteur addition(Vecteur v1) {
        return new Vecteur(x + v1.getX(), y + v1.getY());
    }

    public Vecteur rotation(double teta) {
        double newX = x * Math.cos(teta) - y * Math.sin(teta);
        double newY = x * Math.sin(teta) + y * Math.cos(teta);
        return new Vecteur(newX, newY);
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public Vecteur clone(){
        return new Vecteur(x,y);
    }
    public void setVecteur(Vecteur v1) {
        x = v1.getX();
        y = v1.getY();
    }
}