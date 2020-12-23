public class Tracteur {
    private Cabine cabine;
    private Roue r1, r2, r3, r4;

    public Tracteur(Cabine cabine, Roue r1, Roue r2, Roue r3, Roue r4) {
        this.cabine = cabine;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;
    }

    public String toString() {
        return cabine.toString() + "\nLe tracteur a 4 roues:\n" + r1.toString() + r2.toString() + r3.toString()
                + r4.toString();
    }

    public void peindre(String couleur) {
        cabine.setCouleur(couleur);
    }
}