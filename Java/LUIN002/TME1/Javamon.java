
public class Javamon {
    String nom;
    int pv;
    double force;
    double bouclier;
    double vitalite;

    // attention la somme force + bouclier + vitalite = 1
    public Javamon(String name, double force, double bouclier, double vit) {
        this.nom = name;
        this.force = force;
        this.bouclier = bouclier;
        this.vitalite = vit;
        pv = (int) ((Math.random() * 50) * vitalite);
    }

    public Javamon(String name) {
        this.nom = name;
        this.force = Math.random();
        this.bouclier = Math.random() * (1 - force);
        this.vitalite = 1 - (bouclier + force);
        // pv = (int) ((Math.random() * 50) * vitalite) + 50;
    }

    @Override
    public String toString() {
        return nom + "(" + force + ", " + bouclier + ", " + vitalite + ") : " + pv;
    }

    public boolean estMort() {
        return pv <= 0;
    }

    public void infligerDommage(int p) {
        this.pv = pv - p;
    }

    public void initCombat() {
        pv = (int) ((Math.random() * 50) * vitalite) + 50;
    }

    public double getAttaque() {
        return Math.random() * (force);
    }

    public double getDefense() {
        return Math.random() * (bouclier);
    }

    public String getName() {
        return nom;
    }

    public double getForce() {
        return force;
    }

    public double getBouclier() {
        return bouclier;
    }

    public double getVitalite() {
        return vitalite;
    }

    public double getPV() {
        return pv;
    }
/*
    public static void main(String[] args) {
        Javamon p1 = new Javamon("test");
        p1.initCombat();
        // double test = p1.getForce() + p1.getBouclier() + p1.getVitalite();
        System.out.println(p1.toString());
        System.out.println("AVANT");
        System.out.println((int)(p1.getAttaque()*10));
        p1.infligerDommage((int)p1.getAttaque()*10);
        System.out.println(p1.toString());

    }*/
}
