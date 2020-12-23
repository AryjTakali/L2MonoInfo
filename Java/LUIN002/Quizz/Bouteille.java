
public class Bouteille {
    private double volume;

    public Bouteille(double volume) {
        this.volume = volume;
    }

    public Bouteille() {
        this(1.5);
    }

    public void remplir(Bouteille b) {
        volume += b.getVolume();
    }

    public String toString() {
        return ("Volume du liquide dans la bouteille = " + volume);
    }

    public double getVolume() {
        return volume;
    }
}