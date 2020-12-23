public class Tour {
    private String nom;
    private Disque disqueHaut;
    static int tailleTour = 5;

    public Tour(String nom, int nb){
        this.nom = nom;
        if (nb != 0)
            tailleTour = nb + 1;
        Disque[] d = new Disque[tailleTour];
        for (int i = 0; i < d.length; i++){
            d[i] = new Disque(nb - i);
            empiler(d[i]);
        }
        disqueHaut = d[d.length];
    }

    public boolean estVide(){
        return disqueHaut == null;
    }
    
    public String getNom(){
        return nom;
    }

    @Override
    public String toString(){
        String s = nom + " : ";
        if (disqueHaut == null)
            s += "est vide.";
        else{
            Disque tmp = disqueHaut;
            while (tmp != null)
                s += tmp.getRayon() + " ";
                tmp = tmp.getDessous();
            }
        return s + '\n'; 
    }
    
    private boolean empiler(Disque d){
        if (d.empilerSur(disqueHaut) == true)
            return true;
        else
            return false;
    }

    public boolean bougerVers(Tour t){
        if (estVide() == false && t.disqueHaut.getRayon() >= disqueHaut.getRayon()){
           return (empiler(t.disqueHaut)); 
        } else
            return false;
    }

}