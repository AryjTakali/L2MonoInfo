class Velo extends SansMoteur{
    private final int nbVitesse;
    private static int nbVelo = 0;
    private final int numVelo;

    public Velo(int nbVitesse){
        super();
        this.nbVitesse = nbVitesse;
        nbVelo++;
        numVelo = nbVelo;
    }

    public int getNbVelo(){
        return nbVelo;
    }

    public void transporter(String depart, String arrivee){
        System.out.println("Le velo numero "+ numVelo + " a roule de " + depart + " a " + arrivee);
    }

    public String toString(){
        return "Le velo " + numVelo + " a pour id " + myNumId + " et a parcouru " + getDistance() + "km";
    }

}