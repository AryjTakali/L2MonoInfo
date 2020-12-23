import java.util.Random;

public class Emplacement {
    Carte carte;
    String nom;

    public Emplacement(String nom, Carte carte) {
        this.carte = carte;
        this.nom = nom;
    }

    public Emplacement(String nom) {
        this.nom = nom;
        carte = null;
    }

    public boolean estVide() {
        if (carte == null)
            return true;
        else
            return false;
    }

    public boolean poser(Carte carte) {
        if (estVide() == false)
            return false;
        else {
            this.carte = carte;
            return true;
        }
    }

    public Carte enlever() {
        if (estVide())
            return null;
        else {
            Carte temp = carte.clone();
            carte = null;
            return temp;
        }
    }

    public String toString() {
        if (carte == null)
            return nom + " : est vide";
        else
            return nom + " : " + carte.toString();
    }

    public String getEmplacement() {
        return nom;
    }

    public String getCarte() {
        if (carte == null)
            return "vide";
        else
            return carte.toString();
    }

    public static void main(String[] args) {
        Carte c1 = new Carte();
        Emplacement a = new Emplacement("a");

        int i = (int) (Math.random() * 3);

        System.out.println(i);
        System.out.println(a.toString());
        a.poser(c1);
        System.out.println(a.toString());
        a.enlever();
        System.out.println(a.toString());
    }
}