public class Roue {
    private int diametre;

    public Roue(int d) {
        diametre = d;
    }

    public Roue() {
        this(60);
    }

    public String toString() {
        return "Roue de " + diametre + " cm de diametre\n";
    }
}