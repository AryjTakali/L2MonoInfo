public class Lampe {
    private boolean etat; // true allume, false eteinte

    public Lampe() {
        etat = false;
    }

    public Lampe(boolean etat) {
        this.etat = etat;
    }

    public boolean getEtat() {
        return etat;
    }

    public void switchEtat() {
        etat = !etat;
    }
}