public class Complexe {
    double reelle;
    double image;

    public Complexe(double reelle, double image) {
        this.reelle = round(reelle, 2);
        this.image = round(image, 2);
    }

    public Complexe() {
        this(Math.random() * 4 - 2, Math.random() * 4 - 2);
    }

    public double round(double nb, int decimal) {
        int div = 1;
        for (int i = 0; i < decimal; i++)
            div *= 10;
        nb = Math.round(nb * div);
        return nb / div;
    }

    public double getReelle() {
        return reelle;
    }

    public double getImage() {
        return image;
    }

    public String toString() {
        return "(" + reelle + ", " + image + "i )";
    }

    public boolean estReel() {
        if (image == 0.0)
            return true;
        else
            return false;
    }

    public boolean estImaginaire() {
        if (reelle == 0.0)
            return true;
        else
            return false;
    }

    public Complexe addition(Complexe c) {
        return new Complexe(reelle + c.getReelle(), image + c.getImage());
    }

    public Complexe multiplication(Complexe c) {
        return new Complexe(reelle * c.getReelle() - image * c.getImage(),
                reelle * c.getImage() + reelle * c.getReelle());
    }
}