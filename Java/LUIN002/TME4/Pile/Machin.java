public class Machin {
    private String nom;
    private int valeur;

    public Machin(String nom, int val){
        this.nom = nom;
        valeur = val;
    }
    public Machin(String nom){
        this(nom, (int) (Math.random()*11));
    }

    public String getNom(){
        return nom;
    }

    public int getVal(){
        return valeur;
    }

    public String toString(){
        return nom + " de valeur " + valeur;
    }

}