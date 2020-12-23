class Camion extends AMoteur{
    private double volume;
    private static int nbCamion = 0;
    private int numCamion;

    public Camion(double volume){
        super(10);
        this.volume = volume;
        nbCamion++;
        numCamion = nbCamion;
    }


    public void transporter(String materiaux, int km){
        if (enPanne())
            System.out.println("Vehicule " + myNumId + " : Il n'y a plus d'essence pensez a faire le plein!");
        else{
            System.out.println("Vehicule " + myNumId + " : La camion numero " + numCamion + " a transporté " + materiaux + " sur " + km + "km");
            rouler(km);
        }
    }

    public String toString(){
        return "Numero d'identification = " + myNumId +" :\nIl s'agit du camion " + numCamion + " et peut transporter "+  volume + "Litres de materiaux."+ 
        "\nDistance parcouru : " + getDistance() + "km." +
        "\ncapacite de reservoir : " + capaciteReservoir + "L" + 
        "\nNiveau d'essence : " + getNiveauEssence() +"\n";
    }
}