public class Fleur {
    private String nom;
    private String couleur;

    public Fleur(){
        this("Rose");
    }

    public Fleur(String name, String couleur){
        nom = name;
        this.couleur = couleur;
    }

    public Fleur(String nom){
        this(nom, "rouge");
    }
    @Override
    public String toString(){
        return nom + " de couleur " + couleur;
    }

    public String getNom(){
        return nom;
    }
}