public class Cabine {
    private double volume;
    private String couleur;

    public Cabine(double v, String couleur) {
        volume = v;
        this.couleur = couleur;
    }

    public String toString() {
        return "La cabine " + couleur + " a un volume de : " + volume + " m3.";
    }

    public double getVolume() {
        return volume;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String col) {
        couleur = col;
    }
}