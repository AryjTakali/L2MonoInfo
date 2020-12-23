
public class Pion {
    private String nom;
    private Point posx;

    public Pion(String n, Point x) {
        nom = n;
        posx = x.clone();
    }

    public Pion(String n) {
        nom = n;
        posx = new Point();
    }

    public Pion(Pion p) {
        nom = p.nom;
        posx = p.posx.clone();
    }

    public String toString() {
        return nom + " est en position : (" + posx.getX() + ", " + posx.getY() + ")\n";
    }

    public Pion clone() {
        return new Pion(nom, posx.clone());
    }

    public void setNom(String n) {
        System.out.println(nom + " a change de nom et se nomme maintenant " + n + "\n");
        nom = n;
    }

    public String getNom() {
        return nom;
    }

    public void seDeplacer() {
        System.out.println(nom + " s'est deplace\n");
        posx.bouger();
    }
}