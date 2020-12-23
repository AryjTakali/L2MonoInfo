public class Disque {
    private int rayon;
    private Disque dessus, dessous;

    public Disque(int rayon){
        if (rayon <= 0)//protection pour ne pas avoir de rayon negatif
            this.rayon = 5;
        else
            this.rayon = rayon;
    }

    boolean depiler(){
        if (dessus != null){
            System.out.print("Impossible de depiler le disque.");
            return false;
        }else{
            dessous.dessus = null;
            dessous = null;
            return true;
        }
    }

    boolean empilerSur(Disque d){
        if (dessus != null || (d != null && d.rayon > rayon)){
            System.out.print("Impossible d'empiler le disque.");
            return false;
        }else{
            if (dessous != null)
                depiler();
            if (d != null)
                d.dessus = this;
            dessous = d;
            return true;
        }
    }

    @Override
    public Disque clone(){
        return new Disque(rayon);
    }

    public int getRayon(){
        return rayon;
    }

    public Disque getDessous(){
        return dessous;
    }
    public Disque getDessus(){
        return dessus;
    }
}