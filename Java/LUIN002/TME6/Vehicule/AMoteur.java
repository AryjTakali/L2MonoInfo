class AMoteur extends Vehicule{
    protected final double capaciteReservoir;
    private double niveauEssence;

    public AMoteur(double capaciteReservoir){
        super();
        niveauEssence = 0;
        this.capaciteReservoir = capaciteReservoir;
    }

//on pourrait faire perdre de l'essence a chaque km parcouru mais j'ai un peu la flemme
    public void Approvisionner(double nbL){
        if (nbL < 0)
            System.out.println("Vehicule " + myNumId +": Oh non vous vous etes fait siffoner!");
        niveauEssence += nbL;
        if (niveauEssence >= capaciteReservoir){
            System.out.printf("Vehicule %d : %s\n",myNumId, niveauEssence > capaciteReservoir ? "Votre niveau d'essence a débordé!" : "Votre resevoir est plein.");
            niveauEssence = capaciteReservoir;
        }
        if (niveauEssence <= 0){
            niveauEssence = 0;
            System.out.println("Vehicule " + myNumId + ": Votre niveau d'essence est vide!");
        }
    }

    public double getNiveauEssence(){
        return niveauEssence;
    }
    public boolean enPanne(){
        return niveauEssence <= 0;
    }

//comme les parametres des 2 fonction transporter sont differents on peut les factoriser
    public void transporter(String materiaux, int km){}
    public void transporter(int n, int km){}

    public String toString(){
        return "Il s'agit d'un vehicule avec moteur.\nNumero d'identification = " + myNumId + 
        "\nDistance parcouru : " + getDistance() + "km." +
        "\ncapacite de reservoir : " + capaciteReservoir + "L" + 
        "\nNiveau d'essence : " + niveauEssence + "\n";
    }

}