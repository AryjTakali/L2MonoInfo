class Instrument {
    protected final double poids; 
    protected final double prix;

    public Instrument(double poids, double prix){
        this.poids=poids;
        this.prix=prix;
    }

    public void jouer(){}
    public String getInstruName(){
        return "";
    }

    double getPrix(){
        return prix;
    }

    double getPoids(){
        return poids;
    }
    //si on definit un toString dans la class mere cela va surcharger la methode 
    public String toString(){
        return "Pese " + poids + "kg et coute " + prix ;
    }
}