class Voiture extends AMoteur{
    private int nbPlaces;
    private static int nbCar = 0;
    private final int numCar;

    public Voiture(int nbPlaces){
        super(5);
        this.nbPlaces = nbPlaces;
        nbCar++;
        numCar = nbCar;
    }

    public void transporter(int n, int km){
        if (enPanne())
            System.out.println("Vehicule " + myNumId + ": Il n'y a plus d'essence pensez a faire le plein!");
        else{
            System.out.println("Vehicule " + myNumId + ": La voiture numero " + numCar + " a transporté " + nbPlaces + " personnes sur " + km + "km");
            rouler(km);
        }
        if (n > nbPlaces){
            System.out.println("Vehicule " + myNumId + ": Votre voiture ne contient que " + nbPlaces  +" places et vous transportez " + n + " personnes l'amende sera salé!");
        }
    }

    public String toString(){
        return "Numero d'identification = " + myNumId + " :\nIl s'agit de la voiture" + numCar + " et peut transporter "+  nbPlaces + " personnes." +  
        "\nDistance parcouru : " + getDistance() + "km." +
        "\ncapacite de reservoir : " + capaciteReservoir + "L" + 
        "\nNiveau d'essence : " + getNiveauEssence() + "\n";
    }
}